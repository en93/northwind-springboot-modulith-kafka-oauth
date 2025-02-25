package en93.sample.northwindmodulith.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//todo see if can remove explicit config after upgrading spring versions
@EnableJpaRepositories(basePackages = "en93.sample.northwindmodulith")
@EntityScan(basePackages = "en93.sample.northwindmodulith")
@Configuration
public class JPAConfig {
}
