package com.java.planning.book.entity.entityHelper;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage implements Serializable {
    private Integer status;
    private Date time;
    private HttpStatus error;
    private String description;
}
