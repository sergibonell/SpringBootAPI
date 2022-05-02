package com.example.exercicilombok.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuariConsultaDTO {
    private String username;
    //private String avatar;
    private String rol;
}
