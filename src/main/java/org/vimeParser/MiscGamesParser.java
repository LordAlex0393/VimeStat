package org.vimeParser;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.vimeClass.MiniGame;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MiscGamesParser {
    public static ArrayList<MiniGame> getGameList() {
        ArrayList<MiniGame> gameList = new ArrayList<>();
        try {
            URL url = new URL("https://api.vimeworld.ru/misc/games");
            JSONParser parser = new JSONParser();
            JSONArray GameListJsonArray = (JSONArray) parser.parse(new InputStreamReader(url.openStream()));
            for(Object it : GameListJsonArray){
                JSONObject mg = (JSONObject) it;
                String id = (String) mg.get("id");
                String name = (String) mg.get("name");
                gameList.add(new MiniGame(id, name));
            }

            return gameList;
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

    public static HashMap<String, String> getGameMap(){
        MiscGamesParser miscGamesParser = new MiscGamesParser();
        ArrayList<MiniGame> gameList = (ArrayList<MiniGame>) miscGamesParser.getGameList();
        HashMap<String, String> gameMap = new HashMap<>();
        for(MiniGame mg : gameList){
            gameMap.put(mg.getId(), mg.getName());
        }
        return gameMap;
    }
    public String toString(){
        MiscGamesParser miscGamesParser = new MiscGamesParser();
        ArrayList<MiniGame> gameList = (ArrayList<MiniGame>) miscGamesParser.getGameList();
        String result = "";
        for(MiniGame mg : gameList){
            result+= mg.getName() + '\n';
        }
        return result;
    }
}
