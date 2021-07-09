package com.accenture.javatests.FizzBuzz;

public class FizzBuzz {
    public static String fizzBuzz(int i) {
        String result = "";
        boolean divisible = false;
        if(i % 3 == 0){
            result += "Fizz";
            divisible = true;
        }
        if(i % 5 == 0){
            result += "Buzz";
            divisible = true;
        }
        return divisible ? result: ""+i ;
    }

}
