package org.zenware;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Producto {

        public Long id;
        @NotBlank(message = "El nombre no debe estar vacío ")
        public String nombre;

        @Min(value = 0, message = "El precio debe ser mayor que 0")
        public double precio;


    public Producto() {
    }

    public double getPrecio() {
        return precio;
    }

    public Producto(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio=precio;
    }


    public Producto aplicarImpuesto(double porcentaje){
        if(porcentaje>50){
            throw new IllegalArgumentException("Porcentaje superior al 50%");
        }
        this.precio = Math.round(this.precio * (1 + porcentaje / 100.0));
        return this;
    }
}