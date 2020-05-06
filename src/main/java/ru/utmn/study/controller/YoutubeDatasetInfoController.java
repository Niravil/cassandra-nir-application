package ru.utmn.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.utmn.study.dto.YoutubeDatasetInfoDto;
import ru.utmn.study.service.YoutubeDatasetInforService;

/**
 * Rest-контроллер для CRUD операций над элементами датасета из виедороликов
 *
 * @author vasilev
 */
@RestController
@RequestMapping("/api")
@Api(description = "Rest-контроллер для CRUD операций над элементами датасета из виедороликов")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class YoutubeDatasetInfoController {

  private final YoutubeDatasetInforService youtubeDatasetInforService;

  @ApiOperation(value = "Получить данные о видеоролике по идентификатору ", response = YoutubeDatasetInfoDto.class)
  @GetMapping(value = "/videos/{videoTimestamp}")
  public ResponseEntity<YoutubeDatasetInfoDto> getYoutubeDatasetInfo(
      @ApiParam(value = "Уникальный идентификатор (таймстамп) видеоролика")
      @PathVariable String videoTimestamp) {
    return youtubeDatasetInforService.getById(videoTimestamp).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @ApiOperation(value = "Добавить или изменить данные о видеоролике", response = UUID.class, produces = "Уникальный идентификатор (таймстамп) видеоролика")
  @RequestMapping(value = "/videos", method = {
      RequestMethod.POST, RequestMethod.PUT})
  public ResponseEntity<UUID> addOrUpdateYoutubeDatasetInfo(
      @ApiParam(value = "Тело запроса с необходимыми при публикации полями")
      @RequestBody YoutubeDatasetInfoDto body) {
    final UUID result = youtubeDatasetInforService.save(body);
    return ResponseEntity.ok(result);
  }

  @ApiOperation(value = "Удалить данные о видеоролике")
  @DeleteMapping(value = "/videos/{videoTimestamp}")
  public ResponseEntity deleteYoutubeDatasetInfo(
      @ApiParam(value = "Уникальный идентификатор (таймстамп) видеоролика")
      @PathVariable String videoTimestamp) {
    youtubeDatasetInforService.delete(videoTimestamp);
    return ResponseEntity.ok().build();
  }
}
