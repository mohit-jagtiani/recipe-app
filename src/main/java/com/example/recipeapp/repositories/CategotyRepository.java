package com.example.recipeapp.repositories;

import com.example.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategotyRepository extends CrudRepository<Category, Long> {
}
