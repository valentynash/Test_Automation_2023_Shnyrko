package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class SubTest extends BaseTest {

    @Test(description = "Verify  that a subtraction of two numbers is correct",
            dataProvider = "subtractDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void subTest(double a, double b, double res) {
        var act = calculator.sub(a, b);
        assertThat(act).isEqualTo(res);
    }
}
