package ru.utmn.study.service;

import java.util.Optional;
import java.util.UUID;

/**
 * Обобщённый интерфейс службы для обработки запросов
 *
 * @param <T> Тип DTO объекта
 * @author vasilev
 */
public interface NirEntityService<T> {

  Optional<T> getById(String uuid);

  UUID save(T body);

  Boolean delete(String uuid);
}
