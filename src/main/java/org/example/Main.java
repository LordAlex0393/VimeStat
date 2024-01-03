package org.example;

import org.vimeClass.MiniGame;
import org.vimeParser.MiscGamesParser;
import org.vimeParser.OnlineParser;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        OnlineParser onlineParser = new OnlineParser();
        //MiscGamesParser miscGamesParser = new MiscGamesParser();
        //System.out.println(OnlineParser.getSeparatedOnline());
        //System.out.println(MiscGamesParser.getGameList().toString());
        System.out.println(onlineParser.toSortedString());



    }
}