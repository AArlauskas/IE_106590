package com.lab2.greetingsapi.Models;

import lombok.Getter;

public class Greeting {
    @Getter
    private final long id;
    @Getter
    private final String content;

    public Greeting(long id, String content)
    {
        this.id = id;
        this.content = content;
    }
}
