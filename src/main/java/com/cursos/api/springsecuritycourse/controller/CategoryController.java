package com.cursos.api.springsecuritycourse.controller;

import com.cursos.api.springsecuritycourse.dto.SaveCategory;
import com.cursos.api.springsecuritycourse.dto.SaveProduct;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import com.cursos.api.springsecuritycourse.persistence.entity.Product;
import com.cursos.api.springsecuritycourse.service.CategoryService;
import com.cursos.api.springsecuritycourse.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    //Pageable contiene la información de la paginación pagina y tamaño
    public ResponseEntity<Page<Category>> findAll(Pageable pageable) {
        Page<Category> categoriesPage = categoryService.findAll(pageable);
        if (categoriesPage.hasNext()) {
            return ResponseEntity.ok(categoriesPage);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> findOneById(@PathVariable Long categoryId) {
        Optional<Category> category = categoryService.findOneById(categoryId);
        if (category.isPresent()) {
            return ResponseEntity.ok(category.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Category> createOne(@RequestBody @Valid SaveCategory saveCategory) {
        Category category = categoryService.createOne(saveCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateOneById(@PathVariable Long categoryId, @RequestBody @Valid SaveCategory saveCategory) {
        Category category = categoryService.updateOneById(categoryId, saveCategory);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PutMapping("/{categoryId}/disabled")
    public ResponseEntity<Category> disabledOneById(@PathVariable Long categoryId) {
        Category category = categoryService.disabledOneById(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }
}
