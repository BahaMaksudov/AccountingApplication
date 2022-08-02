package com.cydeo.service;

import com.cydeo.dto.InvoiceProductDTO;
import com.cydeo.dto.ProductDTO;
import com.cydeo.entity.InvoiceProduct;

import java.math.BigDecimal;
import java.util.List;

public interface InvoiceProductService {

    List<InvoiceProduct> listAll();

    List<ProductDTO> findAllProductsByCompanyName(String companyName);


    void addInvoiceProductByInvoiceId(Long id, InvoiceProductDTO invoiceProductDTO);

    List<InvoiceProductDTO> findAllInvoiceProductsByInvoiceId(Long id);

    Long findInvoiceIdByInvoiceProductId(Long ipid);

    void deleteInvoiceProductById(Long ipid);


    List<InvoiceProductDTO> getByInvoiceId(Long invoiceId);

    List<InvoiceProductDTO> listAllAddedItems();

    List<InvoiceProductDTO> findAllByInvoiceId(Long id);

    void disableInvoiceProductsByInvoiceId(Long id);

    BigDecimal getTaxByInvoiceId(Long id);
}
