package ru.utmn.study.mapper;

import ru.utmn.study.dto.PhonemesDictionaryDto;
import ru.utmn.study.jpa.entity.PhonemesDictionary;

public class PhonemesDoctionaryMapper  {
  public static PhonemesDictionaryDto mapToDto(PhonemesDictionary entity) {
    return PhonemesDictionaryDto
        .builder()
        .phonemeKey(entity.getPhonemeKey())
        .phonemeMaus(entity.getPhonemeMaus())
        .phonemeRussian(entity.getPhonemeRussian())
        .build();
  }

  public static PhonemesDictionary mapToEntity(PhonemesDictionaryDto dto) {
    return PhonemesDictionary
        .builder()
        .phonemeKey(dto.getPhonemeKey())
        .phonemeMaus(dto.getPhonemeMaus())
        .phonemeRussian(dto.getPhonemeRussian())
        .build();
  }
}
