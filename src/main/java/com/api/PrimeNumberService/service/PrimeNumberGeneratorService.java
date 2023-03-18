package com.api.PrimeNumberService.service;

import com.api.PrimeNumberService.model.PrimeNumberGeneratorResult;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.*;

/**
 *  prime number generator service
 *  @author divyavenkatesh
 */
@Service
public class PrimeNumberGeneratorService {

    /**
     * generate primes by using Sieve of Eratosthenes algorithm
     *
     * Sieve of Eratosthenes is an algorithm for finding all prime numbers
     * up to a given limit by iteratively marking the multiples of each prime, starting with 2,
     * and then proceeding to the next unmarked number
     * until all multiples of primes less than or equal to the square root of the limit have been marked.
     * @param number number
     * @return {@link PrimeNumberGeneratorResult}
     * @see PrimeNumberGeneratorResult
     */
    public PrimeNumberGeneratorResult generatePrimes(int number) {
        if (number < 2) {
            throw new IllegalArgumentException("number must be at least 2");
        }

        boolean[] isComposite = new boolean[number+1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                for (int j = i*i; j <= number; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        return new PrimeNumberGeneratorResult(number, primes);
    }
}

