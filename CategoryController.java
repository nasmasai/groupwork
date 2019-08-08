package com.groupwork.demo.Controller;

import com.groupwork.demo.Models.Category;
import com.groupwork.demo.Repositories.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "categories")
public class CategoryController {

   private final CategoryRepository categoryRepository;

    public CategoryController (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping
    public List<Category>getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Category findOneById(@PathVariable Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();

    }
}
