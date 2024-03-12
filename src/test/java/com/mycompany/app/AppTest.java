package com.mycompany.app;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testComputeValidIndexes() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(3);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        String str1 = "Alone";
        String str2 = "Warrior";
        String expected = "lnr";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    public void testComputeEmptyArrays() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        String str1 = "Notso";
        String str2 = "much";
        String expected = "";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    public void testComputeOutOfRange() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(6);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(3);
        String str1 = "Rick";
        String str2 = "Morty";
        String expected = "ot";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    public void testComputeEmptyStrings() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(0);
        String str1 = "";
        String str2 = "";
        String expected = "";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    public void testComputeNullStrings() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(4);
        arr1.add(3);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(0);
        String str1 = null;
        String str2 = null;
        String expected = "";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    public void testComputeNullArrays() {
        ArrayList<Integer> arr1 = null;
        ArrayList<Integer> arr2 = null;
        String str1 = "Nobody";
        String str2 = "Knows";
        String expected = "";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    public void testComputeMixedValidAndInvalidIndices() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(6);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(0);
        arr2.add(3);
        String str1 = "Me";
        String str2 = "LikeYou";
        String expected = "eLe";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }
}
