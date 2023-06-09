package com.cookbook.cookbook.domain.user;

import java.util.List;

import com.cookbook.cookbook.domain.recipe.Recipe;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;

    @OneToMany
    private List<Recipe> cookBook; 
}
