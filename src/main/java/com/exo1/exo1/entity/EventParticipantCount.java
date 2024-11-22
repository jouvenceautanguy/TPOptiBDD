package com.exo1.exo1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "event_participant_count")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventParticipantCount {

    @Id
    private Long eventId;

    private String eventName;

    private Long participantCount;

}
