package com.cydeo.service;

import com.cydeo.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> listAllCategories();
    CategoryDTO findById(Long id);
    void delete(Long id);
    void save(CategoryDTO dto);
    CategoryDTO update(CategoryDTO dto);
}
