package org.vimeParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class OnlineParser {
    public static GlobalOnline parse(){
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

    public String toSortedString(){
        int total = OnlineParser.parse().getTotal();
        String result = "TOTAL = " + total + "\n";
        HashMap<String, Integer> separatedMap = OnlineParser.parse().getSeparated();

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


    public String toString(){
        int total = OnlineParser.parse().getTotal();
        String result = String.format("%-12s %5d\n", "Total", total);
        HashMap<String, Integer> separatedMap = OnlineParser.parse().getSeparated();

        for(String key : separatedMap.keySet()){
            result+= String.format("%-13s %4d\n", key, separatedMap.get(key));
        }
        return result;
    }
}

