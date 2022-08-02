package com.cydeo.repository;


import com.cydeo.entity.Category;
import com.cydeo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByCompany(Company companyByLoggedInUser);

//    List<Category> findAllBy();

}
