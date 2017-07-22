package com.tornado.swagger.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class Greeting {

	private final long id;
	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of the user", required = true)
    private final String content;
 
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
 
    public long getId() {
        return id;
    }
 
    
    public String getContent() {
        return content;
    }
}
