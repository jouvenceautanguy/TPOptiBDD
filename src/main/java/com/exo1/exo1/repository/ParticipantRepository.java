package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Modifying
    @Transactional
    @Query("SELECT p FROM Participant p JOIN FETCH p.user WHERE p.event.id = :eventId")
    List<Participant> findParticipantsByEventId(@Param("eventId") Long eventId);
}
