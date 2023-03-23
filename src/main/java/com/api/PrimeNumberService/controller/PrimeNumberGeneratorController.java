package com.api.PrimeNumberService.controller;

import com.api.PrimeNumberService.service.PrimeNumberGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * prime number generator controller
 * Controller method will call generate prime numbers service
 *
 * @author divyavenkatesh
 * @date 21/03/2023
 */
@RestController
public class PrimeNumberGeneratorController {
    @Autowired
    PrimeNumberGeneratorServiceImpl primeNumberGeneratorServiceImpl;

    /**
     * getPrimes method calculates and returns all the prime numbers up to and including a number provided.
     * Return ResponseEntity
     * JSON result "Initial" and "Primes"
     *
     * @param number number
     * @return {@link ResponseEntity}
     * @author Divya Venkatesh
     * @date 21/03/2023
     */
    @GetMapping("/primes/{number}")
    public ResponseEntity<Map<String, Object>> getPrimes(@PathVariable int number) {
        try {
            return Optional.of(number)
                    .filter(n -> n > 1)
                    .map(primeNumberGeneratorServiceImpl::generatePrimes)
                    .map(primes -> Map.of("Initial", number,"Primes", primes))
                    .map(ResponseEntity::ok)
                    .orElseGet(this::customMessageForInvalidInput);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * custom message invalid input via ResponseEntity
     * Return custom message to end user
     * JSON result "InvalidInput", "Input Number should be greater than 1"
     *
     * @author Divya Venkatesh
     * @date 21/03/2023
     */
    public ResponseEntity<Map<String, Object>> customMessageForInvalidInput() {
        return ResponseEntity.ok(Map.of(
                "InvalidInput", "Input Number should be greater than 1"
        ));
    }
}
