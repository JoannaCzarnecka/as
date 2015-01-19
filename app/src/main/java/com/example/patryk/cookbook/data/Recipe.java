package com.example.patryk.cookbook.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe implements Serializable {

    public String title;
    public String introduction;
    public String ingredients;
    public String steps;
    public String created;
    public String preparationMinutes;
    public String cookingMinutes;
    public String servings;
    public Integer ownerId;
    public Integer id;

    @JsonProperty("session_id")
    public String sessionId;
}

