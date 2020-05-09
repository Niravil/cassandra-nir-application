package ru.utmn.study.configuration;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.InvalidKeyspaceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.utmn.study.jpa.dao.PhonemesDictionaryDao;
import ru.utmn.study.jpa.dao.WordsDictionaryDao;
import ru.utmn.study.jpa.mapper.PhonemesDictionaryMapper;
import ru.utmn.study.jpa.mapper.PhonemesDictionaryMapperBuilder;
import ru.utmn.study.jpa.mapper.WordsDictionaryEntityMapper;
import ru.utmn.study.jpa.dao.YoutubeDataSetInfoDao;
import ru.utmn.study.jpa.mapper.WordsDictionaryEntityMapperBuilder;
import ru.utmn.study.jpa.mapper.YoutubeDataSetInfoEntityMapper;
import ru.utmn.study.jpa.mapper.YoutubeDataSetInfoEntityMapperBuilder;

/**
 * Конфигурация мапперов из результата обращения к БД в сущность таблицы
 *
 * @author vasilev
 */
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

  @Bean
  public WordsDictionaryEntityMapper wordsDictionaryEntityMapper(@Autowired CqlSession cqlSession) {
    log.trace("create YoutubeDataSetInfoEntityMapper");
    return new WordsDictionaryEntityMapperBuilder(cqlSession).build();
  }

  @Bean
  public WordsDictionaryDao wordsDictionaryDao(
      @Autowired CqlSession cqlSession,
      @Autowired WordsDictionaryEntityMapper wordsDictionaryEntityMapper) {
    log.trace("create YoutubeDataSetInfoDao");
    CqlIdentifier keyspace = cqlSession.getKeyspace()
        .orElseThrow(() -> new InvalidKeyspaceException(
            "Invalid keyspace given via application properties"));
    return wordsDictionaryEntityMapper.wordsDictionaryDao(keyspace);
  }

  @Bean
  public PhonemesDictionaryMapper phonemesDictionaryMapper(@Autowired CqlSession cqlSession) {
    log.trace("create PhonemesDictionaryEntityMapper");
    return new PhonemesDictionaryMapperBuilder(cqlSession).build();
  }

  @Bean
  public PhonemesDictionaryDao phonemesDictionaryDao(
      @Autowired CqlSession cqlSession,
      @Autowired PhonemesDictionaryMapper phonemesDictionaryMapper) {
    log.trace("create YoutubeDataSetInfoDao");
    CqlIdentifier keyspace = cqlSession.getKeyspace()
        .orElseThrow(() -> new InvalidKeyspaceException(
            "Invalid keyspace given via application properties"));
    return phonemesDictionaryMapper.phonemesDictionaryDao(keyspace);
  }
}
