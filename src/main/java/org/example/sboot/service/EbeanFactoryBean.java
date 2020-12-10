package org.example.sboot.service;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

  @Autowired
  CurrentUser currentUser;

  @Autowired
  DataSource dataSource;

  @Override
  public EbeanServer getObject() throws Exception {

    ServerConfig config = new ServerConfig();
    config.setName("db");
    config.setCurrentUserProvider(currentUser);

    config.setDataSource(dataSource);
    config.setDdlGenerate(true);
    config.setDdlRun(true);

    // TODO MCVE uncomment this line to use Ebean's Transaction Manager
    config.setExternalTransactionManager(new SpringJdbcTransactionManager());

    return EbeanServerFactory.create(config);
  }

  @Override
  public Class<?> getObjectType() {
    return EbeanServer.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
