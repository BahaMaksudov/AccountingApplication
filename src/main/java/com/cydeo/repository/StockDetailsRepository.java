package com.cydeo.repository;



import com.cydeo.entity.StockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockDetailsRepository extends JpaRepository<StockDetails, Long> {

    List<StockDetails> findAllByProductId(Long Id);

    Optional<StockDetails> findFirstByProductId(Long id);


    @Query(value = "SELECT * FROM stock_details i where i.product_id =?1",nativeQuery = true)
    List<StockDetails> findAllByInvoiceId(@Param("productId") Long productId);
}
