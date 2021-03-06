package angmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"angmvc.core.dao", "angmvc.core.utils"})
public class TestContext {
}
