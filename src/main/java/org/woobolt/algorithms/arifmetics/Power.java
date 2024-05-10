package org.woobolt.algorithms.arifmetics;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.stream.Stream;

public class Power {
    public static void main(String[] args) {

        Instant startRecursive = Instant.now();
        System.out.println(recursivePower(3, 50));
        Instant endRecursive = Instant.now();

        Instant start = Instant.now();
        System.out.println(power(3, 50));
        Instant end = Instant.now();

        System.out.println("recursive duration: " + Duration.between(startRecursive, endRecursive).toNanos());
        System.out.println("duration: " + Duration.between(start, end).toNanos());

        // power works faster than recursivePower
    }

    public static double recursivePower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent % 2 == 0) {
//            System.out.println("Half powered");
            double result = recursivePower(base, exponent / 2);
            return result * result;
        } else {
//            System.out.println("Linear powered");
            double result = recursivePower(base, (exponent - 1) / 2);
            return base * result * result;
        }
    }

    public static int power(int base, int exponent) {
        int result = 1;
        while (exponent > 0) {
            if (exponent % 2 != 0) {
                result *= base;
            }
            base *= base;
            exponent /= 2;
        }
        return result;
    }
}
