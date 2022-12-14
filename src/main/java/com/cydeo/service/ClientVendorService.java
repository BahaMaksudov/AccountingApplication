package com.cydeo.service;

import com.cydeo.dto.ClientVendorDTO;
import com.cydeo.enums.CompanyType;

import java.util.List;

public interface ClientVendorService {
    List<ClientVendorDTO> listAllClients();
    ClientVendorDTO findById(Long id);
    void delete(Long id);
    void save(ClientVendorDTO dto);
    ClientVendorDTO update(ClientVendorDTO dto);
    ClientVendorDTO findByEmail(String email);

    List<ClientVendorDTO> findAllByCompanyType(CompanyType companyType);

    String findClientNameById(Long id);
}