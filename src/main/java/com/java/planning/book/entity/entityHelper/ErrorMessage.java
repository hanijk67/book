package com.java.planning.book.entity.entityHelper;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;


public class ErrorMessage implements Serializable {
    private Integer status;
    private Date time;
    private HttpStatus error;
    private String description;

    public ErrorMessage() {
    }

    public ErrorMessage(Integer status, Date time, HttpStatus error, String description) {
        this.status = status;
        this.time = time;
        this.error = error;
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public HttpStatus getError() {
        return error;
    }

    public void setError(HttpStatus error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
