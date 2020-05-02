package ru.utmn.study.jpa.dao;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface YoutubeDataSetInfoEntityMapper {

  @DaoFactory
  YoutubeDataSetInfoDao youtubeDataSetInfoDao(@DaoKeyspace CqlIdentifier keyspace);
}
