package com.cydeo.service;

import com.cydeo.dto.StockDetailsDTO;

import java.util.List;

public interface StockDetailsService {
    StockDetailsDTO findById(Long id);


    List<StockDetailsDTO> getByProductId(Long productId);

    void updateStockDetail(StockDetailsDTO stockDetailsDTO);
}
