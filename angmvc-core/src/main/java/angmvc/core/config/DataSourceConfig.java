package angmvc.core.config;

import org.hibernate.ejb.HibernatePersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
public class DataSourceConfig {
  private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

  @Bean
  public DataSource dataSource() throws ClassNotFoundException {
    log.info("Creating Datasource");
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.H2).addDefaultScripts().build();
  }

  @Bean
  public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) throws ClassNotFoundException {
    log.info("Creating Transaction Manager");
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
    return transactionManager;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) throws ClassNotFoundException {
    log.info("Creating EntityManagerFactoryBean");
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setPackagesToScan("angmvc.core.entities");
    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
    Properties jpaProterties = new Properties();
    jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    entityManagerFactoryBean.setJpaProperties(jpaProterties);
    return entityManagerFactoryBean;
  }
}
