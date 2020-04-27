package com.demkom58.nmlab5.interpolation;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;

import java.util.function.DoubleUnaryOperator;

public class QuadraticInterpolation implements Interpolation {

    @Override
    public String calculate(double x, double a, double b, int n, DoubleUnaryOperator function) throws Exception {
        validate(x, a, b, n);
        var points = arrayPoints(a, b, n, function);

        var spline = new SplineInterpolator();
        var splineFunc = spline.interpolate(points.getKey(), points.getValue());

        if (!splineFunc.isValidPoint(x))
            throw new IllegalArgumentException("Вказана помилкова точка");

        final double result = splineFunc.value(x);
        return "Результат: " + result;
    }

}
