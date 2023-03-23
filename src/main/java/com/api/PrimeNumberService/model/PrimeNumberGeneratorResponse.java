package com.api.PrimeNumberService.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 *  prime number generator response model
 *  JSON return params
 *  initial referring to given input value
 *  primes is return actual result returns all the prime numbers up to and including a number provided.
 *
 * @author divyavenkatesh
 * @date 18/03/2023
 */
@Data
@AllArgsConstructor
public class PrimeNumberGeneratorResponse {
    private int initial;
    private List<Integer> primes;
}
