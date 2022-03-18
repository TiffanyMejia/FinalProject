package com.launchcode.gamersunite.models;


public enum Snake {
    ACTION("Action", "Action"),
    ADVENTURE("Adventure", "Adventure"),
    FPS("First Person Shooters", "Shooters"),
    MMORPG("Massively Multiplayer Online Role Play Game", "RPG"),
    PARTY("Party", "Puzzle"),
    PUZZLE("Puzzle", "Puzzle"),
    REAL_TIME_STRATEGY("Real-time strategy", "RTS"),
    ROLE_PLAYING("Role PLaying", "RPG"),
    SCIFI("SciFi", "Sci-Fi"),
    SIMULATION("Simulation", "Simulation"),
    TPS("Third Person Shooters", "Shooters");


    String name;
    String category;


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    Snake(String name, String category){
            this.name = name;
            this.category = category;
    }
}
