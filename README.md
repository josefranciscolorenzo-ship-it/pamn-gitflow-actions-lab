# Laboratorio de GitFlow y GitHub Actions

Ejemplo para 4.º del Grado en Ingeniería Informática de la ULPGC, en PAMN.
Aplicación de consola en Java 17, Maven 3.9 y JUnit 5.

## Material de clase

- [Presentación en PDF](docs/presentacion-github-actions-gitflow.pdf).
- [Presentación Markdown editable con Marp](docs/presentacion-github-actions-gitflow.md).
- [Guía detallada en PDF](docs/guia-github-actions-gitflow.pdf).
- [Guía Markdown](docs/guia-github-actions-gitflow.md).
- [Acuerdo de ramificación](docs/estrategia-ramas.md).

## Ejecutar

Desde la carpeta del repositorio, donde está `pom.xml`:

```sh
java -version
mvn -version
mvn -B -ntp verify
java -cp target/classes es.ulpgc.pamn.Planificador "Estudiar GitFlow" "Revisar PR"
```

El JDK debe ser 17 o superior. La primera compilación descarga dependencias.
La aplicación conserva las tareas en memoria, sin persistencia.

## Ramas del ejemplo

- `main`: base funcional con siete pruebas.
- `develop`: rama de integración de la próxima versión.
- `feature/contar-tareas`: añade el contador y dos pruebas, propuesta por PR hacia `develop`.

La solución de la feature sirve al profesor para demostrar la revisión y CI.
Para que el alumnado la implemente por su cuenta, debe partir de `develop`
antes de integrar esa PR y usar una rama propia.

## GitHub Actions

[CI Java](.github/workflows/ci.yml) ejecuta `mvn -B -ntp verify` en un runner
Ubuntu con Temurin 17. El check se llama `verificar-java`.
Se activa con pushes a las ramas acordadas y PR hacia `main`, `develop` o `release/**`.
Una feature con PR abierta puede producir dos ejecuciones, una por cada evento.
También admite ejecución manual desde la pestaña Actions.

El workflow no despliega ni publica versiones. Los tags no lo disparan.
Las acciones usan referencias por versión mayor para facilitar la lectura.
En un proyecto real, conviene fijar SHA completos revisados y actualizarlos.

## Demostración de fallo y corrección

La PR de `feature/contar-tareas` permitirá observar una implementación
incorrecta que devuelve siempre cero y el commit que la corrige.
Las pruebas deben mantenerse: el resultado esperado para dos tareas es dos.
Los enlaces y el estado de las ejecuciones se documentarán en la PR.

## Continuación de la práctica

1. Revisar la PR y comprobar la diferencia entre `base` y `compare`.
2. Esperar CI y revisión y seleccionar **Create a merge commit**.
3. Preparar `release/1.0.0`, ajustar POM y changelog e integrar en ambos destinos.
4. Etiquetar `v1.0.0` en la versión estable tras comprobar CI.
5. Practicar un hotfix y propagarlo para evitar perder la corrección.

Los comandos completos y ejercicios están en la guía.
Material complementario, sin carácter de normativa oficial de la asignatura.
