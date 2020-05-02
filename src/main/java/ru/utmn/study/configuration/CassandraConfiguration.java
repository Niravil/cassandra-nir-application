package ru.utmn.study.configuration;

import com.datastax.oss.driver.api.core.CqlSession;
import java.nio.file.Paths;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CassandraConfiguration {

  @Bean
  public CqlSession cqlSession(
      @Value("${app.use.connection.archive}")
          String connectionBundle,
      @Value("${app.use.connection.username}")
          String username,
      @Value("${app.use.connection.password}")
          String password,
      @Value("${app.use.connection.keyspace}")
          String keyspace) {

    log.info("Initializing cql session for Cassandra");
    return CqlSession.builder()
        .withCloudSecureConnectBundle(Paths.get(connectionBundle))
        .withAuthCredentials(username, password)
        .withKeyspace(keyspace)
        .build();

  }
}
