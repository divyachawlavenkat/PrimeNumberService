package com.api.PrimeNumberService.controller;

import com.api.PrimeNumberService.model.PrimeNumberGeneratorResult;
import com.api.PrimeNumberService.service.PrimeNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public PrimeNumberGeneratorResult getPrimes(@PathVariable int number) {
        return primeNumberGeneratorService.generatePrimes(number);
    }
}
