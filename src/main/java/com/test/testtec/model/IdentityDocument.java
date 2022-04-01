package com.test.testtec.model;

import java.util.Date;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
@Getter
@Setter

public class IdentityDocument   {

    @Id
    private String id;

    @NotNull(message =  "El Numero no DEbe ser Nulo")
    @Pattern(regexp = "^[0-9]*", message ="Number No puede ser Alfanumerico")
    private String number;

    @NotNull(message =  "La Fecha deExpiracion no debe ser Nulo")
    @Pattern(regexp = "[0-1][0-9]/[2-9][0-9]", message ="Formato Esperado MM/YY")
    private String expiryDate;

    @NotNull(message =  "La Fecha de Emision no debe ser Nulo")
    @DateTimeFormat (pattern = "yyyy-MM-dd HH:mm:ss")
    private Date emissionDate;

    @NotNull(message =  "El Tipo de Documento no DEbe ser Nulo")
    private DocumentType documentType;

    
}
