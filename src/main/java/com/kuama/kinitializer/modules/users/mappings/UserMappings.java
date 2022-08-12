package com.kuama.kinitializer.modules.users.mappings;

import com.kuama.kinitializer.modules.users.dtos.UserCreateDto;
import com.kuama.kinitializer.modules.users.dtos.UserReadDto;
import com.kuama.kinitializer.modules.users.dtos.UserUpdateDto;
import com.kuama.kinitializer.modules.users.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMappings {

    public static List<UserReadDto> Map(List<User> users) {
        return users.stream().map(UserMappings::Map).collect(Collectors.toList());
    }

    public static UserReadDto Map(User user) {
        UserReadDto userReadDto = new UserReadDto();

        userReadDto.setId(user.getId());
        userReadDto.setUserName(user.getUserName());
        userReadDto.setEmail(user.getEmail());

        return userReadDto;
    }

    public static User Map(UserCreateDto createDto) {
        User user = new User();

        user.setUserName(createDto.getUserName());
        user.setEmail(createDto.getEmail());

        return user;
    }

    public static void Map(UserUpdateDto updateDto, User user) {
        user.setEmail(updateDto.getEmail());
        user.setEmail(updateDto.getEmail());
    }

}
