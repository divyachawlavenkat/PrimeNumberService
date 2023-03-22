package com.api.PrimeNumberService.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * prime number generator service methods implementation
 *
 * @author divyavenkatesh
 * @date 21/03/2023
 */
@Service
public class PrimeNumberGeneratorServiceImpl implements PrimeNumberGeneratorService {

    /**
     * Implemented functional programming for Sieve of Eratosthenes algorithm
     * Reason The time complexity of this algorithm is O(n log log n), where n is the limit. The space complexity is O(n),
     * since we need to store an array of boolean values of size n+1 to mark the primes.
     * Finds all prime numbers up to a given limit.
     * It works by creating a list of numbers from 2 to the given limit and
     * iteratively marking the multiples of each prime number as composite until all numbers have been checked.
     * The remaining numbers in the list are then the prime numbers.
     *
     * @param number number
     * @return {@link List}
     * @see List
     * @see Integer
     * @author divyavenkatesh
     */
    @Override
    public List<Integer> generatePrimes(int number) {
        if (number < 2) {
            throw new IllegalArgumentException("Input Number should be greater than 1");
        }
        return IntStream.rangeClosed(2, number)
                .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(i -> n % i != 0))
                .boxed()
                .collect(Collectors.toList());
    }
}


