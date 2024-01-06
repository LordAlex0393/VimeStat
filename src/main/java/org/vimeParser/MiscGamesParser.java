package org.vimeParser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.vimeClass.MiniGame;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MiscGamesParser {
    public static ArrayList<MiniGame> getMiscGames() {
        ArrayList<MiniGame> gameList;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            URL url = new URL("https://api.vimeworld.ru/misc/games");
            gameList = objectMapper.readValue(url, new TypeReference<ArrayList<MiniGame>>(){});
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return gameList;
    }

    public static HashMap<String, String> getGameMap(){
        MiscGamesParser miscGamesParser = new MiscGamesParser();
        ArrayList<MiniGame> gameList = (ArrayList<MiniGame>) miscGamesParser.getMiscGames();
        HashMap<String, String> gameMap = new HashMap<>();
        for(MiniGame mg : gameList){
            gameMap.put(mg.getId(), mg.getName());
        }
        return gameMap;
    }
    public String toString(){
        String result = "";
        ArrayList<MiniGame> gameList = MiscGamesParser.getMiscGames();
        for(MiniGame game : gameList){
            result+=game.getName() + "\n";
        }
        return result;
    }
}
