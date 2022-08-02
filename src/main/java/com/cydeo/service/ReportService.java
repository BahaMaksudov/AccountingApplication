package com.cydeo.service;

import com.cydeo.dto.InvoiceDTO;
import com.cydeo.dto.ReportDTO;
import com.cydeo.entity.InvoiceProduct;
import com.cydeo.entity.Payment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ReportService {
    

    Map<String, BigDecimal> profitLoss();

    Set<ReportDTO> calculateByProducts();

    List<InvoiceDTO> findLast3ByCompany();

    List<InvoiceProduct> findAllByCompany();

    List<Payment> listAllByYearAndCompany(String year);
}