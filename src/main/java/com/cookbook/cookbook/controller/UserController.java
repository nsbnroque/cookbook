package com.cookbook.cookbook.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cookbook.cookbook.domain.recipe.Recipe;
import com.cookbook.cookbook.domain.user.User;
import com.cookbook.cookbook.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        User saved = userService.save(user);
        URI uri = uriComponentsBuilder.path("/v1/users/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id) {
        User user = userService.find(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/recipes")
    public ResponseEntity<List<Recipe>> getCookbook(@PathVariable Long id){
        List<Recipe> cookbook = userService.getCookbook(id);
        return ResponseEntity.ok(cookbook);
    }

}
