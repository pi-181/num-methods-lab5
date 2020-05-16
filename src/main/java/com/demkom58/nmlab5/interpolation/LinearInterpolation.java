package com.demkom58.nmlab5.interpolation;

import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;

import java.util.function.DoubleUnaryOperator;

public class LinearInterpolation implements Interpolation {

    @Override
    public String calculate(double x, double a, double b, int n, DoubleUnaryOperator function) throws Exception {
        validate(x, a, b, n);

        var points = arrayPoints(a, b, n, function);
        var interpolator = new LinearInterpolator();
        var func = interpolator.interpolate(points.getKey(), points.getValue());

        var calculated = func.value(x);
        return "Результат: " + calculated + "\n" +
                "Похибка: " + (calculated - function.applyAsDouble(x));
    }

}
