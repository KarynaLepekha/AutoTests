package Calculation;

import org.testng.annotations.DataProvider;

public class GetData {

    @DataProvider
    public Object [][] dataForAdding() {
        return new Object[][]{
                {2, 5, 7},
                {3, 3, 6},
                {2, 0, 2},
                {0, -1, -1}
        };
    }

    @DataProvider
    public Object [][] dataForSubtract() {
        return new Object[][]{
                {2, 5, -3},
                {3, 3, 0},
                {2, 0, 2},
                {0, -1, 1}
        };
    }
    @DataProvider
    public Object [][] dataForMultiplication() {
        return new Object[][]{
                {2, 5, 10},
                {3, 3, 9},
                {2, 0, 0},
                {1, -1, -1}
        };
    }
    @DataProvider
    public Object [][] dataForDivision() {
        return new Object[][]{
                {10, 5, 2},
                {3, 3, 1},
                {15, 5, 3},
                {20, 2, 10}
        };
    }

}
