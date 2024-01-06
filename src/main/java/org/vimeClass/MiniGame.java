package org.vimeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MiniGame {
    private String id;
    private String name;
    private ArrayList<String> global_stats;
    private HashMap<String, ArrayList<String>> season_stats;

    public MiniGame(String id, String name, ArrayList<String> global_stats, HashMap<String, ArrayList<String>> season_stats) {
        this.id = id;
        this.name = name;
        this.global_stats = global_stats;
        this.season_stats = season_stats;
    }

    public MiniGame(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public MiniGame() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getGlobal_stats() {
        return global_stats;
    }

    public void setGlobal_stats(ArrayList<String> global_stats) {
        this.global_stats = global_stats;
    }

    public HashMap<String, ArrayList<String>> getSeason_stats() {
        return season_stats;
    }

    public void setSeason_stats(HashMap<String, ArrayList<String>> season_stats) {
        this.season_stats = season_stats;
    }

    @Override
    public String toString() {
        return "MiniGame{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", global_stats=" + global_stats +
                ", season_stats=" + season_stats +
                '}';
    }
}
