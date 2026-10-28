# Estrategia de ramas del laboratorio

Este repositorio demuestra una adaptación de GitFlow a GitHub con pull requests.

| Rama | Responsabilidad | Integración |
| --- | --- | --- |
| `main` | Versión estable del ejemplo | Recibe releases y hotfixes |
| `develop` | Próxima versión | Recibe features y correcciones propagadas |
| `feature/*` | Una funcionalidad concreta | PR hacia `develop` |
| `release/*` | Estabilización de una entrega | PR hacia `main` y `develop` |
| `hotfix/*` | Corrección de la versión estable | PR hacia `main` y `develop` |

- Usar merge commits para conservar la estructura de las integraciones.
- Revisar el diff y la rama de destino antes de cada merge.
- Ejecutar `mvn -B -ntp verify` y comprobar `verificar-java`.
- Otra persona revisa las PR cuando se utiliza el ejemplo en equipo.
- Conservar releases y hotfixes hasta completar sus destinos de integración.
- Etiquetar la versión estable después del merge y de comprobar su CI.

Las protecciones técnicas dependen del plan y la visibilidad del repositorio.
Estas reglas documentan el acuerdo. Solo las reglas de protección configuradas
en GitHub pueden exigirlo técnicamente.
