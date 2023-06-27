package com.example.hiberv2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Setter
@Getter
@NoArgsConstructor
@Table(name = "details")
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city")
    private String city;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "details_id")
    private Employee employee;

    public Details(String city, String phoneNumber) {
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

}
