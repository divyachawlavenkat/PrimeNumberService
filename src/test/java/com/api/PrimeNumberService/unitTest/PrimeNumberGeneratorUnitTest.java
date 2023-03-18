package com.api.PrimeNumberService.unitTest;

import com.api.PrimeNumberService.model.PrimeNumberGeneratorResult;
import com.api.PrimeNumberService.service.PrimeNumberGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 *  prime number generator unit test
 *  @author divyavenkatesh
 */
public class PrimeNumberGeneratorUnitTest {
    private PrimeNumberGeneratorService primeNumberGeneratorService;

    @BeforeEach
    public void setUp() {
        primeNumberGeneratorService = new PrimeNumberGeneratorService();
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGiven10() {
        PrimeNumberGeneratorResult expected = new PrimeNumberGeneratorResult(10, Arrays.asList(2, 3, 5, 7));
        PrimeNumberGeneratorResult actual = primeNumberGeneratorService.generatePrimes(10);
        assertEquals(expected.getInitial(), actual.getInitial());
        assertEquals(expected.getPrimes(), actual.getPrimes());
    }

    @Test
    public void generatePrimes_returnsEmptyList_whenGiven1() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            primeNumberGeneratorService.generatePrimes(1);
        });
        assertEquals("number must be at least 2", e.getMessage());
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGiven100() {
        PrimeNumberGeneratorResult expected = new PrimeNumberGeneratorResult(100, Arrays.asList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97));

    }
    @Test
    public void generatePrimes_returnsCorrectResult_whenGivenZero() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            primeNumberGeneratorService.generatePrimes(0);
        });
        assertEquals("number must be at least 2", e.getMessage());
    }


    @Test
    public void generatePrimes_returnsCorrectResult_whenGivenNegativeNumber() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            primeNumberGeneratorService.generatePrimes(-10);
        });
        assertEquals("number must be at least 2", e.getMessage());

    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGivenSmallNumber() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            primeNumberGeneratorService.generatePrimes(1);
        });
        assertEquals("number must be at least 2", e.getMessage());
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGiven20() {
        PrimeNumberGeneratorResult expected = new PrimeNumberGeneratorResult(100, Arrays.asList(2,3,5,7,11,13,17,19));

    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> primeNumberGeneratorService.generatePrimes(-0));
        assertThrows(IllegalArgumentException.class, () -> primeNumberGeneratorService.generatePrimes(-89));
        assertThrows(IllegalArgumentException.class, () -> primeNumberGeneratorService.generatePrimes(1));
    }
}
       
