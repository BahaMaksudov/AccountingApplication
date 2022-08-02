package com.cydeo.service.impl;

import com.cydeo.dto.PaymentDTO;
import com.cydeo.entity.Payment;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.PaymentRepository;
import com.cydeo.service.PaymentService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
  private final PaymentRepository paymentRepository;
  private final MapperUtil mapperUtil;
  private final UserService userService;

  public PaymentServiceImpl(PaymentRepository paymentRepository, MapperUtil mapperUtil, UserService userService) {
    this.paymentRepository = paymentRepository;
    this.mapperUtil = mapperUtil;
    this.userService = userService;
  }

  @Override
  public List<PaymentDTO> listAllPayments() {
    return paymentRepository.findAllBy().stream()
        .map(p -> mapperUtil.convert(p, new PaymentDTO()))
        .collect(Collectors.toList());
  }

  @Override
  public List<PaymentDTO> listByYearAndCompany(String year) {

      return paymentRepository.findPaymentByYearOrderByMonth(year).stream()
              .filter(payment -> payment.getCompany().equals(userService.findCompanyByLoggedInUser()))
              .map(payment -> mapperUtil.convert(payment, new PaymentDTO()))
              .collect(Collectors.toList());
  }

  @Override
  public PaymentDTO findById(Long id) {
    return mapperUtil.convert(paymentRepository.findById(id), new PaymentDTO());
  }

  @Override
  public void delete(Long id) {}

  @Override
  public PaymentDTO findPaymentById(Long id) {
    return mapperUtil.convert(paymentRepository.findPaymentById(id), new PaymentDTO());
  }

  @Override
  public void chargePaymentById(Long id) {
    Payment payment = paymentRepository.findPaymentById(id);
    payment.setIsPaid(true);
    paymentRepository.save(payment);
  }


}
