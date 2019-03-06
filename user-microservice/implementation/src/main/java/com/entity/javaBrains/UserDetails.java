package com.entity.javaBrains;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER_DETAILS")
@Getter
@Setter
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "USERNAME")
    private String username;

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
            @AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")),
            @AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE")),
            @AttributeOverride(name = "codePostal", column = @Column(name = "OFFICE_CODEPOSTAL"))

    })
    private Address officeAddress;
    //JoinTable pour definir le nom de la table qui va etre creer pour la collection sachant qu'il ya un FK vers UserDetails
    // JoinColumns // pour donner le nom du foreing key
    @ElementCollection
    @JoinTable(name = "USER_ARTICLE"
            , joinColumns = @JoinColumn(name = "USER_ID")
    )
    private Set<Article> articles = new HashSet<>();

    /*JoinTable pour definir le nom de la table qui va etre creer pour la collection sachant qu'il ya un FK vers UserDetails
     JoinColumns // pour donner le nom du foreing key
     Pour utiliser les index il faut utiliser les ArrayList car SET ne peut pas faire l'index
     hilo n'est prise en charge utilise sequence , @GenericGenerator(name = "hilo-generator", strategy = "hilo")
     https://stackoverflow.com/questions/33103355/hilo-generator-strategy-not-working
     @CollectionId Attention c'est une annotation Hibernate et non JPA Pour configurer la clé primaire de la table collection
     @CollectionId va avec @GenericGenerator pour configurer le generateur d'id
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ARTICLE_ARRAY",
            joinColumns = @JoinColumn(name = "USER_ID"))
    @GenericGenerator(name = "increment-gen", strategy = "increment")
    @CollectionId(columns = {@Column(name = "ARTICLE_ID")}, generator = "increment-gen", type = @Type(type = "long"))
    private Collection<Article> articlesArrays = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VEHICLE_ID_FOR_USER")
    private Vehicle vehicle;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<Vehicle> vehiclesCollection = new ArrayList<>();



}
