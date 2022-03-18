package com.launchcode.gamersunite.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Post {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Please enter a name")
    private String gameName;

    @NotBlank(message = "Please enter a title")
    private String title;

    @NotBlank(message = "Please enter a description")
    @Lob
    private String description;

    private Snake snake;

    public Post() {
    }

    public Post(int id, String gameName, String title, String description) {

        this.id = id;
        this.gameName = gameName;
        this.title = title;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }


}
