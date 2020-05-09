package ru.utmn.study.service;

import java.util.Optional;

/**
 * Обобщённый интерфейс службы для обработки запросов
 *
 * @param <T> Тип DTO объекта
 * @param <K> Тип Partition Key сущности
 * @author vasilev
 */
public interface NirEntityService<T, K> {

  Optional<T> getById(K identifier);

  K save(T body);

  Boolean delete(K identifier);
}
