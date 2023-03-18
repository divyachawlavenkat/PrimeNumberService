package com.api.PrimeNumberService.model;

import lombok.Data;

import java.util.*;
/**
 *  prime number generator result
 *  input intial
 *  output primes
 *  @author divyavenkatesh
 */
@Data
public class PrimeNumberGeneratorResult {
    private int initial;
    private List<Integer> primes;

    public PrimeNumberGeneratorResult(int initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }
}
