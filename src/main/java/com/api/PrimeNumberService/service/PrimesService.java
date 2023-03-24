package com.api.PrimeNumberService.service;

import com.api.PrimeNumberService.model.PrimesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * Prime Numbers Generator Interface
 * Reason Default methods in interfaces allow new methods to be added to an interface without breaking existing code that implements that interface.
 *
 * @author Divya Venkatesh
 * @date 21/03/2023
 */
@Service
public interface PrimesService {

    PrimesResponse generatePrimes(int inputNumber);
    ResponseEntity<Map<String, String>>customMessageForInvalidInput();
}