package ch.zuehlke.chaoscamp.hasher;

import io.micrometer.core.instrument.MeterRegistry;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
@EnableSwagger2WebFlux
@EnableScheduling
public class HasherBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(HasherBackendApplication.class, args);
  }

  @Configuration
  public class MetricsConfig {

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> commonTags() {
      String hostname = Optional.ofNullable(System.getenv().get("HOSTNAME")).orElse("localhost");
      return r -> r.config().commonTags("pod_name", hostname);
    }
  }
}
