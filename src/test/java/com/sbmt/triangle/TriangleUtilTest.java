package com.sbmt.triangle;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TriangleUtilTest {
    private static TriangleUtil triangleUtil;
    
    @BeforeClass
    public static void init() {
        triangleUtil = new TriangleUtil();
    }
    @Test
    public void shouldReturnTrueWhenParametersUnderBounds() {
        boolean actualResult = triangleUtil.validateDoubleParameters(2.0, 17.1, 129.2);
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenFirstParameterLessThenZero() {
        boolean actualResult = triangleUtil.validateDoubleParameters(-1.0, 17.1, 129.2);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenFirstParameterMoreThenThousand() {
        boolean actualResult = triangleUtil.validateDoubleParameters(1000, 17.1, 129.2);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenSecondParameterLessThenZero() {
        boolean actualResult = triangleUtil.validateDoubleParameters(20.0, -17.1, 129.2);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenSecondParameterMoreThenThousand() {
        boolean actualResult = triangleUtil.validateDoubleParameters(27.2, 1000, 129.2);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenThirdParameterLessThenZero() {
        boolean actualResult = triangleUtil.validateDoubleParameters(2.0, 17.1, -129.2);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenThirdParameterMoreThenThousand() {
        boolean actualResult = triangleUtil.validateDoubleParameters(24.1, 17.1, 1000);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnTrueWhenStringToDoubleParsingPossible() {
        boolean actualResult = triangleUtil.validateSidesParsingToDouble("0.3", "21,014", "30.12");
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenStringToDoubleParsingWithWordFirst() {
        boolean actualResult = triangleUtil.validateSidesParsingToDouble("twenty", "21.0", "30.12");
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenStringToDoubleParsingFirstEmptyLine() {
        boolean actualResult = triangleUtil.validateSidesParsingToDouble("", "21.0", "30.12");
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenStringToDoubleParsingWithWordSecond() {
        boolean actualResult = triangleUtil.validateSidesParsingToDouble("12.0", "twenty", "30.12");
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenStringToDoubleParsingSecondEmptyLine() {
        boolean actualResult = triangleUtil.validateSidesParsingToDouble("21.0", "", "30.12");
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenStringToDoubleParsingWithWordThird() {
        boolean actualResult = triangleUtil.validateSidesParsingToDouble("12.0", "11.0", "twenty");
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenStringToDoubleParsingThirdEmptyLine() {
        boolean actualResult = triangleUtil.validateSidesParsingToDouble("21.0", "30.12", "");
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenStringToDoubleParsingWithoutDot() {
        boolean actualResult = triangleUtil.validateSidesParsingToDouble("70", "21.0", "30.12");
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnTrueWhenTriangleValid() {
        boolean actualResult = triangleUtil.isTriangle(31.0, 34.2, 37.1);
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenFirstSideBiggerOrEqualThenSumOfOther() {
        boolean actualResult = triangleUtil.isTriangle(54.0, 12.2, 3.1);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenSecondSideBiggerOrEqualThenSumOfOther() {
        boolean actualResult = triangleUtil.isTriangle(51.0, 54.0, 3.0);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenThirdSideBiggerOrEqualThenSumOfOther() {
        boolean actualResult = triangleUtil.isTriangle(11.0, 12.2, 214.3);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnTrueWhenTriangleEquilateral() {
        boolean actualResult = triangleUtil.isEquilateral(12.0, 12.0, 12.0);
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenTriangleNotEquilateralFirstDifferent() {
        boolean actualResult = triangleUtil.isEquilateral(11.0, 12.0, 12.0);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenTriangleNotEquilateralThirdDifferent() {
        boolean actualResult = triangleUtil.isEquilateral(12.0, 12.0, 11.0);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnTrueWhenTriangleIsoscelesSecondAndThirdEqual() {
        boolean actualResult = triangleUtil.isIsosceles(11.0, 12.0, 12.0);
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void shouldReturnTrueWhenTriangleIsoscelesFirstAndSecondEqual() {
        boolean actualResult = triangleUtil.isIsosceles(12.0, 12.0, 11.0);
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void shouldReturnTrueWhenTriangleIsoscelesFirstAndThirdEqual() {
        boolean actualResult = triangleUtil.isIsosceles(12.0, 11.0, 12.0);
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenTriangleNotIsosceles() {
        boolean actualResult = triangleUtil.isIsosceles(11.0, 12.0, 13.0);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnTrueWhenTriangleScalene() {
        boolean actualResult = triangleUtil.isScalene(11.0, 12.0, 13.0);
        Assert.assertEquals(true, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenTriangleNotScaleneSecondAndThirdEqual() {
        boolean actualResult = triangleUtil.isScalene(11.0, 13.0, 13.0);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenTriangleNotScaleneFirstAndThirdEqual() {
        boolean actualResult = triangleUtil.isScalene(13.0, 11.0, 13.0);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldReturnFalseWhenTriangleNotScaleneFirstAndSecondEqual() {
        boolean actualResult = triangleUtil.isScalene(13.0, 13.0, 11.0);
        Assert.assertEquals(false, actualResult);
    }

    @Test
    public void shouldCorrectlyConvertStringToDoubleWithComma() {
        double actualValue = triangleUtil.convertSideToDouble("12,01");
        Assert.assertEquals(12.01, actualValue, 0.01);
    }

    @Test
    public void shouldCorrectlyConvertStringToDoubleWithDot() {
        double actualValue = triangleUtil.convertSideToDouble("12.0");
        Assert.assertEquals(12.0, actualValue, 0.01);
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowExceptionWhenStringNotCorrect() {
        triangleUtil.convertSideToDouble("12.0sdsa");
    }
}
