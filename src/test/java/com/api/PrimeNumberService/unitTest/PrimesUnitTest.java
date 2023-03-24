package com.api.PrimeNumberService.unitTest;

import com.api.PrimeNumberService.model.PrimesResponse;
import com.api.PrimeNumberService.service.PrimesServiceImpl;
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
public class PrimesUnitTest {
    private PrimesServiceImpl primeNumberGeneratorServiceImpl;

    @BeforeEach
    public void setUp() {
        primeNumberGeneratorServiceImpl = new PrimesServiceImpl();
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenInputNumberTen() {
        //given
        int inputNumberToCheckPrimes = 10;

        //when
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

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
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Collections.emptyList());

    }

    @Test
    public void generatePrimes_returnsEmptyResult_whenZero() {
        //given
        int inputNumberToCheckPrimes = 0;

        //when
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Collections.emptyList());

    }

    @Test
    public void generatePrimes_returnsEmptyResult_whenGivenNegativeNumber() {
        //given
        int inputNumberToCheckPrimes = -100;

        //when
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

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
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Collections.emptyList());

    }

    //
    @Test
    public void generatePrimes_returnsEmptyList_whenGivenTwenty() {
        //given
        int inputNumberToCheckPrimes = 20;

        //when
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGivenHundred() {
        //given
        int inputNumberToCheckPrimes = 100;

        //when
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

        //then
        assertNotNull(response);
        assertEquals(response.getInitial(), inputNumberToCheckPrimes);
        assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
    }

    @Test
    public void generatePrimes_returnsCorrectResult_whenGivenFiftyPositiveNumber() {
        //given
        int inputNumberToCheckPrimes = 50;

        //when
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

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
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

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
        PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

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
            PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

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
            PrimesResponse response = primeNumberGeneratorServiceImpl.generatePrimes(inputNumberToCheckPrimes);

            //then
            assertNotNull(response);
            assertEquals(response.getInitial(), inputNumberToCheckPrimes);
            assertEquals(response.getPrimes(), Arrays.asList(2, 3, 5, 7, 11, 13));
        });
    }
}

