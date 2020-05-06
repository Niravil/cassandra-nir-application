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
public class WordsDictionaryDto {

  @JsonProperty(value = "id")
  private UUID id;

  @JsonProperty(value = "word_maus", required = true)
  private String wordMaus;

  @JsonProperty(value = "word_russian", required = true)
  private String wordRussian;

}
