package ru.utmn.study.service;

import java.text.MessageFormat;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.utmn.study.dto.YoutubeDatasetInfoDto;
import ru.utmn.study.exception.ResourceNotFoundException;
import ru.utmn.study.jpa.dao.YoutubeDataSetInfoDao;
import ru.utmn.study.jpa.entity.YoutubeDatasetInfo;
import ru.utmn.study.mapper.YoutubeDatasetInfoMapper;

/**
 * Служба для взаимодействия DAO и контроллера
 *
 * @author vasilev
 */
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class YoutubeDatasetInforService implements
    NirEntityService<YoutubeDatasetInfoDto, UUID> {

  private final YoutubeDataSetInfoDao dao;

  public Optional<YoutubeDatasetInfoDto> getById(UUID uuid) {
    return this.getEntityById(uuid).map(YoutubeDatasetInfoMapper::mapToDto);
  }

  private Optional<YoutubeDatasetInfo> getEntityById(UUID uuid) {
    return dao.findByID(uuid);
  }

  public UUID save(YoutubeDatasetInfoDto body) {
    YoutubeDatasetInfo entity = YoutubeDatasetInfoMapper.mapToEntity(body);
    dao.save(entity);
    return entity.getId();
  }

  public Boolean delete(UUID uuid) {
    return dao.delete(this.getEntityById(uuid)
        .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format(
            "Dataset info with id {0} not found", uuid))));
  }
}
