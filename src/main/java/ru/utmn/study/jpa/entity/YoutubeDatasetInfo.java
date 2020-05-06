package ru.utmn.study.jpa.entity;

import com.datastax.driver.mapping.annotations.Table;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Youtube_Dataset_Info")
public class YoutubeDatasetInfo {

  @PartitionKey
  private UUID id;

  private String url;

  private Integer startSecond;

  private Integer endSecond;
}
