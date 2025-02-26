package org.iti.app;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        double res = a * b;
        return res == -0.0 ? 0 : res;
    }

    public double div(double a, double b) {
        if (b == 0) throw new IllegalArgumentException("Dividing by Zero!");

        double res = a / b;
        return res == -0.0 ? 0.0 : res;
    }

    public double getSquareRoot(double a) {
        return Math.sqrt(a);
    }

    public long abs(long a) {
        return Math.abs(a);
    }
}
