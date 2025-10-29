package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="user")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public User(String userName , String password , LocalDate dateOfBirth)
    {
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }
}
