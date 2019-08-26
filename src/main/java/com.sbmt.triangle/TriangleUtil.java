package com.sbmt.triangle;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class TriangleUtil {
    private static final String DECIMAL_PATTERN = "([0-9]*)\\.([0-9]*)";

    public boolean validateDoubleParameters(double firstSide, double secondSide, double thirdSide) {
        return isSingleParameterValid(firstSide) &&
                isSingleParameterValid(secondSide) &&
                isSingleParameterValid(thirdSide);
    }

    public boolean validateSidesParsingToDouble(String firstSide, String secondSide, String thirdSide) {
        return validateStringToDouble(firstSide) &&
                validateStringToDouble(secondSide) &&
                validateStringToDouble(thirdSide);
    }

    public boolean isTriangle(double firstSide, double secondSide, double thirdSide) {
        return !(firstSide + secondSide <= thirdSide) &&
                !(firstSide + thirdSide <= secondSide) &&
                !(secondSide + thirdSide <= firstSide);
    }

    public boolean isEquilateral(double firstSide, double secondSide, double thirdSide) {
        return firstSide == secondSide && secondSide == thirdSide;
    }

    public boolean isIsosceles(double firstSide, double secondSide, double thirdSide) {
        return firstSide == secondSide || secondSide == thirdSide || thirdSide == firstSide;
    }

    public boolean isScalene(double firstSide, double secondSide, double thirdSide) {
        return firstSide != secondSide && secondSide != thirdSide && thirdSide != firstSide;
    }

    public double convertSideToDouble(String side) {
        String sideToParse = side.replaceAll(",", ".");
        return Double.parseDouble(sideToParse);
    }

    private boolean validateStringToDouble(String side) {
        if (StringUtils.isEmpty(side)) {
            return false;
        }
        String currentSide = side.replaceAll(",", ".");
        return Pattern.matches(DECIMAL_PATTERN, currentSide);
    }

    private boolean isSingleParameterValid(double side) {
        return !(side < 1) && !(side > 999);
    }
}
