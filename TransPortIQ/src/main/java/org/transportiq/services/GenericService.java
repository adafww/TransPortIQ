package org.transportiq.services;

import org.transportiq.models.BaseModel;
import org.transportiq.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GenericService {

    private final BaseRepository baseRepository;

    @Autowired
    public GenericService(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public BaseModel getById(String modelName, Integer id) {
        // Вызываем метод getById из BaseRepository
        BaseModel baseModel = baseRepository.getById(modelName, id);

        // Проверяем, что baseModel не равен null
        if (baseModel != null) {
            // Получаем Map полей и их значений из baseModel
            Map<String, Object> fields = baseModel.getFields();

            fields.entrySet().stream()
                    .forEach(entry -> {
                        String fieldName = entry.getKey();
                        Object fieldValue = entry.getValue();
                        System.out.println(fieldName + ": " + fieldValue);
                    });

            return baseModel;
        } else {
            // Обработка случая, когда запись не найдена
            return null;
        }
    }

    public void deleteById(String modelName, Long id) {
        // Удаление сущности из репозитория по id
//        repository.deleteById(id);
    }

    public void update(String modelName, Long id, Map<String, Object> updates) {
        // Найдем сущность в репозитории по id
//        Optional<BaseEntity> optionalEntity = repository.findById(id);
//        if (optionalEntity.isPresent()) {
//            BaseEntity entity = optionalEntity.get();
//            // Примените обновления к сущности на основе данных из Map<String, Object>
//            updateEntityFromMap(entity, updates);
//            // Сохраните обновленную сущность
//            repository.save(entity);
//        } else {
//            throw new EntityNotFoundException("Entity with id " + id + " not found.");
//        }
    }

    // Дополнительные методы для преобразования сущности в Map и обновления сущности из Map
    // Реализация этих методов зависит от структуры ваших сущностей
//    private Map<String, Object> convertEntityToMap(BaseEntity entity) {
//        // Реализуйте преобразование сущности в Map здесь
//    }

//    private void updateEntityFromMap(BaseEntity entity, Map<String, Object> updates) {
//        // Реализуйте обновление сущности на основе данных из Map здесь
//    }
}
