package com.demo.library.app.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity(name="user")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int lateFee;
    private String phone;
    private String adr;
    private String oauthId;


    @OneToMany(mappedBy = "loan", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Loan> loan;

    @OneToMany(mappedBy = "order", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Order> order;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<UserReservation> userReservation;

    public User update(int lateFee) {
        this.lateFee = lateFee;
        return this;
    }
}
