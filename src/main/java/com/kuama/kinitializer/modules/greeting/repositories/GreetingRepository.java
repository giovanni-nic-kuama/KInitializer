package com.kuama.kinitializer.modules.greeting.repositories;

import com.kuama.kinitializer.modules.greeting.entities.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
