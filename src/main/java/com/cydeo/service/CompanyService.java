package com.cydeo.service;

import com.cydeo.dto.CompanyDTO;
import com.cydeo.entity.Company;

import java.math.BigDecimal;
import java.util.List;

public interface CompanyService {
    List<CompanyDTO> listAllCompanies();

    CompanyDTO findById(Long Id);

    void save(CompanyDTO company);

    CompanyDTO update(CompanyDTO dto);

    CompanyDTO findByEmail(String email);

    void reopen(Long id);

    void close(Long id);

    BigDecimal findTaxByCompany();

    Company findCompanyByLoggedInUser();
}
