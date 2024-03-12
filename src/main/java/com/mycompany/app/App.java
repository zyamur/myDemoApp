package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {


    //Our method going to get first strings i'th indexes which are represented in the first array
    //and same for the second one than concat the selected strings.
    public static String compute(ArrayList<Integer> arr1, ArrayList<Integer> arr2, String str1, String str2){
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
/*        Integer[] arr1 = {0, 2};
        Integer[] arr2 = {1, 3};
        String str1 = "Hello";
        String str2 = "World";

        String result = App.compute(arr1, arr2, str1, str2);
        System.out.println("Result: " + result);
*/

        port(getHerokuAssignedPort());

        get("/", (req, res) -> { return "Hello, World";});

        post("/compute", (req, res) -> {

            String input1 = req.queryParams("input1");
            java.util.Scanner arr1integers = new java.util.Scanner(input1);
            arr1integers.useDelimiter("[;\r\n,]+");
            java.util.ArrayList<Integer> arr1List = new java.util.ArrayList<>();

            while (arr1integers.hasNext())
            {
                int value = Integer.parseInt(arr1integers.next().replaceAll("\\s",""));
                arr1List.add(value);
            }
            System.out.println(arr1List);



            String input2 = req.queryParams("input2");
            java.util.Scanner arr2integers = new java.util.Scanner(input2);
            arr2integers.useDelimiter("[;\r\n,]+");
            java.util.ArrayList<Integer> arr2List = new java.util.ArrayList<>();

            while (arr2integers.hasNext())
            {
                int value = Integer.parseInt(arr2integers.next().replaceAll("\\s",""));
                arr2List.add(value);
            }
            System.out.println(arr2List);



            String input3 = req.queryParams("input3").replaceAll("\\s","");
            String str1 = input3;
            System.out.println(str1);

            String input4 = req.queryParams("input4").replaceAll("\\s","");
            String str2 = input4;
            System.out.println(str2);

            String result = App.compute(arr1List,arr2List,str1,str2);
            System.out.println(result);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");


        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}