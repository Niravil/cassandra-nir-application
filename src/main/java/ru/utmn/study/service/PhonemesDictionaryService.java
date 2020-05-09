package ru.utmn.study.service;

import java.text.MessageFormat;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.utmn.study.dto.PhonemesDictionaryDto;
import ru.utmn.study.exception.ResourceNotFoundException;
import ru.utmn.study.jpa.dao.PhonemesDictionaryDao;
import ru.utmn.study.jpa.entity.PhonemesDictionary;
import ru.utmn.study.mapper.PhonemesDoctionaryMapper;

/**
 * Служба для взаимодействия DAO и контроллера
 *
 * @author vasilev
 */
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class PhonemesDictionaryService implements NirEntityService<PhonemesDictionaryDto, Integer> {

  private final PhonemesDictionaryDao dao;

  @Override
  public Optional<PhonemesDictionaryDto> getById(Integer identifier) {
    return this.getEntityById(identifier).map(PhonemesDoctionaryMapper::mapToDto);
  }

  private Optional<PhonemesDictionary> getEntityById(Integer identifier) {
    return dao.findByID(identifier);
  }

  @Override
  public Integer save(PhonemesDictionaryDto body) {
    PhonemesDictionary entity = PhonemesDoctionaryMapper.mapToEntity(body);
    dao.save(entity);
    return entity.getPhonemeKey();
  }

  @Override
  public Boolean delete(Integer identifier) {
    return dao.delete(this.getEntityById(identifier)
        .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format(
            "Phonemes Dictionary element with id {0} not found", identifier))));
  }
}
