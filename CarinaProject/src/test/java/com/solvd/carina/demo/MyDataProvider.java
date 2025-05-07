package com.solvd.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *  Parameterized testing using two different approaches:
 *  1. Hardcoded DataProvider: Tests basic addition operations with predefined values
 *  2. Excel-based DataProvider: Tests multiple arithmetic operations (ADD/SUBTRACT/MULTIPLY/DIVIDE)
 *
 * @author Paula Kawalec
 */
public class MyDataProvider implements IAbstractTest, IAbstractDataProvider {

    /**
     * Parametrization using DataProvider "DP1"
     *
     * @param a int
     * @param b int
     * @param c int
     */
    @Test(dataProvider = "DP1")
    public void testSumOperation(int a, int b, int c) {
        int actual = a + b;
        Assert.assertEquals(actual, c, "Invalid sum result!");
    }

    /**
     * DaraProvider "DP1" method that return Object[][]
     */
    @DataProvider(parallel = false, name = "DP1")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {2, 3, 5},
                {6, 6, 12},
                {5, 8, 10}
        };
    }

    /**
     * Parametrization using external xlsx file
     * Testing addition, subtraction, division, multiplication
     * Using operation column to determine which math operation to execute
     *
     * @param operation String
     * @param a String
     * @param b String
     * @param expected String
     */
    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/Calculator.xlsx", sheet="Sheet1", dsUid = "TUID", dsArgs = "operation,a,b,expected")
    public void testXlsMathOperations(String operation, String a, String b, String expected) {
        try {
            int numA = Integer.parseInt(a);
            int numB = Integer.parseInt(b);
            int actual = 0;

            switch (operation.toUpperCase()) {
                case "ADD":
                    actual = numA + numB;
                    break;
                case "SUBTRACT":
                    actual = numA - numB;
                    break;
                case "MULTIPLY":
                    actual = numA * numB;
                    break;
                case "DIVIDE":
                    actual = numA / numB;
                    break;
                default:
                    Assert.fail("Unsupported operation: " + operation);
            }

            int expectedResult = Integer.parseInt(expected);
            Assert.assertEquals(actual, expectedResult, "Operation '" + operation + "' failed");

        } catch (ArithmeticException e) {
            // Handle division by zero or other arithmetic issues
            Assert.assertEquals(expected, "ArithmeticException",
                    "Unexpected arithmetic error during operation '" + operation + "': " + e.getMessage());
        } catch (NumberFormatException e) {
            Assert.fail("Invalid number format in input values: " + e.getMessage());
        }
    }
}







