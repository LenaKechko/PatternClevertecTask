package ru.clevertec.animal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.clevertec.animal.data.AnimalDto;
import ru.clevertec.animal.entity.Animal;

/**
 * Класс реализующий сущность Animal, соответствует таблице БД animals
 * С помощью аннотация Lombok были созданы getter's и setter's для полей класса, toString
 * и возможность созадния объекта с помощью Builder
 * а также конструктор по умолчанию и конструктор со всеми полями
 *
 * @author Кечко Елена
 */
@Mapper
public interface AnimalMapper {

    /**
     * Маппит DTO в животное без UUID
     *
     * @param animalDTO - DTO для маппинга
     * @return новое животное
     */
    @Mapping(target = "id", ignore = true)
    Animal toAnimal(AnimalDto animalDTO);

    /**
     * Маппит животное в DTO без UUID
     *
     * @param animal существующее животное
     * @return обновлённый продукт
     */
    AnimalDto toAnimalDTO(Animal animal);

    /**
     * Сливает существующее животное с информацией из DTO
     * не меняет идентификатор
     *
     * @param animal    существующее животное
     * @param animalDto информация для обновления
     * @return обновлённое животное
     */
    @Mapping(target = "id", source = "animal.id")
    @Mapping(target = "name", source = "animalDto.name")
    @Mapping(target = "typeOfAnimal", source = "animalDto.typeOfAnimal")
    @Mapping(target = "classOfAnimal", source = "animalDto.classOfAnimal")
    @Mapping(target = "weight", source = "animalDto.weight")
    @Mapping(target = "height", source = "animalDto.height")
    @Mapping(target = "speed", source = "animalDto.speed")
    Animal merge(Animal animal, AnimalDto animalDto);
}