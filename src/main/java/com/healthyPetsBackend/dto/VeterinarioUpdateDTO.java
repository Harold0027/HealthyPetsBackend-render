package com.healthyPetsBackend.dto;

import lombok.Data;

@Data
public class VeterinarioUpdateDTO {
    private String nombre;
    private String especialidad;
    private String correo;
    private String telefono;
    private String direccion;
    private String informacion;
    private String imagenUrl;
}
