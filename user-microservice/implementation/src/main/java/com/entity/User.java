package com.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "ForeignKeyAssoEntity")
@Table(name = "USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "EMAIL")
})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 30)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 8)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private Set<Account> accounts;

//    //we used cascade to tell Hibernate to persist the Country objects at the same time as the User objects
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Country> visitedCountries;

    @Embedded
    private Adresse adresse;

    @ElementCollection
//    @CollectionTable(name = "USER_BOOKS", joinColumns = @JoinColumn(name = "USER_ID"))
    @Column(name = "USER_BOOKS")
    private List<String> books;


}
