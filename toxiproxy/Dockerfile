FROM shopify/toxiproxy:latest

# expose port for proxy to chaoscamp-hasher
EXPOSE 8082

COPY toxiproxy.conf.json ./toxiproxy.conf.json
ENTRYPOINT ["/go/bin/toxiproxy", "-config", "toxiproxy.conf.json", "-host", "0.0.0.0"]