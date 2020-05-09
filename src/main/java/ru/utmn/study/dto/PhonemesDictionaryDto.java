package ru.utmn.study.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhonemesDictionaryDto {

  @JsonProperty(value = "phoneme_key", required = true)
  private Integer phonemeKey;

  @JsonProperty(value = "phoneme_maus", required = true)
  private String phonemeMaus;

  @JsonProperty(value = "phoneme_russian", required = true)
  private String phonemeRussian;
}
