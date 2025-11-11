package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passport")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person personId;
    @Column(name = "passport_no")
    private String passportNo;
    @Column(name = "expire_date")
    private LocalDate expireDate;
    public Passport(Person person , String passportNo , LocalDate expireDate)
    {
        this.personId = person;
        this.passportNo = passportNo;
        this.expireDate = expireDate;
    }
}
