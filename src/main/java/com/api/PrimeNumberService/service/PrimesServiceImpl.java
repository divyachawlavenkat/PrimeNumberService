package com.api.PrimeNumberService.service;

import com.api.PrimeNumberService.model.PrimesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * prime number generator service methods implementation
 * @author divyavenkatesh
 * @date 21/03/2023
 */
@Service
public class PrimesServiceImpl implements PrimesService {

    /**
     * Implemented functional programming for Sieve of Eratosthenes algorithm to generate n primes
     * Reason The time complexity of this algorithm is O(n log log n), where n is the limit.The space complexity is O(n),
     * @param number number
     * @return {@link List}
     * @author divyavenkatesh
     * @date 21/03/2023
     */
    @Override
    public PrimesResponse getPrimes(int number) {
        List<Integer> primes = IntStream.rangeClosed(2, number)
                .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(i -> n % i != 0))
                .boxed()
                .collect(Collectors.toList());
        return new PrimesResponse(number, primes);
    }

    /**
     * custom error message invalid input via ResponseEntity
     * Return custom message to end user
     * JSON result "InvalidInput", "Initial input number should not be less than 2 and should not be negative integer"
     *
     * @author Divya Venkatesh
     * @date 21/03/2023
     */
    @Override
    public ResponseEntity<Map<String, String>> customMessageForInvalidInput() {
        return ResponseEntity.ok(Map.of(
                "Error", "Invalid input number",
                "Message", "To get valid Primes, Initial input number should not be less than 2 and should not be negative integer"

        ));
    }
}

