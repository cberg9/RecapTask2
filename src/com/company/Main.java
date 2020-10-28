package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    static void countWords(String userInput){
        Map<String,Integer> my = new HashMap<>();// storing the frequency of elements
        String[] array = userInput.split(" ");


        for (int i = 0; i < array.length; i++) {
            //see if the Map contains the elements
            if (my.containsKey(array[i])){ //if the word occurence more than one time
                my.put(array[i],my.get(array[i])+1);//replace value to +1
            }
            //else set value to 1
            else {
                my.put(array[i],1);
            }
        }
        //sorting from highest to lowest and then collect the result in a linkedHashMap
        Map<String, Integer> result = my.entrySet().stream().sorted(Map.Entry.comparingByValue((a, b) -> b - a)).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (String word: result.keySet()) {
            System.out.println(word +" -> " + result.get(word));

        }

        }

    public static void main(String[] args) {
	String userInput = "She sells sea shells on the sea shore";
	countWords(userInput);

    }
}
