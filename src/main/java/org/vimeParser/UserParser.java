package org.vimeParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.vimeClass.Achievements;
import org.vimeClass.GlobalOnline;
import org.vimeClass.User;
import org.vimeClass.UserAchievements;

import java.net.URL;
import java.util.ArrayList;

public class UserParser {
    public static ArrayList<User> parseNames(String names){
        ArrayList<User> userList;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            URL url = new URL("https://api.vimeworld.ru/user/name/" + names);
            userList = objectMapper.readValue(url, new TypeReference<ArrayList<User>>(){});
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public static ArrayList<User> parseIDs(String ids){
        ArrayList<User> userList;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            URL url = new URL("https://api.vimeworld.ru/user/" + ids);
            userList = objectMapper.readValue(url, new TypeReference<ArrayList<User>>(){});
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static UserAchievements parseAchievements(int id){
        UserAchievements userAchievements;
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try{
            URL url = new URL("https://api.vimeworld.ru/user/1249617/achievements");
            userAchievements = objectMapper.readValue(url, UserAchievements.class);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userAchievements;
    }

    public static ArrayList<Achievements> getAchievements(int id){
        UserAchievements userAchievements;
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try{
            URL url = new URL("https://api.vimeworld.ru/user/1249617/achievements");
            userAchievements = objectMapper.readValue(url, UserAchievements.class);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userAchievements.getAchievements();
    }

}
