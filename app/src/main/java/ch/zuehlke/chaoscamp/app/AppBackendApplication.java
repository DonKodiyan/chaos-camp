package ch.zuehlke.chaoscamp.app;

import io.micrometer.core.instrument.MeterRegistry;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
@EnableSwagger2WebFlux
public class AppBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(AppBackendApplication.class, args);
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
