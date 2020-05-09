package ru.utmn.study.jpa.dao;
import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import java.util.Optional;
import ru.utmn.study.jpa.entity.PhonemesDictionary;

@Dao
public interface PhonemesDictionaryDao {

  @Select
  Optional<PhonemesDictionary> findByID(Integer id);

  @Insert
  PhonemesDictionary save(PhonemesDictionary youtubeDataSetInfo);

  @Delete
  boolean delete(PhonemesDictionary youtubeDataSetInfo);
}
