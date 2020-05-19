package com.example.recipeapp.repositories;

import com.example.recipeapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CategoryRepositoryTestIT {

    @Autowired
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() throws Exception{
    }

    @Test
    void findByDescription() throws Exception{
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");

        assertEquals("American",categoryOptional.get().getDescription());
    }
}