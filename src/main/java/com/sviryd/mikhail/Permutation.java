package com.sviryd.mikhail;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BinaryOperator;

/**
 * Assignment:
 * 1. make code within an only one method
 * 2. signature of method below
 */
public class Permutation {
    /**
     * Memory-saving version
     * We can make this method more readable if we start to store permutation of elements and permutation of
     * operations separately from existing multiple for loop, but it will cost extra memory.
     *
     * @param nums array composed of 4 integer
     * @return boolean {@code true} if there exists combination of calculation(*,/,+,-) where the amount is 24
     */
    public boolean canBeEqualTo24(final int[] nums) {
        int nE = 4;
        if (nums == null) {
            throw new IllegalArgumentException("The array cannot be null.");
        }
        if (nums.length != nE) {
            throw new IllegalArgumentException("A length of array must be " + nE + " not " + nums.length);
        }
        double[] buffer = {nums[0], nums[1], nums[2], nums[3]};
        double expected = 24;
        int nO = nE - 1;
        int nOs = 4;
        BinaryOperator<Double>[] operations = new BinaryOperator[nOs];
        operations[0] = (x, y) -> x * y;
        operations[1] = (x, y) -> x / y;
        operations[2] = (x, y) -> x + y;
        operations[3] = (x, y) -> x - y;
        int[][] permPrecedence = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {2, 0, 1}, {1, 2, 0}, {2, 1, 0}};
        for (int i = 0; i < nE; i++) { // permutation (without repeating) of elements
            for (int j = 0; j < nE; j++) {
                if (j == i) continue;
                for (int k = 0; k < nE; k++) {
                    if (k == i || k == j) continue;
                    for (int h = 0; h < nE; h++) {
                        if (h == k || h == j || h == i) continue;
                        for (int m = 0; m < nOs; m++) { // permutation (with repeating) of operations
                            for (int n = 0; n < nOs; n++) {
                                for (int r = 0; r < nOs; r++) {
                                    for (int p[] : permPrecedence) { // permutation (without repeating) of precedence
                                        double actual = 0;
                                        double zero = buffer[i];
                                        double one = buffer[j];
                                        double two = buffer[k];
                                        double last = buffer[h];
                                        try {
                                            int first = p[0];
                                            for (int q = 0; q < nO; q++) {
                                                switch (p[q]) {
                                                    case 0:
                                                        zero = operations[m].apply(zero, one);
                                                        one = zero;
                                                        actual = zero;
                                                        if (first == 1) {
                                                            two = zero;
                                                        }
                                                        break;
                                                    case 1:
                                                        one = operations[n].apply(one, two);
                                                        two = one;
                                                        actual = one;
                                                        break;
                                                    case 2:
                                                        two = operations[r].apply(two, last);
                                                        actual = two;
                                                        if (first == 1) {
                                                            one = two;
                                                        }
                                                        break;
                                                }
                                            }
                                            actual = new BigDecimal(actual).setScale(10, RoundingMode.CEILING).doubleValue();
                                            if (expected == actual) {
                                                return true;
                                            }
                                        } catch (Exception e) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
