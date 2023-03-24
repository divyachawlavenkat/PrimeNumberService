package com.api.PrimeNumberService.controller;

import com.api.PrimeNumberService.model.PrimesResponse;
import com.api.PrimeNumberService.service.PrimesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * REST Prime Controller will handle the incoming requests.
 *
 * @author divyavenkatesh
 * @RestController annotation indicates that this is a REST controller that will handle incoming requests.
 * PrimesController method starts to process the web request by interacting with the service
 * @date 21/03/2023
 */
@RestController
public class PrimesController {
    @Autowired
    PrimesServiceImpl primesService;

    /**
     * @GetMapping (" / primes / { number } ") specifies that this method will handle GET requests to /primes/{number},
     * {number} is a path variable that will be initial number in the request to get primes.
     * Spring Boot invokes that method and returns the data that is returned by the method as an HTTP response.
     * @author Divya Venkatesh
     * @date 21/03/2023
     * @see Object
     */
    @GetMapping("/primes/{number}")
    public Object getPrimesByInitialNumber(@PathVariable(value = "number") int number) {
        try {
            return number > 1 ?
                    Optional.of(number)
                            .map(primesService::getPrimes)
                            .map(primes -> new PrimesResponse(number, primes.getPrimes()))
                            .orElseThrow(() -> new IllegalArgumentException("Invalid input"))
                    : primesService.customMessageForInvalidInput();
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
