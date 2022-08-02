package com.cydeo.service;

import com.example.accountingapp.dto.StockDetailsDTO;

import java.util.List;

public interface StockDetailsService {
    StockDetailsDTO findById(Long id);


    List<StockDetailsDTO> getByProductId(Long productId);

    void updateStockDetail(StockDetailsDTO stockDetailsDTO);
}
