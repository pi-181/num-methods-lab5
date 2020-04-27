package com.demkom58.nmlab5.interpolation;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

import java.util.function.DoubleUnaryOperator;

public class LagrangeInterpolation implements Interpolation {

    @Override
    public String calculate(double x, double a, double b, int n, DoubleUnaryOperator function) throws Exception {
        validate(x, a, b, n);

        var points = arrayPoints(a, b, n, function);
        var form = new PolynomialFunctionLagrangeForm(points.getKey(), points.getValue());
        var result = form.value(x);

        return "Результат: " + result;
    }

}
