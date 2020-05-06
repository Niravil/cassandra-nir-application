package ru.utmn.study.mapper;

import com.datastax.driver.core.utils.UUIDs;
import ru.utmn.study.dto.YoutubeDatasetInfoDto;
import ru.utmn.study.jpa.entity.YoutubeDatasetInfo;

public class YoutubeDatasetInfoMapper {

  public static YoutubeDatasetInfoDto mapToDto(YoutubeDatasetInfo entity) {
    return YoutubeDatasetInfoDto.builder().id(entity.getId()).url(entity.getUrl())
        .startSecond(entity.getStartSecond()).endSecond(entity.getEndSecond()).build();
  }

  public static YoutubeDatasetInfo mapToEntity(YoutubeDatasetInfoDto dto) {
    return YoutubeDatasetInfo.builder().id(dto.getId() != null ? dto.getId() : UUIDs.timeBased())
        .url(dto.getUrl())
        .startSecond(dto.getStartSecond()).endSecond(dto.getEndSecond()).build();
  }
}
