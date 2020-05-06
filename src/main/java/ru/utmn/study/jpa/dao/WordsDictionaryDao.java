package ru.utmn.study.jpa.dao;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import java.util.Optional;
import java.util.UUID;
import ru.utmn.study.jpa.entity.WordsDictionary;

@Dao
public interface WordsDictionaryDao {

  @Select
  Optional<WordsDictionary> findByID(UUID id);

  @Insert
  WordsDictionary save(WordsDictionary youtubeDataSetInfo);

  @Delete
  boolean delete(WordsDictionary youtubeDataSetInfo);
}
