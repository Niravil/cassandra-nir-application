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
import ru.utmn.study.dto.WordsDictionaryDto;
import ru.utmn.study.dto.YoutubeDatasetInfoDto;
import ru.utmn.study.service.WordsDictionaryService;

/**
 * Rest-контроллер для CRUD операций над элементами словаря слов
 *
 * @author vasilev
 */
@RestController
@RequestMapping("/api")
@Api(description = "Rest-контроллер для CRUD операций над элементами словаря слов")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class WordsDictionaryController {

  private final WordsDictionaryService wordsDictionaryService;

  @ApiOperation(value = "Получить данные об элементе словаря по идентификатору ", response = WordsDictionaryDto.class)
  @GetMapping(value = "/words/{timestamp}")
  public ResponseEntity<WordsDictionaryDto> getWordDictionary(
      @ApiParam(value = "Уникальный идентификатор элемента словаря")
      @PathVariable String timestamp) {
    return wordsDictionaryService.getById(UUID.fromString(timestamp)).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @ApiOperation(value = "Добавить или изменить данные об элементе словаря", response = UUID.class, produces = "Уникальный таймстамп элемента словаря")
  @RequestMapping(value = "/words", method = {
      RequestMethod.POST, RequestMethod.PUT})
  public ResponseEntity<UUID> addOrUpdateWordDictionary(
      @ApiParam(value = "Тело запроса с необходимыми при публикации полями")
      @RequestBody WordsDictionaryDto body) {
    final UUID result = wordsDictionaryService.save(body);
    return ResponseEntity.ok(result);
  }

  @ApiOperation(value = "Удалить данные об элементе словаря")
  @DeleteMapping(value = "/words/{timestamp}")
  public ResponseEntity deleteWordDictionary(
      @ApiParam(value = "Уникальный идентификатор элемента словаря")
      @PathVariable String timestamp) {
    wordsDictionaryService.delete(UUID.fromString(timestamp));
    return ResponseEntity.ok().build();
  }
}
