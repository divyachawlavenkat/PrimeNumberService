package com.api.PrimeNumberService.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * prime number generator service method implementation
 *
 * @author divyavenkatesh
 * @date 21/03/2023
 */
@Service
public class PrimeNumberGeneratorServiceImpl implements PrimeNumberGeneratorService {

    /**
     * Implemented functional programming for Sieve of Eratosthenes algorithm to generate n primes
     * Reason The time complexity of this algorithm is O(n log log n), where n is the limit.
     * The space complexity is O(n),
     * @param number number
     * @return {@link List}
     * @author divyavenkatesh
     * @date 21/03/2023
     */
    @Override
    public List<Integer> generatePrimes(int number) {
        return IntStream.rangeClosed(2, number)
                .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(i -> n % i != 0))
                .boxed()
                .collect(Collectors.toList());
    }
}

