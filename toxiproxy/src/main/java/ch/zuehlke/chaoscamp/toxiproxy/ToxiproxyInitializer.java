package ch.zuehlke.chaoscamp.toxiproxy;

import eu.rekawek.toxiproxy.Proxy;
import eu.rekawek.toxiproxy.ToxiproxyClient;
import eu.rekawek.toxiproxy.model.ToxicDirection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
public class ToxiproxyInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToxiproxyInitializer.class);

    private static final String PROXY_HASHER = "hasher";

    private final ToxiproxyClient client;

    @Value("${toxiproxy.hasher.listen}")
    private String hasherListen;

    @Value("${toxiproxy.hasher.upstream}")
    private String hasherUpstream;

    @Value("${toxiproxy.hasher.latency.millis}")
    private long hasherLatency;

    @Value("${toxiproxy.hasher.latency.jitter.millis}")
    private long hasherLatencyJitter;

    public ToxiproxyInitializer(
            @Value("${toxiproxy.client.host}") String host,
            @Value("${toxiproxy.client.port}") int port) {
        client = new ToxiproxyClient(host, port);
    }


    @PostConstruct
    private void init() throws IOException {

        LOGGER.info("Toxiproxy client version '{}'", client.version());

        deleteProxy(PROXY_HASHER);

        Proxy hasherProxy = createProxy(PROXY_HASHER, hasherListen, hasherUpstream);

        configureLatency(hasherProxy, hasherLatency, hasherLatencyJitter);
    }

    private void configureLatency(Proxy proxy, long latency, long jitter) throws IOException {
        proxy.toxics().latency(proxy.getName() + "-latency-toxic", ToxicDirection.DOWNSTREAM, latency).setJitter(jitter);
        LOGGER.info("Configured latency for proxy '{}', latency={}, jitter={}", proxy.getName(), latency, jitter);
    }

    private Proxy createProxy(String proxyName, String listen, String upstream) throws IOException {
        Proxy proxy = client.createProxy(proxyName, listen, upstream);
        LOGGER.info("Created proxy '{}', listen={}, upstream={}", proxy.getName(), proxy.getListen(), proxy.getUpstream());
        return proxy;
    }

    @PreDestroy
    public void onDestroy() throws Exception {
        deleteProxy(PROXY_HASHER);
    }

    private void deleteProxy(String proxyName) throws IOException {
        if (client != null) {
            Proxy proxy = client.getProxyOrNull(proxyName);
            if (proxy != null) {
                proxy.delete();
                LOGGER.info("Deleted proxy '{}'", proxyName);
            }
        }
    }
}
