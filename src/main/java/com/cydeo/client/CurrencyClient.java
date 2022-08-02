package com.cydeo.client;



import com.cydeo.dto.client.Latest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(url = "https://www.frankfurter.app/",name="CURRENCY-CLIENT")
public interface CurrencyClient {

    @GetMapping("/latest")
    Latest getCurrency();


}
