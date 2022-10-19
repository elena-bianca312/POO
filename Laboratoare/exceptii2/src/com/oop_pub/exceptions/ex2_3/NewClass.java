package com.oop_pub.exceptions.ex2_3;

import java.util.Collection;

public class NewClass implements Calculator{

    @Override
    public Double add(Double nr1, Double nr2) {
        try {
            if(nr1 == null || nr2 == null) {
                throw new NullPointerException();
            }
            if(nr1 + nr2 == Double.POSITIVE_INFINITY) {
                throw new OverflowException();
            }
            if(nr1 + nr2 == Double.NEGATIVE_INFINITY) {
                throw new UnderflowException();
            }
            return nr1 + nr2;
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");
            e.printStackTrace();
        } catch (OverflowException e) {
            System.out.println("Overflow exception");
            e.printStackTrace();
        } catch (UnderflowException e) {
            System.out.println("Underflow exception");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Double divide(Double nr1, Double nr2) {
        try {
            if(nr1 == null || nr2 == null) {
                throw new NullPointerException();
            }
            if(nr2 == 0) {
                throw new ArithmeticException();
            }
            return nr1 / nr2;
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Can't be divided by zero");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Double average(Collection<Double> numbers) {

        Double sum = (double) 0;
        for(Double x : numbers) {
            sum = add(sum, x);
        }
        return divide(sum, (double) numbers.size());
    }
}
