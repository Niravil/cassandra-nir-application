package ru.utmn.study.configuration;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.InvalidKeyspaceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.utmn.study.jpa.dao.YoutubeDataSetInfoDao;
import ru.utmn.study.jpa.dao.YoutubeDataSetInfoEntityMapper;
import ru.utmn.study.jpa.dao.YoutubeDataSetInfoEntityMapperBuilder;

@Slf4j
@Configuration
public class MapperConfiguration {

  @Bean
  public YoutubeDataSetInfoEntityMapper youtubeDataSetInfoMapper(@Autowired CqlSession cqlSession) {
    log.trace("create YoutubeDataSetInfoEntityMapper");
    return new YoutubeDataSetInfoEntityMapperBuilder(cqlSession).build();
  }

  @Bean
  public YoutubeDataSetInfoDao youtubeDatasetInfoDao(
      @Autowired CqlSession cqlSession,
      @Autowired YoutubeDataSetInfoEntityMapper youtubeDataSetInfoEntityMapper) {
    log.trace("create YoutubeDataSetInfoDao");
    CqlIdentifier keyspace = cqlSession.getKeyspace()
        .orElseThrow(() -> new InvalidKeyspaceException(
            "Invalid keyspace given via application properties"));
    return youtubeDataSetInfoEntityMapper.youtubeDataSetInfoDao(keyspace);
  }
}
