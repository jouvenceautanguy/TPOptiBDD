package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
