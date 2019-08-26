package com.sbmt.triangle;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TriangleHelperTest {
    private static final String INVALID_STRING_PARAMETERS_MESSAGE = "Проверьте правильность внесенных данных." +
            " Допустимые символы: , . и цифры";
    private static final String INVALID_SIDE_SIZE_MESSAGE = "Стороны треугольника не могут быть больше 999 и меньше 1";
    private static final String NOT_TRIANGLE_MESSAGE = "Нарушено правило построения: a + b > c, " +
            "где с – наибольший из трех отрезков";
    private static final String EQUILATERAL_TRIANGLE_MESSAGE = "Треугольник является равносторонним";
    private static final String ISOSCELES_TRIANGLE_MESSAGE = "Треугольник является равнобедренным";
    private static final String SCALENE_TRIANGLE_MESSAGE = "Треугольник является неравносторонним";
    private static final String UNKNOWN_TRIANGLE_MESSAGE = "Неизвестный тип треугольника";

    @Mock
    private TriangleUtil triangleUtil;
    @InjectMocks
    private TriangleHelper triangleHelper;

    @Before
    public void initMock() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void verifyInteractions() {
        verifyNoMoreInteractions(triangleUtil);
    }

    @Test
    public void shouldReturnMessageInvalidSymbols() {
        //when
        when(triangleUtil.validateSidesParsingToDouble(anyString(), anyString(), anyString())).thenReturn(false);
        String actualMessage = triangleHelper.findTriangleTypeBySides("1", "2", "3");
        //then
        Assert.assertEquals(INVALID_STRING_PARAMETERS_MESSAGE, actualMessage);
        verify(triangleUtil).validateSidesParsingToDouble("1", "2", "3");
    }

    @Test
    public void shouldReturnMessageInvalidSideSize() {
        //when
        when(triangleUtil.validateSidesParsingToDouble(anyString(), anyString(), anyString())).thenReturn(true);
        when(triangleUtil.convertSideToDouble(anyString())).thenReturn(2.0);
        when(triangleUtil.validateDoubleParameters(anyDouble(), anyDouble(), anyDouble())).thenReturn(false);
        //then
        String actualMessage = triangleHelper.findTriangleTypeBySides("1", "2", "3");
        Assert.assertEquals(INVALID_SIDE_SIZE_MESSAGE, actualMessage);
        verify(triangleUtil).validateSidesParsingToDouble("1", "2", "3");
        verify(triangleUtil, times(3)).convertSideToDouble(anyString());
        verify(triangleUtil).validateDoubleParameters(2.0, 2.0, 2.0);
    }

    @Test
    public void shouldReturnMessageNotTriangle() {
        //when
        when(triangleUtil.validateSidesParsingToDouble(anyString(), anyString(), anyString())).thenReturn(true);
        when(triangleUtil.convertSideToDouble(anyString())).thenReturn(2.0);
        when(triangleUtil.validateDoubleParameters(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        when(triangleUtil.isTriangle(anyDouble(), anyDouble(), anyDouble())).thenReturn(false);
        //then
        String actualMessage = triangleHelper.findTriangleTypeBySides("1", "2", "3");
        Assert.assertEquals(NOT_TRIANGLE_MESSAGE, actualMessage);
        verify(triangleUtil).validateSidesParsingToDouble("1", "2", "3");
        verify(triangleUtil, times(3)).convertSideToDouble(anyString());
        verify(triangleUtil).validateDoubleParameters(2.0, 2.0, 2.0);
        verify(triangleUtil).isTriangle(2.0, 2.0, 2.0);
    }

    @Test
    public void shouldReturnMessageTriangleEquilateral() {
        //when
        when(triangleUtil.validateSidesParsingToDouble(anyString(), anyString(), anyString())).thenReturn(true);
        when(triangleUtil.convertSideToDouble(anyString())).thenReturn(2.0);
        when(triangleUtil.validateDoubleParameters(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        when(triangleUtil.isTriangle(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        when(triangleUtil.isEquilateral(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        //then
        String actualMessage = triangleHelper.findTriangleTypeBySides("2", "2", "2");
        Assert.assertEquals(EQUILATERAL_TRIANGLE_MESSAGE, actualMessage);
        verify(triangleUtil).validateSidesParsingToDouble("2", "2", "2");
        verify(triangleUtil, times(3)).convertSideToDouble(anyString());
        verify(triangleUtil).validateDoubleParameters(2.0, 2.0, 2.0);
        verify(triangleUtil).isTriangle(2.0, 2.0, 2.0);
        verify(triangleUtil).isEquilateral(2.0, 2.0, 2.0);
    }

    @Test
    public void shouldReturnMessageTriangleIsosceles() {
        //when
        when(triangleUtil.validateSidesParsingToDouble(anyString(), anyString(), anyString())).thenReturn(true);
        when(triangleUtil.convertSideToDouble(anyString())).thenReturn(2.0);
        when(triangleUtil.validateDoubleParameters(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        when(triangleUtil.isTriangle(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        when(triangleUtil.isEquilateral(anyDouble(), anyDouble(), anyDouble())).thenReturn(false);
        when(triangleUtil.isIsosceles(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        //then
        String actualMessage = triangleHelper.findTriangleTypeBySides("2", "2", "2");
        Assert.assertEquals(ISOSCELES_TRIANGLE_MESSAGE, actualMessage);
        verify(triangleUtil).validateSidesParsingToDouble("2", "2", "2");
        verify(triangleUtil, times(3)).convertSideToDouble(anyString());
        verify(triangleUtil).validateDoubleParameters(2.0, 2.0, 2.0);
        verify(triangleUtil).isTriangle(2.0, 2.0, 2.0);
        verify(triangleUtil).isEquilateral(2.0, 2.0, 2.0);
        verify(triangleUtil).isIsosceles(2.0, 2.0, 2.0);
    }

    @Test
    public void shouldReturnMessageTriangleScalene() {
        //when
        when(triangleUtil.validateSidesParsingToDouble(anyString(), anyString(), anyString())).thenReturn(true);
        when(triangleUtil.convertSideToDouble(anyString())).thenReturn(2.0);
        when(triangleUtil.validateDoubleParameters(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        when(triangleUtil.isTriangle(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        when(triangleUtil.isEquilateral(anyDouble(), anyDouble(), anyDouble())).thenReturn(false);
        when(triangleUtil.isIsosceles(anyDouble(), anyDouble(), anyDouble())).thenReturn(false);
        when(triangleUtil.isScalene(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        //then
        String actualMessage = triangleHelper.findTriangleTypeBySides("2", "2", "2");
        Assert.assertEquals(SCALENE_TRIANGLE_MESSAGE, actualMessage);
        verify(triangleUtil).validateSidesParsingToDouble("2", "2", "2");
        verify(triangleUtil, times(3)).convertSideToDouble(anyString());
        verify(triangleUtil).validateDoubleParameters(2.0, 2.0, 2.0);
        verify(triangleUtil).isTriangle(2.0, 2.0, 2.0);
        verify(triangleUtil).isEquilateral(2.0, 2.0, 2.0);
        verify(triangleUtil).isIsosceles(2.0, 2.0, 2.0);
        verify(triangleUtil).isScalene(2.0, 2.0, 2.0);
    }

    @Test
    public void shouldReturnMessageUnknownTriangle () {
        //when
        when(triangleUtil.validateSidesParsingToDouble(anyString(), anyString(), anyString())).thenReturn(true);
        when(triangleUtil.convertSideToDouble(anyString())).thenReturn(2.0);
        when(triangleUtil.validateDoubleParameters(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        when(triangleUtil.isTriangle(anyDouble(), anyDouble(), anyDouble())).thenReturn(true);
        when(triangleUtil.isEquilateral(anyDouble(), anyDouble(), anyDouble())).thenReturn(false);
        when(triangleUtil.isIsosceles(anyDouble(), anyDouble(), anyDouble())).thenReturn(false);
        when(triangleUtil.isScalene(anyDouble(), anyDouble(), anyDouble())).thenReturn(false);
        //then
        String actualMessage = triangleHelper.findTriangleTypeBySides("2", "2", "2");
        Assert.assertEquals(UNKNOWN_TRIANGLE_MESSAGE, actualMessage);
        verify(triangleUtil).validateSidesParsingToDouble("2", "2", "2");
        verify(triangleUtil, times(3)).convertSideToDouble(anyString());
        verify(triangleUtil).validateDoubleParameters(2.0, 2.0, 2.0);
        verify(triangleUtil).isTriangle(2.0, 2.0, 2.0);
        verify(triangleUtil).isEquilateral(2.0, 2.0, 2.0);
        verify(triangleUtil).isIsosceles(2.0, 2.0, 2.0);
        verify(triangleUtil).isScalene(2.0, 2.0, 2.0);
    }
}
