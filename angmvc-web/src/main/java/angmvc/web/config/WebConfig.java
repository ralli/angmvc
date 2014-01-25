package angmvc.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"angmvc"})
public class WebConfig extends WebMvcConfigurerAdapter {
  private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    log.info("Adding resource path handler...");
    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  @Bean
  public ViewResolver viewResolver() {
    log.info("Registering view resolver...");
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Bean
  public MessageSource messageSource() {
    log.info("creating message source");
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("WEB-INF/messages/validation");
    messageSource.setCacheSeconds(0);
    log.info("message source = {}", messageSource);
    return messageSource;
  }
  @Bean
  public Validator validator() {
    log.info("Registering validator...");
    LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
    validatorFactoryBean.setValidationMessageSource(messageSource());
    return validatorFactoryBean;
  }

  @Override
  public Validator getValidator() {
    return validator();
  }
}
