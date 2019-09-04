package com.sviryd.mikhail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PermutationTest {
    private Permutation permutation;

    @Before
    public void init() {
        permutation = new Permutation();
    }

    @Test
    public void test_1_1_2_7() {
        int[] a = {1, 1, 2, 7};
        boolean canBeEqualTo24 = permutation.canBeEqualTo24(a);
        Assert.assertTrue(canBeEqualTo24);
    }

    @Test
    public void test_3_3_8_8() {
        int[] a = {3, 3, 8, 8};
        boolean canBeEqualTo24 = permutation.canBeEqualTo24(a);
        Assert.assertTrue(canBeEqualTo24);
    }

    @Test
    public void test_5_2_4_3() {
        int[] a = {5, 2, 4, 3};
        boolean canBeEqualTo24 = permutation.canBeEqualTo24(a);
        Assert.assertTrue(canBeEqualTo24);
    }

    @Test
    public void test_34_3_76_6() {
        int[] a = {34, 3, 76, 6};
        boolean canBeEqualTo24 = permutation.canBeEqualTo24(a);
        Assert.assertTrue(canBeEqualTo24);
    }

    @Test
    public void test_54_24_2_9() {
        int[] a = {54, 24, 2, 9};
        boolean canBeEqualTo24 = permutation.canBeEqualTo24(a);
        Assert.assertTrue(canBeEqualTo24);
    }

    @Test
    public void test_1_1_1_4_Fail() {
        int[] a = {1, 1, 1, 4};
        boolean canBeEqualTo24 = permutation.canBeEqualTo24(a);
        Assert.assertFalse(canBeEqualTo24);
    }

    @Test
    public void test_1_1_7_7_Fail() {
        int[] a = {1, 1, 7, 7};
        boolean canBeEqualTo24 = permutation.canBeEqualTo24(a);
        Assert.assertFalse(canBeEqualTo24);
    }

    @Test
    public void test_1_3_5_5_Fail() {
        int[] a = {1, 3, 5, 5};
        boolean canBeEqualTo24 = permutation.canBeEqualTo24(a);
        Assert.assertFalse(canBeEqualTo24);
    }
}