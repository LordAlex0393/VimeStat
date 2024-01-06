package org.vimeClass;

public enum Rank {
    PLAYER("Игрок", "", ""),
    VIP("VIP", "V", "#00be00"),
    PREMIUM("Premium", "P", "#00dada"),
    HOLY("Holy", "H", "#ffba2d"),
    IMMORTAL("Immortal",	"I", "#e800d5"),
    BUILDER("Билдер",	"Билдер", "#009c00"),
    MAPLEAD("Главный билдер", "Гл. билдер", "#009c00"),
    YOUTUBE("YouTube", "YouTube", "#fe3f3f"),
    DEV("Разработчик", "Dev", "#00bebe"),
    ORGANIZER("Организатор", "Организатор", "#00bebe"),
    MODER("Модератор", "Модер", "#1b00ff"),
    WARDEN("Проверенный модератор", "Модер", "#1b00ff"),
    CHIEF("Главный модератор", "Гл. модер",	"#1b00ff"),
    ADMIN("Главный админ", "Гл. админ", "#00bebe");

    private String name;
    private String prefix;
    private String color;

    Rank(String name, String prefix, String color) {
        this.name = name;
        this.prefix = prefix;
        this.color = color;
    }

    Rank() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
