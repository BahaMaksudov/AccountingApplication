package com.cydeo.repository;


import com.cydeo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findByEmail(String email);


    @Query(value = "SELECT id FROM Company where title = ?1")
    Optional<Company> findByTitle(@Param("companyName") String companyName);

}
