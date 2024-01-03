package org.vimeClass;

public class User {
    private int id;
    private String username;
    private int level;
    private float levelPercentage;
    private String rank;
    private int playedSeconds;
    private int lastSeen;
    private Guild guild;
    private Online online;

    public User(int id, String username, int level, float levelPercentage, String rank, int playedSeconds, int lastSeen, Guild guild, Online online) {
        this.id = id;
        this.username = username;
        this.level = level;
        this.levelPercentage = levelPercentage;
        this.rank = rank;
        this.playedSeconds = playedSeconds;
        this.lastSeen = lastSeen;
        this.guild = guild;
        this.online = online;
    }
    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getLevelPercentage() {
        return levelPercentage;
    }

    public void setLevelPercentage(float levelPercentage) {
        this.levelPercentage = levelPercentage;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getPlayedSeconds() {
        return playedSeconds;
    }

    public void setPlayedSeconds(int playedSeconds) {
        this.playedSeconds = playedSeconds;
    }

    public int getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(int lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    public Online getOnline() {
        return online;
    }

    public void setOnline(Online online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", level=" + level +
                ", levelPercentage=" + levelPercentage +
                ", rank='" + rank + '\'' +
                ", playedSeconds=" + playedSeconds +
                ", lastSeen=" + lastSeen +
                ", guild=" + guild +
                ", online=" + online +
                '}';
    }
}
