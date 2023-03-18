package com.api.PrimeNumberService.controller;

import com.api.PrimeNumberService.model.PrimeNumberGeneratorResult;
import com.api.PrimeNumberService.service.PrimeNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *  prime number generator controller
 *
 *  @author divyavenkatesh
 */
@RestController
public class PrimeNumberGeneratorController {

    @Autowired
    private PrimeNumberGeneratorService primeNumberGeneratorService;

    /**
     * controller method starts to process the web request by interacting with the service
     * get primes
     * @param number number
     * @return {@link PrimeNumberGeneratorResult}
     * @see PrimeNumberGeneratorResult
     */
    @GetMapping("/primes/{number}")
    public ResponseEntity<PrimeNumberGeneratorResult> getPrimes(@PathVariable int number) {
        try {
            PrimeNumberGeneratorResult primeNumberGeneratorResult = primeNumberGeneratorService.generatePrimes(number);
            return new ResponseEntity<>(primeNumberGeneratorResult, HttpStatus.OK);
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
