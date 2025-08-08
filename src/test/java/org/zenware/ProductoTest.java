package org.zenware;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ProductoTest {

    @Test
    void aplicarImpuestoOk() {
        Producto producto1 = new Producto(1L,"Producto 1",100);

        producto1.aplicarImpuesto(10);
        assertThat(producto1.getPrecio()).isEqualTo(110);

        producto1.aplicarImpuesto(50);
        assertThat(producto1.getPrecio()).isEqualTo(165);
    }

    @Test
    void aplicarImpuestoWithException() {
        Producto producto2 = new Producto(1L,"Producto 2",100);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> producto2.aplicarImpuesto(60));
        assertThat(exception.getMessage()).isEqualTo("Porcentaje superior al 50%");
    }
}