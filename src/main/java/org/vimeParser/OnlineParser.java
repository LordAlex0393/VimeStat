package org.vimeParser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.vimeClass.MiniGame;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class OnlineParser {
    public static int total;
    public static List separated;

    public static HashMap<String, Integer> getSeparatedOnline() {
        HashMap<String, Integer> separatedMap = new HashMap<>();
        try {
            URL url = new URL("https://api.vimeworld.ru/online?separated");

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map
                    = objectMapper.readValue(url.openStream(), new TypeReference<Map<String,Object>>(){});
            separatedMap = (HashMap<String, Integer>) map.get("separated");

            return separatedMap;
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getTotalOnline() {
        try {
            URL url = new URL("https://api.vimeworld.ru/online");
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(new InputStreamReader(url.openStream()));
            total = (int) (long) json.get("total");
            return total;
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String toSortedString(){
        int total = OnlineParser.getTotalOnline();
        //String result = String.format("%-12s %5d\n", "TOTAL", total);
        String result = "TOTAL = " + total + "\n";
        HashMap<String, Integer> separatedMap = OnlineParser.getSeparatedOnline();

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
        int total = OnlineParser.getTotalOnline();
        String result = String.format("%-12s %5d\n", "Total", total);
        HashMap<String, Integer> separatedMap = OnlineParser.getSeparatedOnline();

        for(String key : separatedMap.keySet()){
            result+= String.format("%-13s %4d\n", key, separatedMap.get(key));
        }
        return result;
    }
}

