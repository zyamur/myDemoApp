package main.java.com.mycompany.app;

public class App {


    //Our method going to get first strings i'th indexes which are represented in the first array
    //and same for the second one than concat the selected strings.
    public static String compute(Integer[] arr1, Integer[] arr2, String str1, String str2){
        StringBuilder result = new StringBuilder();

        if (arr1 == null || arr2 == null || str1 == null || str2 == null) {
            return "";
        }

        //Gets the wanted string parts from arr1
        for (int index : arr1) {
            if (index >= 0 && index < str1.length() ) {
                result.append(str1.charAt(index));
            }
        }

        //Gets the wanted string parts from arr2
        for (int index : arr2) {
            if (index >= 0 && index < str2.length() ) {
                result.append(str2.charAt(index));
            }
        }

        return result.toString();

    }
    public static void main(String[] args) {
        Integer[] arr1 = {0, 2};
        Integer[] arr2 = {1, 3};
        String str1 = "Hello";
        String str2 = "World";

        String result = App.compute(arr1, arr2, str1, str2);
        System.out.println("Result: " + result);
    }
}