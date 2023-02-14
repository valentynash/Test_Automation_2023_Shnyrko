package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class DivTest extends BaseTest {

    @Test(description = "Verify  that division is correct",
            dataProvider = "divideDataProvider",  dataProviderClass = CalculatorDataProvider.class)
    public void divTest(double a, double b, double res) {
        var act = calculator.div(a, b);
        assertThat(act).isEqualTo(res);
    }
}
