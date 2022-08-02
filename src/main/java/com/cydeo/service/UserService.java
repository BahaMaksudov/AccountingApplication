package com.cydeo.service;

import com.cydeo.dto.CompanyDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Company;

import java.util.List;

public interface UserService {

    List<UserDTO> listAllUsers();

    void save(UserDTO dto);

    UserDTO update(UserDTO dto);

    void delete(String username);

    UserDTO findById(Long id);

    UserDTO findByEmail(String email);

    Company findCompanyByLoggedInUser();

    CompanyDTO findCompanyDTOByLoggedInUser();

    UserDTO findLoggedInUser();

}
