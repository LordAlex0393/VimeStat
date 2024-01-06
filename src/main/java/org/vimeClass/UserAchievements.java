package org.vimeClass;

import java.util.ArrayList;

public class UserAchievements{
    User user;
    ArrayList<Achievements> achievements;

    public UserAchievements(User user, ArrayList<Achievements> achievements) {
        this.user = user;
        this.achievements = achievements;
    }
    public UserAchievements() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Achievements> getAchievements() {
        return achievements;
    }

    public void setAchievementsList(ArrayList<Achievements> achievements) {
        this.achievements = achievements;
    }
}
