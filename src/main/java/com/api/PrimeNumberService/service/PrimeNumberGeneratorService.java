package com.api.PrimeNumberService.service;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Default methods in interfaces allow new methods to be added to an interface without breaking
 * existing code that implements that interface.
 * This is because existing implementations will simply inherit the default implementation of the new method.
 * Prime Numbers Generator Interface
 *
 * @author Divya Venkatesh
 * @date 21/03/2023
 */
@Service
public interface PrimeNumberGeneratorService {

    List<Integer> generatePrimes(int inputNumber);
}
