package com.sbmt.triangle;

public class TriangleHelper {
    private TriangleUtil triangleUtil;
    
    public TriangleHelper(TriangleUtil triangleUtil) {
        this.triangleUtil = triangleUtil;
    }

    public String findTriangleTypeBySides(String firstSideString, String secondSideString, String thirdSideString) {
        if (!triangleUtil.validateSidesParsingToDouble(firstSideString, secondSideString, thirdSideString)) {
            return "Проверьте правильность внесенных данных. Допустимые символы: , . и цифры";
        }

        double firstSide = triangleUtil.convertSideToDouble(firstSideString);
        double secondSide = triangleUtil.convertSideToDouble(secondSideString);
        double thirdSide = triangleUtil.convertSideToDouble(thirdSideString);

        if (!triangleUtil.validateDoubleParameters(firstSide, secondSide, thirdSide)) {
            return "Стороны треугольника не могут быть больше 999 и меньше 1";
        }

        if (!triangleUtil.isTriangle(firstSide, secondSide, thirdSide)) {
            return "Нарушено правило построения: a + b > c, где с – наибольший из трех отрезков";
        }

        if (triangleUtil.isEquilateral(firstSide, secondSide, thirdSide)) {
            return "Треугольник является равносторонним";
        }

        if (triangleUtil.isIsosceles(firstSide, secondSide, thirdSide)) {
            return "Треугольник является равнобедренным";
        }

        if (triangleUtil.isScalene(firstSide, secondSide, thirdSide)) {
            return "Треугольник является неравносторонним";
        }

        return "Неизвестный тип треугольника";
    }
}
