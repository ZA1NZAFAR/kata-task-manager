package net.efrei;


import org.javatuples.Pair;

public class TaskManager {

    public Pair<Character, String> parse(String input){
        return new Pair<>(input.charAt(0), input.substring(2));
    }

}