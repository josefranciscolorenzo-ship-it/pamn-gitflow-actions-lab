package es.ulpgc.pamn;

import java.util.ArrayList;
import java.util.List;

/** Modelo de dominio mínimo para practicar ramas y pruebas. */
public final class Planificador {
    private final List<String> tareas = new ArrayList<>();

    public void agregar(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        tareas.add(titulo.strip());
    }

    public List<String> listar() {
        return List.copyOf(tareas);
    }

    public static void main(String[] args) {
        var app = new Planificador();
        for (String titulo : args) app.agregar(titulo);
        for (String titulo : app.listar()) System.out.println("- " + titulo);
    }
}
