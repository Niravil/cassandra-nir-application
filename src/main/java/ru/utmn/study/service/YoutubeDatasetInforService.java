package ru.utmn.study.service;

import com.datastax.oss.driver.api.core.PagingIterable;
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
public class YoutubeDatasetInforService {

  private final YoutubeDataSetInfoDao dao;

  public Optional<YoutubeDatasetInfoDto> getById(String uuid) {
    return this.getEntityById(uuid).map(YoutubeDatasetInfoMapper::mapToDto);
  }

  private Optional<YoutubeDatasetInfo> getEntityById(String uuid) {
    return dao.findByID(UUID.fromString(uuid));
  }

  public UUID saveVideo(YoutubeDatasetInfoDto body) {
    YoutubeDatasetInfo entity = YoutubeDatasetInfoMapper.mapToEntity(body);
    dao.save(entity);
    return entity.getId();
  }

  public Boolean deleteVideo(String uuid) {
    return dao.deleteById(this.getEntityById(uuid)
        .orElseThrow(() -> new ResourceNotFoundException(MessageFormat.format(
            "Dataset info with id {0} not found", uuid))));
  }
}
