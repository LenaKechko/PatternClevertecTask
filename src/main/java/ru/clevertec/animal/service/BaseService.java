package ru.clevertec.animal.service;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {

    T get(UUID uuid);
    List<T> getAll();
    void create(T animalDto);
    void update(UUID uuid, T animalDto);
    void delete(UUID uuid);

}
