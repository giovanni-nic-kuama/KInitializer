package com.kuama.kinitializer.modules.users.services;

import com.kuama.kinitializer.common.exceptions.RecordNotFoundException;
import com.kuama.kinitializer.modules.users.dtos.UserCreateDto;
import com.kuama.kinitializer.modules.users.dtos.UserReadDto;
import com.kuama.kinitializer.modules.users.dtos.UserUpdateDto;
import com.kuama.kinitializer.modules.users.entities.User;
import com.kuama.kinitializer.modules.users.mappings.UserMappings;
import com.kuama.kinitializer.modules.users.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record UserService(UserRepository _userRepository) {

    public List<UserReadDto> findAll() {
        var entities = _userRepository.findAll();

        return UserMappings.Map(entities);
    }

    public UserReadDto findByEmail(String email) throws RecordNotFoundException {
        Optional<User> optionalEntity = _userRepository.findByEmail(email);

        if (optionalEntity.isEmpty()) {
            throw new RecordNotFoundException("UserService.findByEmail didn't find record with email" + email);
        }

        return UserMappings.Map(optionalEntity.get());
    }

    public UserReadDto findById(Long id) throws RecordNotFoundException {
        var optionalEntity = _userRepository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new RecordNotFoundException("UserService.findById didn't find record with id" + id);
        }

        return UserMappings.Map(optionalEntity.get());
    }

    public UserReadDto create(UserCreateDto userCreateDto) {
        var entity = UserMappings.Map(userCreateDto);

        _userRepository.save(entity);

        return UserMappings.Map(entity);
    }

    public UserReadDto update(Long id, UserUpdateDto userUpdateDto) throws RecordNotFoundException {
        Optional<User> entity = _userRepository.findById(id);

        if(entity.isEmpty()) {
            throw new RecordNotFoundException("UserService.update didn't find record with id" + id);
        }

        UserMappings.Map(userUpdateDto, entity.get());

        return UserMappings.Map(entity.get());
    }

    public void delete(Long id) throws RecordNotFoundException {
        Optional<User> entity = _userRepository.findById(id);

        if(entity.isEmpty()) {
            throw new RecordNotFoundException("UserService.delete didn't find record with id" + id);
        }

        _userRepository.delete(entity.get());
    }
}
