package com.api.PrimeNumberService.controller;

import com.api.PrimeNumberService.service.PrimeNumberGeneratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/primes")
public class PrimeNumberGeneratorController {
    @Autowired
    PrimeNumberGeneratorServiceImpl primeNumberGeneratorServiceImpl;

    /**
     * getPrimes calculates and returns all the prime numbers up to and including a number provided.
     * Return ResponseEntity JSON content "Initial" and "Primes"
     *
     * @param number number
     * @return {@link ResponseEntity}
     * @author Divya Venkatesh
     * @date 21/03/2023
     * @see ResponseEntity
     * @see Map
     */
    @GetMapping("/{number}")
    public ResponseEntity<Map<String, Object>> getPrimes(@PathVariable int number) {
        try {
            // 1 is not a prime number.
            // A prime number is defined as a positive integer greater than 1 that has no positive integer divisors other than 1 and itself.
            // However, 1 has only one positive divisor (which is 1 itself), so it does not meet this definition.
            // Negative integers are not considered prime numbers because the definition of a prime number only applies to positive integers.
            if (number <= 1) {
                return customMessageForInvalidInput();
            }
            List<Integer> primes = primeNumberGeneratorServiceImpl.generatePrimes(number);
            Map<String, Object> response = new HashMap<>();
            response.put("Initial", number);
            response.put("Primes", primes);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * custom message to a ResponseEntity
     * ResponseEntityBuilder class to create the response entity and set the message using the body() method
     *
     * @author Divya Venkatesh
     * @date 21/03/2023
     */
    public ResponseEntity<Map<String, Object>> customMessageForInvalidInput() {
        String customMessage = "Input Number should be greater than 1";
        Map<String, Object> response = new HashMap<>();
        response.put("InvalidInput", customMessage);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
