package com.api.PrimeNumberService.service;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Prime Numbers Generator Interface
 * Reason Default methods in interfaces allow new methods to be added to an interface without breaking existing code that implements that interface.
 * @author Divya Venkatesh
 * @date 21/03/2023
 */
@Service
public interface PrimeNumberGeneratorService {

    List<Integer> generatePrimes(int inputNumber);
}
