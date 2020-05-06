package ru.utmn.study.mapper;

import com.datastax.driver.core.utils.UUIDs;
import ru.utmn.study.dto.WordsDictionaryDto;
import ru.utmn.study.jpa.entity.WordsDictionary;

public class WordsDictionaryMapper {

  public static WordsDictionaryDto mapToDto(WordsDictionary entity) {
    return WordsDictionaryDto.builder().id(entity.getId()).wordMaus(entity.getWordMaus())
        .wordRussian(entity.getWordRussian()).build();
  }

  public static WordsDictionary mapToEntity(WordsDictionaryDto dto) {
    return WordsDictionary.builder().id(dto.getId() != null ? dto.getId() : UUIDs.timeBased())
        .wordMaus(dto.getWordMaus())
        .wordRussian(dto.getWordRussian()).build();
  }
}
