package com.kuama.kinitializer.modules.greeting.services;

import com.kuama.kinitializer.common.exceptions.RecordNotFoundException;
import com.kuama.kinitializer.modules.greeting.dtos.GreetingCreateDto;
import com.kuama.kinitializer.modules.greeting.dtos.GreetingReadDto;
import com.kuama.kinitializer.modules.greeting.dtos.GreetingUpdateDto;
import com.kuama.kinitializer.modules.greeting.mappings.GreetingMappings;
import com.kuama.kinitializer.modules.greeting.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record GreetingService(
        GreetingRepository _greetingRepository) {

    public GreetingReadDto findById(Long id) throws RecordNotFoundException {
        var optionalEntity = _greetingRepository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new RecordNotFoundException("GreetingService.findById didn't find record with id" + id);
        }

        return GreetingMappings.Map(optionalEntity.get());
    }

    public List<GreetingReadDto> findAll() {
        var entities = _greetingRepository.findAll();

        return GreetingMappings.Map(entities);
    }

    public GreetingReadDto crate(GreetingCreateDto createDto) {
        var entity = GreetingMappings.Map(createDto);

        _greetingRepository.save(entity);

        return GreetingMappings.Map(entity);
    }

    public GreetingReadDto update(Long id, GreetingUpdateDto updateDto) throws RecordNotFoundException {
        var optionalEntity = _greetingRepository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new RecordNotFoundException("GreetingService.update didn't find record with id" + id);
        }

        GreetingMappings.Map(updateDto, optionalEntity.get());
        _greetingRepository.save(optionalEntity.get());

        return GreetingMappings.Map(optionalEntity.get());
    }

    public void delete(Long id) throws RecordNotFoundException {
        var optionalEntity = _greetingRepository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new RecordNotFoundException("GreetingService.update didn't find record with id" + id);
        }

        _greetingRepository.delete(optionalEntity.get());
    }
}
