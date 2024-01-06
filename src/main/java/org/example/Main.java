package org.example;

import org.vimeParser.MiscGamesParser;
import org.vimeParser.OnlineParser;

public class Main {
    public static void main(String[] args) {
        OnlineParser onlineParser = new OnlineParser();
        MiscGamesParser miscGamesParser = new MiscGamesParser();
        //System.out.println(OnlineParser.getSeparatedOnline());
        System.out.println(miscGamesParser.toString());

        //System.out.println(onlineParser.toSortedString());



    }
}