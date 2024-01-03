package org.vimeClass;

import java.util.List;

public class MiniGame {
    private String id;
    private String name;
    private List global_stats;
    private List season_stats;

    public MiniGame(String id, String name, List global_stats, List season_stats) {
        this.id = id;
        this.name = name;
        this.global_stats = global_stats;
        this.season_stats = season_stats;
    }
    public MiniGame(String id, String name) {
        this.id = id;
        this.name = name;
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

    public void setGlobal_stats(List global_stats) {
        this.global_stats = global_stats;
    }

    public List getSeason_stats() {
        return season_stats;
    }

    public void setSeason_stats(List season_stats) {
        this.season_stats = season_stats;
    }

    @Override
    public String toString() {
        return "MiniGame{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", global_stats=" + global_stats +
                ", season_stats=" + season_stats +
                '}';
    }
}
