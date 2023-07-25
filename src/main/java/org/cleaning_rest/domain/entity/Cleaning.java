package org.cleaning_rest.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cleaning extends BaseEntity {

    @Column(name = "room_number")
    Integer roomNumber;
    @Column(name = "cleaning_time")
    LocalDateTime cleaningTime;
}
