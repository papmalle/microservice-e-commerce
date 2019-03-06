package com.entity.javaBrains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Setter
@Getter
@Embeddable  // même pour utiliser des collections (@ElementCollection) ou (@Embeded) il faut  definir  @Embeddable
public class Article {
    private String name;
    private int price;
}
