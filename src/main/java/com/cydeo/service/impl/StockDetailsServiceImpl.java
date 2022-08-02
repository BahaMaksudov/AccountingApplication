package com.cydeo.service.impl;

import com.cydeo.dto.StockDetailsDTO;
import com.cydeo.entity.StockDetails;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.StockDetailsRepository;
import com.cydeo.service.StockDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StockDetailsServiceImpl implements StockDetailsService {

    private final MapperUtil mapperUtil;
    private final StockDetailsRepository stockDetailsRepository;

    public StockDetailsServiceImpl(MapperUtil mapperUtil, StockDetailsRepository stockDetailsRepository) {
        this.mapperUtil = mapperUtil;
        this.stockDetailsRepository = stockDetailsRepository;
    }

    @Override
    public StockDetailsDTO findById(Long id) {
        return mapperUtil.convert(stockDetailsRepository.findAllByProductId(id), new StockDetailsDTO());
    }

    @Override
    public List<StockDetailsDTO> getByProductId(Long productId) {
        List<StockDetailsDTO> stockDetailsDTOS = stockDetailsRepository.findAllByInvoiceId(productId)
                .stream()
                .filter(st -> st.getRemainingQuantity().intValue()!=0)
                .map(p -> mapperUtil.convert(p, new StockDetailsDTO())).collect(Collectors.toList());
        return stockDetailsDTOS;
    }

    @Override
    public void updateStockDetail(StockDetailsDTO stockDetailsDTO) {
        StockDetails s = mapperUtil.convert(stockDetailsDTO,new StockDetails());
        stockDetailsRepository.save(s);
    }


}
