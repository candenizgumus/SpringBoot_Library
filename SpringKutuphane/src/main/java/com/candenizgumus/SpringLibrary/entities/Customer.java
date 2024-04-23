package com.candenizgumus.SpringLibrary.entities;

import com.candenizgumus.SpringLibrary.entities.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblcustomer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String username;
    String password;
    String name;
    @Column(unique = true)
    String identityno;
    Double balance;
    @Enumerated(EnumType.STRING)
    UserType userType;
}
