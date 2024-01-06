package org.example;

import org.vimeParser.MiscGamesParser;
import org.vimeParser.OnlineParser;
import org.vimeParser.UserParser;


public class Main {
    public static void main(String[] args) {
        MiscGamesParser miscGamesParser = new MiscGamesParser();
        OnlineParser onlineParser = new OnlineParser();
        //System.out.println(OnlineParser.stringStaff());
        //System.out.println(UserParser.parseNames("xtrafrancyz,_Lord_Alex_").toString());
        //System.out.println(UserParser.parseNames("_Lord_Alex_").get(0).getRank().getPrefix());
        System.out.println(UserParser.parseAchievements(1).getAchievements().toString());
    }
}