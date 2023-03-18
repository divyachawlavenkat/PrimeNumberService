package com.api.PrimeNumberService.controller;

import com.api.PrimeNumberService.model.PrimesResult;
import com.api.PrimeNumberService.service.PrimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimesController {

    @Autowired
    private PrimesService primesService;

    @GetMapping("/primes/{number}")
    public PrimesResult getPrimes(@PathVariable int number) {
        return primesService.getPrimes(number);
    }
}
