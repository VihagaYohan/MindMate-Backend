package com.codenova.mindmate_backend.dtos.responses;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuccessResponse<T> implements Serializable {
    private int status;
    private String message;
    private T data;
}
