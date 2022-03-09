package com.galvanize.tmo.paspringstarter.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class IncomingBookDto {
    @JsonProperty(required = true)
    @NotEmpty
    @NotBlank
    private String author;

    @JsonProperty(required = true)
    @NotEmpty
    @NotBlank
    private String title;

    @JsonProperty(required = true)
    @NotBlank
    @NotEmpty
    private int yearPublished;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
