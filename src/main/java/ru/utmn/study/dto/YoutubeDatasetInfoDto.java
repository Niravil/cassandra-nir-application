package ru.utmn.study.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YoutubeDatasetInfoDto {

  @JsonProperty(value = "id")
  private UUID id;

  @JsonProperty(value = "url", required = true)
  private String url;

  @JsonProperty(value = "start_second")
  private Integer startSecond;

  @JsonProperty(value = "end_second")
  private Integer endSecond;
}
