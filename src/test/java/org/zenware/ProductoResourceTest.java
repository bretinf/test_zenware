package org.zenware;

import jakarta.ws.rs.NotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ProductoResourceTest {

    @Test
    public void testAddProducto() {
        ProductoResource resource = new ProductoResource();
        Producto producto = new Producto();
        producto.id = 1L;
        producto.precio = 60.0;

        Collection<Producto> productos = resource.add(producto);
        assertTrue(productos.contains(producto));
        assertEquals(1, productos.size());
    }

        @Test
        public void testDeleteProductoNotFound() {
            ProductoResource resource = new ProductoResource();
            Producto producto = new Producto();
            producto.id = 2L;
            NotFoundException exception = assertThrows(NotFoundException.class, () -> resource.delete(producto));
            assertEquals(404, exception.getResponse().getStatus());
            assertEquals("No encontrado", exception.getResponse().getEntity());

        }

}