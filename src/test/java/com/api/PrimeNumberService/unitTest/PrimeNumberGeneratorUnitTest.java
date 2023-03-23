package com.api.PrimeNumberService.unitTest;

import com.api.PrimeNumberService.model.PrimeNumberGeneratorResponse;
import com.api.PrimeNumberService.service.PrimeNumberGeneratorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * unit test cases to test method generatePrimes()
 * Testcases for all valid and invalid input number
 * Test cases for Objective 1 --> REST API service to calculate and returns all the prime numbers up to and including a valid input number provided.
 * Test Cases for Objective 2 --->REST API service will throw custom ResponseEnity message for invalid input number like 1,0, negative integers
 *
 * @author divyavenkatesh
 * @date 21/03/2023
 */
public class PrimeNumberGeneratorUnitTest {
    private PrimeNumberGeneratorServiceImpl primeNumberGeneratorServiceImpl;

    @BeforeEach
    public void setUp() {
        primeNumberGeneratorServiceImpl = new PrimeNumberGeneratorServiceImpl();
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenInputNumberTen() {
        //given
        int inputNumberToCheckPrimes = 10;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7));

    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenOne() {
        //given
        int inputNumberToCheckPrimes = 1;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Collections.emptyList());

    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenZero() {
        //given
        int inputNumberToCheckPrimes = 0;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Collections.emptyList());

    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGivenNegativeNumber() {
        //given
        int inputNumberToCheckPrimes = -100;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Collections.emptyList());

    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenNegativeNumber() {
        //given
        int inputNumberToCheckPrimes = -10;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Collections.emptyList());

    }

    //
    @Test
    public void generatePrimes_returnsEmptyList_whenGiven20() {
        //given
        int inputNumberToCheckPrimes = 20;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGiven100() {
        //given
        int inputNumberToCheckPrimes = 100;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGivenBigPositiveNumber() {
        //given
        int inputNumberToCheckPrimes = 50;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGivenTwelve() {
        //given
        int inputNumberToCheckPrimes = 12;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7, 11));
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGivenNumberFour() {
        //given
        int inputNumberToCheckPrimes = 4;

        //when
        PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Arrays.asList(2, 3));

    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> primeNumberGeneratorServiceImpl.generatePrimes(Integer.parseInt("aa")));
        assertThrows(IllegalArgumentException.class, () -> primeNumberGeneratorServiceImpl.generatePrimes(Integer.parseInt("test")));
        assertThrows(IllegalArgumentException.class, () -> primeNumberGeneratorServiceImpl.generatePrimes(Integer.parseInt("wrongInput")));
    }


    @Test
    public void testMethodNotThrowExceptionForNumberEighty() {
        //given
        int inputNumberToCheckPrimes = 80;

        //when
        assertDoesNotThrow(() -> {
            PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

            //then
            assertNotNull(response);
            assertEquals(response.getInitial(), inputNumberToCheckPrimes);
            assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79));
        });
    }


    @Test
    public void testMethodNotThrowExceptionForPositiveNumber() {
        //given
        int inputNumberToCheckPrimes = 16;

        //when
        assertDoesNotThrow(() -> {
            PrimeNumberGeneratorResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

            //then
            assertNotNull(response);
            assertEquals(response.getInitial(), inputNumberToCheckPrimes);
            assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7, 11, 13));
        });
    }
}

