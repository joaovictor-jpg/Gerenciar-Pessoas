package com.github.joaovictorjpg.menage_person.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class StandardError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp;
    private Integer status;
    private String error;
    private List<String> messagens = new ArrayList<>();
    private String path;

    public StandardError(Instant timestamp, Integer status, String error, String messagens, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.messagens = Arrays.asList(messagens);
        this.path = path;
    }

    public StandardError(Instant timestamp, Integer status, String error, List<String> messagens, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.messagens = messagens;
        this.path = path;
    }

}
