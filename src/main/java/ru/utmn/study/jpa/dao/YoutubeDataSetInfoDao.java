package ru.utmn.study.jpa.dao;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import java.util.Optional;
import java.util.UUID;
import ru.utmn.study.jpa.entity.YoutubeDatasetInfo;

@Dao
public interface YoutubeDataSetInfoDao {

  @Select
  Optional<YoutubeDatasetInfo> findByID(UUID id);

  @Insert
  YoutubeDatasetInfo save(YoutubeDatasetInfo youtubeDataSetInfo);

  @Delete
  boolean deleteById(YoutubeDatasetInfo youtubeDataSetInfo);
}
