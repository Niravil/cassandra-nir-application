package ru.utmn.study.jpa.entity;

import com.datastax.driver.mapping.annotations.Table;
import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
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
@Table(name = "Phonemes_Dictionary")
public class PhonemesDictionary {

  @PartitionKey
  private Integer phonemeKey;
  private String phonemeMaus;
  private String phonemeRussian;
}
