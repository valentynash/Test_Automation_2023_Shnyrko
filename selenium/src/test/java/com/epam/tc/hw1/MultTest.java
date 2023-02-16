package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class MultTest extends BaseTest {

    @Test(description = "Verify  that a multiplication of two numbers is correct",
            dataProvider = "multiplicationDataProvider",  dataProviderClass = CalculatorDataProvider.class)
    public void sumTest(double a, double b, double res) {
        var act = calculator.mult(a, b);
        assertThat(act).isEqualTo(res);
    }
}
