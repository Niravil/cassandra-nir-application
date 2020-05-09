package ru.utmn.study.jpa.mapper;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import ru.utmn.study.jpa.dao.WordsDictionaryDao;

/**
 * Маппер результата обращения к БД в сущность таблицы
 *
 * @author vasilev
 * @see WordsDictionaryEntityMapperImpl__MapperGenerated , сгенерированный при сборке
 * плагином для Maven
 */
@Mapper
public interface WordsDictionaryEntityMapper {

  @DaoFactory
  WordsDictionaryDao wordsDictionaryDao(@DaoKeyspace CqlIdentifier keyspace);
}
