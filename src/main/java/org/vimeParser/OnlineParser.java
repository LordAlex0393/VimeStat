package org.vimeParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.vimeClass.GlobalOnline;
import org.vimeClass.User;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class OnlineParser {
    public static GlobalOnline parseOnline(){
        GlobalOnline globalOnline;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            URL url = new URL("https://api.vimeworld.ru/online");
            globalOnline = objectMapper.readValue(url, GlobalOnline.class);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return globalOnline;
    }
    public static ArrayList<User> parseOnlineStaff() {
        ArrayList<User> staffList;
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            URL url = new URL("https://api.vimeworld.ru/online/staff");
            staffList = objectMapper.readValue(url, new TypeReference<ArrayList<User>>(){});
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return staffList;
    }

    public static String stringOnline(){
        int total = OnlineParser.parseOnline().getTotal();
        String result = String.format("%-12s %5d\n", "Total", total);
        HashMap<String, Integer> separatedMap = OnlineParser.parseOnline().getSeparated();

        for(String key : separatedMap.keySet()){
            result+= String.format("%-13s %4d\n", key, separatedMap.get(key));
        }
        return result;
    }
    public static String stringSortedOnline(){
        int total = OnlineParser.parseOnline().getTotal();
        String result = "TOTAL = " + total + "\n";
        HashMap<String, Integer> separatedMap = OnlineParser.parseOnline().getSeparated();

        HashMap<String, Integer>
                sortedMapDesc = separatedMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));

        for(String key : sortedMapDesc.keySet()){
            result+= String.format("%-13s %4d\n", key, separatedMap.get(key));
        }
        return result;
    }
    public static String stringClearSortedOnline(){
        String result = stringSortedOnline();
        String clear = "";
        for(String line : result.split("\n")){
            if(line.contains(" 0")){
                break;
            }
            clear+=line.toUpperCase() + "\n";
        }
        return clear;
    }
    public static String stringStaff(){
        String result = "";
        ArrayList<User> staffList = OnlineParser.parseOnlineStaff();
        for(User user : staffList){
            result+= user.getUsername() + "\n";
        }
        return result;
    }
}

