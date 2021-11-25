package com.demo.library.app.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class Reservation extends BaseEntity{

    @OneToMany(mappedBy = "reservation", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<BookReservation> bookReservation;

    @OneToMany(mappedBy = "reservation", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<UserReservation> userReservation;

    private String stat;
}
