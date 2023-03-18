package com.api.PrimeNumberService.model;

import java.util.*;
public class PrimesResult {
    private int initial;
    private List<Integer> primes;

    public PrimesResult(int initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public int getInitial() {
        return initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
