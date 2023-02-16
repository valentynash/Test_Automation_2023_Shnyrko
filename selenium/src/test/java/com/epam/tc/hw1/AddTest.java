package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class AddTest extends BaseTest {

    @Test(description = "Verify  that a summa two numbers is correct",
            dataProvider = "addTwoNumbersDataProvider", dataProviderClass = CalculatorDataProvider.class)
    public void addTest(double a, double b, double res) {
        var sum = calculator.sum(a, b);
        assertThat(sum).isEqualTo(res);
    }
}
