package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "ForeignKeyAssoAccountEntity")
@Table(name = "ACCOUNT", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer accounId;

    @Column(name = "ACC_NUMBER", unique = true, nullable = false, length = 100)
    private String accountNumber;

    @ManyToOne
    private User user;
}
