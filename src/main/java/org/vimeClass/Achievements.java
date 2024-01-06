package org.vimeClass;

public class Achievements {
    private int id;
    private int time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Achievements{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}
