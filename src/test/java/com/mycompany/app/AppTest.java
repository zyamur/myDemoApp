package test.java.com.mycompany.app;

import main.java.com.mycompany.app.App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testComputeValidIndexes() {
        Integer[] arr1 = {1, 3};
        Integer[] arr2 = {2};
        String str1 = "Alone";
        String str2 = "Warrior";
        String expected = "lnr";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    void testComputeEmptyArrays() {
        Integer[] arr1 = {};
        Integer[] arr2 = {};
        String str1 = "Notso";
        String str2 = "much";
        String expected = "";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    void testComputeOutOfRange() {
        Integer[] arr1 = {6};
        Integer[] arr2 = {1, 3};
        String str1 = "Rick";
        String str2 = "Morty";
        String expected = "ot";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    void testComputeEmptyStrings() {
        Integer[] arr1 = {1, 2};
        Integer[] arr2 = {0};
        String str1 = "";
        String str2 = "";
        String expected = "";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    void testComputeNullStrings() {
        Integer[] arr1 = {1, 2};
        Integer[] arr2 = {0};
        String str1 = null;
        String str2 = null;
        String expected = "";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    void testComputeNullArrays() {
        Integer[] arr1 = null;
        Integer[] arr2 = null;
        String str1 = "Nobody";
        String str2 = "Knows";
        String expected = "";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }

    @Test
    void testComputeWithMixedValidAndInvalidIndices() {
        Integer[] arr1 = {1, 6};
        Integer[] arr2 = {0, 3};
        String str1 = "Me";
        String str2 = "LikeYou";
        String expected = "eLe";
        assertEquals(expected, App.compute(arr1, arr2, str1, str2));
    }
}
