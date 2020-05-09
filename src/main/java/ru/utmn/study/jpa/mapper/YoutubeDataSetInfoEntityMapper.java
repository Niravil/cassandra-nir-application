package ru.utmn.study.jpa.mapper;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import ru.utmn.study.jpa.dao.YoutubeDataSetInfoDao;

/**
 * Маппер результата обращения к БД в сущность таблицы
 *
 * @author vasilev
 * @see YoutubeDataSetInfoEntityMapperImpl__MapperGenerated , сгенерированный при сборке
 * плагином для Maven
 */
@Mapper
public interface YoutubeDataSetInfoEntityMapper {

  @DaoFactory
  YoutubeDataSetInfoDao youtubeDataSetInfoDao(@DaoKeyspace CqlIdentifier keyspace);
}
