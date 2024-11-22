package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_detail_id")
    private EventDetail eventDetail;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Boolean isPaid;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "event")
    private List<Participant> participants;

}

