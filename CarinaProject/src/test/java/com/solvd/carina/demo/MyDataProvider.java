package com.solvd.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyDataProvider implements IAbstractTest, IAbstractDataProvider {
    @Test(dataProvider = "DP1")
    public void testMultiplyOperation(int a, int b, int c)
    {
        int actual = a * b;
        int expected = c;
        Assert.assertEquals(actual, expected, "Invalid multiply result!");
    }

    @DataProvider(parallel = false, name = "DP1")
    public static Object[][] dataprovider()
    {
        return new Object[][] {
                { 2, 3, 7 },
                { 6, 6, 36 },
                { 5, 8, 40 }
        };
    }

//    @Test(dataProvider = "DataProvider")
//    @XlsDataSourceParameters(path = "data_source/demo.xlsx", sheet = "Calculator", dsUid = "TUID", dsArgs = "a,b,c")
//    public void testXlsSumOperation(String a, String b, String c) {
//        int actual = Integer.valueOf(a) + Integer.valueOf(b);
//        int expected = Integer.valueOf(c);
//        Assert.assertEquals(actual, expected, "Invalid sum result!");
//    }


}
