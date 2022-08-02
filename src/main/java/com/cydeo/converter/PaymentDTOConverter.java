package com.cydeo.converter;

import com.cydeo.dto.PaymentDTO;
import com.cydeo.service.PaymentService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class PaymentDTOConverter implements Converter<String, PaymentDTO> {
    private final PaymentService paymentService;

    public PaymentDTOConverter(@Lazy PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public PaymentDTO convert(String source) {
        if (source == null || source.equals("")) {
            return null;
        }

        return paymentService.findById(Long.parseLong(source));

    }
}
