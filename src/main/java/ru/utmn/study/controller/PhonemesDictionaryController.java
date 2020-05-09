package ru.utmn.study.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
import ru.utmn.study.dto.PhonemesDictionaryDto;
import ru.utmn.study.service.PhonemesDictionaryService;

/**
 * Rest-контроллер для CRUD операций над элементами словаря фонем
 *
 * @author vasilev
 */
@RestController
@RequestMapping("/api")
@Api(description = "Rest-контроллер для CRUD операций над элементами словаря фонем")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class PhonemesDictionaryController {

  private final PhonemesDictionaryService phonemesDictionaryService;

  @ApiOperation(value = "Получить данные об элементе словаря по идентификатору ", response = PhonemesDictionaryDto.class)
  @GetMapping(value = "/phonemes/{identifier}")
  public ResponseEntity<PhonemesDictionaryDto> getWordDictionary(
      @ApiParam(value = "Идентификатор элемента словаря")
      @PathVariable Integer identifier) {
    return phonemesDictionaryService.getById(identifier).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @ApiOperation(value = "Добавить или изменить данные об элементе словаря", response = Integer.class, produces = "Идентификатор элемента словаря")
  @RequestMapping(value = "/phonemes", method = {
      RequestMethod.POST, RequestMethod.PUT})
  public ResponseEntity<Integer> addOrUpdateWordDictionary(
      @ApiParam(value = "Тело запроса с необходимыми при публикации полями")
      @RequestBody PhonemesDictionaryDto body) {
    final Integer result = phonemesDictionaryService.save(body);
    return ResponseEntity.ok(result);
  }

  @ApiOperation(value = "Удалить данные об элементе словаря")
  @DeleteMapping(value = "/phonemes/{identifier}")
  public ResponseEntity deleteWordDictionary(
      @ApiParam(value = "Идентификатор элемента словаря")
      @PathVariable Integer identifier) {
    phonemesDictionaryService.delete(identifier);
    return ResponseEntity.ok().build();
  }
}
