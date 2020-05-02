package ru.utmn.study.controller;

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
import ru.utmn.study.service.NirService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class NirController {

  private final NirService nirService;

  @GetMapping(value = "/videos/{videoTimestamp}")
  public ResponseEntity<YoutubeDatasetInfoDto> getYoutubeDatasetInfo(
      @PathVariable String videoTimestamp) {
    return nirService.getById(videoTimestamp).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @RequestMapping(value = "/videos", method = {
      RequestMethod.POST, RequestMethod.PUT})
  public ResponseEntity<UUID> addOrUpdateYoutubeDatasetInfo(
      @RequestBody YoutubeDatasetInfoDto body) {
    final UUID result = nirService.saveVideo(body);
    return ResponseEntity.ok(result);
  }

  @DeleteMapping(value = "/videos/{videoTimestamp}")
  public ResponseEntity YoutubeDatasetInfo(@PathVariable String videoTimestamp) {
    nirService.deleteVideo(videoTimestamp);
    return ResponseEntity.ok().build();
  }
}
