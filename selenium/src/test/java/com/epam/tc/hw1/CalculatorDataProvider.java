package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {

    @DataProvider(name = "addTwoNumbersDataProvider")
    public static Object[][] addTwoNumbersDataProvider() {
        return new Object[][]{
                {1001.2, 2.0, 1003.2},
                {-1.0, -2.0, -3.0},
                {-0.5, 2.5, 2.0},
                {0.0, 5.0, 5.0},
                {5.0, 0.0, 5.0},
                {1.9, -1.9, 0.0}
        };
    }

    @DataProvider(name = "divideDataProvider")
    public static Object[][] divideDataProvider() {
        return new Object[][]{
                // {1.2, 0.2, 6.0}, bug expected: 6.0 but was: 5.999999999999999
                {-1.0, -2.0, 0.5},
                {-10., 2.0, -5.0},
                {0.0, 5.0, 0.0},
                {100.0, -0.1, -1000.0}
        };
    }

    @DataProvider(name = "subtractDataProvider")
    public static Object[][] subtractDataProvider() {
        return new Object[][]{
                {1.2, 0.2, 1.0},
                {-10.0, -2.0, -8.0},
                {-10.0, 2.8, -12.8},
                {0.0, -5.0, 5.0},
                {-5.0, 0.0, -5.0},
                {100.0, -0.1, 100.1}
        };
    }

    @DataProvider(name = "multiplicationDataProvider")
    public static Object[][] multiplicationDataProvider() {
        return new Object[][]{
                // {1.2, 0.2, 0.24}, bug expected: 0.24 but was: 0.0
                {-10.0, -2.0, 20.0},
                {-10.0, 2.8, -28.0},
                {0.0, -5.0, 0.0},
                {-5.0, 0.0, 0.0},
                {100.0, -0.1, -10.0}
        };
    }
}
