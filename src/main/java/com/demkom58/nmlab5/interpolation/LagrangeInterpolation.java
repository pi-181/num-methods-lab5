package com.demkom58.nmlab5.interpolation;

import java.util.function.DoubleUnaryOperator;

public class LagrangeInterpolation implements Interpolation {

    @Override
    public String calculate(double x, double a, double b, int n, DoubleUnaryOperator function) throws Exception {
        validate(x, a, b, n);

        var points = arrayPoints(a, b, n, function);
        var xs = points.getKey();
        var ys = points.getValue();

        var product = 1D;
        var sum = 0D;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    product *= (x - xs[j]) / (xs[i] - xs[j]);
                }
            }
            sum += product * ys[i];
            product = 1;
        }

        return "Результат: " + sum + "\n" +
                "Похибка: " + (sum - function.applyAsDouble(x));
    }

}
