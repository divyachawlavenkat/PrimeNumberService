package com.api.PrimeNumberService.service;

import com.api.PrimeNumberService.model.PrimesResult;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrimesService {

    public PrimesResult getPrimes(int number) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return new PrimesResult(number, primes);
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
