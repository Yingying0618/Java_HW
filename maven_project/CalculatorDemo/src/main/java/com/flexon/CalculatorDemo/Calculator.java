package com.flexon.CalculatorDemo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Calculator
{
    public static void main(String[] args) {
        int x;
        int y;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        y= scanner.nextInt();
        sum(x,y);

    }
    public static Integer sum( Integer x, Integer y ) {

        if (x == null || y == null)
        return null;
        return x + y;

    }
}
