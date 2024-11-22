package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
