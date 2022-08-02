package com.cydeo.service.impl;

import com.cydeo.dto.ProductDTO;
import com.cydeo.entity.Product;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.ProductRepository;
import com.cydeo.service.ProductService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final UserService userService;
    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(UserService userService, ProductRepository productRepository, MapperUtil mapperUtil) {
        this.userService = userService;
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> listAllProducts() {
        List<Product> list = productRepository.findAllByCompany(userService.findCompanyByLoggedInUser());
        return list.stream()
                .map(product -> mapperUtil.convert(product, new ProductDTO())).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        return mapperUtil.convert(productRepository.findById(id).get(), new ProductDTO());
    }

    @Override
    public ProductDTO findByDescription(String id) {
        return productRepository.findByDescription(id);
    }

    @Override
    public void updateProduct(ProductDTO product) {
        Product p = mapperUtil.convert(product,new Product());
        productRepository.save(p);
    }

    @Override
    public void create(ProductDTO productDTO) {
        productDTO.setQty(BigInteger.ZERO);
        save(productDTO);
    }
    @Override
    public void save(ProductDTO productDTO) {
        Product convertedProduct = mapperUtil.convert(productDTO, new Product());
        convertedProduct.setCompany(userService.findCompanyByLoggedInUser());
        convertedProduct.setEnabled(true);
        productRepository.save(convertedProduct);
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        Product product = productRepository.findById(dto.getId()).get();
        Product convertedProduct = mapperUtil.convert(dto,new Product());
        convertedProduct.setCompany(userService.findCompanyByLoggedInUser());
        convertedProduct.setEnabled(product.getEnabled());
        convertedProduct.setQty(product.getQty());
        productRepository.save(convertedProduct);
        return findById(convertedProduct.getId());
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).get();
        product.setIsDeleted(true);
        productRepository.save(product);
    }

}
