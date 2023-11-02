package com.cursos.api.springsecuritycourse.service.impl;

import com.cursos.api.springsecuritycourse.dto.SaveCategory;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import com.cursos.api.springsecuritycourse.persistence.repository.CategoryRepository;
import com.cursos.api.springsecuritycourse.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Category> findOneById(Long categoryId) {
        return Optional.empty();
    }

    @Override
    public Category createOne(SaveCategory saveCategory) {
        return null;
    }

    @Override
    public Category updateOneById(Long categoryId, SaveCategory saveCategory) {
        return null;
    }

    @Override
    public Category disabledOneById(Long categoryId) {
        return null;
    }
}
