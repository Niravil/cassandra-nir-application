package ru.utmn.study.service;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.utmn.study.dto.WordsDictionaryDto;
import ru.utmn.study.exception.ResourceNotFoundException;
import ru.utmn.study.jpa.dao.WordsDictionaryDao;
import ru.utmn.study.jpa.entity.WordsDictionary;
import ru.utmn.study.mapper.WordsDictionaryMapper;

/**
 * Служба для взаимодействия DAO и контроллера
 *
 * @author vasilev
 */
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class WordsDictionaryService implements NirEntityService<WordsDictionaryDto> {

  private final WordsDictionaryDao dao;

  @Override
  public Optional<WordsDictionaryDto> getById(String uuid) {
    return this.getEntityById(uuid).map(WordsDictionaryMapper::mapToDto);
  }

  private Optional<WordsDictionary> getEntityById(String uuid) {
    return dao.findByID(UUID.fromString(uuid));
  }
  @Override
  public UUID save(WordsDictionaryDto body) {
    WordsDictionary entity = WordsDictionaryMapper.mapToEntity(body);
    dao.save(entity);
    return entity.getId();
  }

  @Override
  public Boolean delete(String uuid) {
    return dao.delete(this.getEntityById(uuid)
        .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format(
            "Dataset info with id {0} not found", uuid))));
  }
}
