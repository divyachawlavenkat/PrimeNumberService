package com.api.PrimeNumberService.unitTest;

import com.api.PrimeNumberService.model.PrimesResult;
import com.api.PrimeNumberService.service.PrimesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PrimesServiceTest {

    private PrimesService primesService;

    @BeforeEach
    public void setUp() {
        primesService = new PrimesService();
    }

    @Test
    public void testGetPrimes() {
        PrimesResult expectedPrimesResult = new PrimesResult(10, Arrays.asList(2, 3, 5, 7));
    }
}
       
