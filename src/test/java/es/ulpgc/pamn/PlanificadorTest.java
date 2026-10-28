package es.ulpgc.pamn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanificadorTest {
    @Test void empiezaVacio() {
        assertTrue(new Planificador().listar().isEmpty());
    }
    @Test void agregaEnOrden() {
        var app = new Planificador();
        app.agregar("Diseñar");
        app.agregar("Probar");
        assertEquals(java.util.List.of("Diseñar", "Probar"), app.listar());
    }
    @Test void eliminaEspaciosExteriores() {
        var app = new Planificador();
        app.agregar("  Estudiar  ");
        assertEquals("Estudiar", app.listar().get(0));
    }
    @Test void rechazaNulo() {
        assertThrows(IllegalArgumentException.class,
            () -> new Planificador().agregar(null));
    }
    @Test void rechazaVacio() {
        assertThrows(IllegalArgumentException.class,
            () -> new Planificador().agregar(""));
    }
    @Test void rechazaSoloEspacios() {
        assertThrows(IllegalArgumentException.class,
            () -> new Planificador().agregar(" \t "));
    }
    @Test void protegeLaListaInterna() {
        var app = new Planificador();
        app.agregar("Revisar PR");
        assertThrows(UnsupportedOperationException.class,
            () -> app.listar().add("Intrusión"));
        assertEquals(1, app.listar().size());
    }
}
