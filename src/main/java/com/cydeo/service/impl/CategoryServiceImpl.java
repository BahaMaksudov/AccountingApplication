package com.cydeo.service.impl;

import com.cydeo.dto.CategoryDTO;
import com.cydeo.entity.Category;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.CategoryRepository;
import com.cydeo.service.CategoryService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final MapperUtil mapperUtil;
    private final UserService userService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, MapperUtil mapperUtil, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.mapperUtil = mapperUtil;
        this.userService = userService;
    }

    @Override
    public List<CategoryDTO> listAllCategories() {

        return categoryRepository.findAllByCompany(userService.findCompanyByLoggedInUser()).stream().map(category -> mapperUtil.convert(category, new CategoryDTO())).collect(Collectors.toList());
    }

    @Override
    public void save(CategoryDTO dto) {
        dto.setEnabled(true);
        dto.setCompanyDTO(userService.findCompanyDTOByLoggedInUser());
        categoryRepository.save(mapperUtil.convert(dto, new Category()));
    }

    @Override
    public CategoryDTO update(CategoryDTO dto) {

        Category category = categoryRepository.findById(dto.getId()).get();
        category.setDescription(dto.getDescription());
        dto.setCompanyDTO(userService.findCompanyDTOByLoggedInUser());
        categoryRepository.save(category);

        return dto;
    }

    @Override
    public CategoryDTO findById(Long id) {
        return mapperUtil.convert(categoryRepository.findById(id).get(), new CategoryDTO());
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).get();
        category.setIsDeleted(true);
        categoryRepository.save(category);
    }


}
