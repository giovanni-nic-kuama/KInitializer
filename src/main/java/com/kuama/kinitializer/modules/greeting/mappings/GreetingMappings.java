package com.kuama.kinitializer.modules.greeting.mappings;

import com.kuama.kinitializer.modules.greeting.dtos.GreetingCreateDto;
import com.kuama.kinitializer.modules.greeting.dtos.GreetingReadDto;
import com.kuama.kinitializer.modules.greeting.dtos.GreetingUpdateDto;
import com.kuama.kinitializer.modules.greeting.entities.Greeting;

import java.util.List;
import java.util.stream.Collectors;

public class GreetingMappings {

    public static List<GreetingReadDto> Map(List<Greeting> entities) {
        return entities.stream().map(GreetingMappings::Map).collect(Collectors.toList());
    }

    public static GreetingReadDto Map(Greeting entity) {
        GreetingReadDto greetingReadDto = new GreetingReadDto();

        greetingReadDto.setId(entity.getId());
        greetingReadDto.setTitle(entity.getTitle());
        greetingReadDto.setMessage(entity.getMessage());

        return greetingReadDto;
    }

    public static void Map(GreetingUpdateDto greetingUpdateDto, Greeting entity) {
        entity.setMessage(greetingUpdateDto.getMessage());
        entity.setTitle(greetingUpdateDto.getTitle());
    }

    public static Greeting Map(GreetingCreateDto createDto) {
        Greeting greeting = new Greeting();

        greeting.setTitle(createDto.getTitle());
        greeting.setMessage(createDto.getMessage());

        return greeting;
    }

}
