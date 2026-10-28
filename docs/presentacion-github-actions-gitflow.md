---
marp: true
theme: default
size: 16:9
paginate: true
lang: es
title: GitHub Actions y GitFlow
description: Presentación de prácticas para 4.º de Ingeniería Informática, ULPGC
footer: PAMN · ULPGC
style: |
  section {
    font-family: Arial, sans-serif;
    font-size: 28px;
    color: #17324d;
    background: #ffffff;
    padding: 56px 64px;
    justify-content: flex-start;
  }
  h1 { font-size: 48px; color: #14324a; margin-bottom: 28px; }
  h2 { font-size: 42px; color: #14324a; margin-bottom: 26px; }
  strong, a { color: #007e87; }
  pre { font-size: 23px; line-height: 1.25; background: #edf4f7; }
  code { font-family: Consolas, monospace; }
  table { font-size: 25px; }
  th { background: #14324a; color: white; }
  footer { font-size: 16px; color: #607486; }
---

# GitHub Actions y GitFlow

## Colaboración y automatización en el proyecto

4.º del Grado en Ingeniería Informática

Universidad de Las Palmas de Gran Canaria

PAMN · Prácticas · 28 de octubre de 2026

<!-- Notas: Material complementario. Las instrucciones del profesorado prevalecen. La presentación acompaña a la guía detallada y a proyecto-ejemplo.zip. -->

---

## Objetivos de la práctica

- Elegir la rama adecuada para cada cambio.
- Revisar e integrar mediante pull requests.
- Interpretar las comprobaciones de GitHub Actions.
- Preparar una release y propagar un hotfix.
- Justificar la estrategia de ramas del equipo.

**Resultado:** un repositorio con reglas de colaboración y CI.

<!-- Notas: El alumnado ya ha recibido una introducción a Actions. Dedicar más tiempo a las ramas y a las decisiones del proyecto. -->

---

## Git, GitHub, GitFlow y Actions

| Elemento | Función |
| --- | --- |
| Git | Registrar cambios y gestionar ramas |
| GitHub | Alojar el repositorio y revisar propuestas |
| GitFlow | Acordar cómo organizar las ramas |
| GitHub Actions | Ejecutar tareas automáticas |

**La estrategia de ramas y las pruebas se complementan.**

<!-- Fuente: https://docs.github.com/en/actions/get-started/understand-github-actions -->

---

## CI y CD

**Integración continua (CI)**

Compilar y probar los cambios con frecuencia.

**Entrega continua**

Mantener el software preparado para publicar, con posible aprobación manual.

**Despliegue continuo**

Publicar automáticamente los cambios que superan el proceso.

<!-- Notas: El laboratorio implementa CI. Un merge o un tag no despliegan por sí solos. Fuente docente: https://mltechdrawer.github.io/PAMN/Bloque1_Ingenieria_Apps/ciclo_vida_arquitectura/github_actions/ -->

---

## Las ramas de GitFlow

| Rama | Origen | Integración o función |
| --- | --- | --- |
| main | Inicialización | Versiones estables |
| develop | main al comenzar | Próxima release |
| feature/* | develop | develop |
| release/* | develop | main y develop |
| hotfix/* | main | main y develop |

Los prefijos expresan un acuerdo. Son ramas normales de Git.

<!-- Notas: main corresponde a master en el modelo original. Los prefijos con barra son la convención del laboratorio. Fuente: https://nvie.com/posts/a-successful-git-branching-model/ -->

---

## main y develop

**main: línea estable**

Conserva las versiones preparadas para publicar.
Las etiquetas identifican versiones concretas.

**develop: línea de integración**

Reúne las funcionalidades de la siguiente entrega.
Puede avanzar mientras una release se estabiliza.

<!-- Fuente: https://nvie.com/posts/a-successful-git-branching-model/ -->

---

## Una funcionalidad en su propia rama

1. Partir de `develop` actualizado.
2. Crear `feature/contar-tareas`.
3. Añadir el cambio y sus pruebas.
4. Abrir una PR con destino `develop`.
5. Integrar después de CI y revisión.

**Una rama por tarea y cambios pequeños facilitan la revisión.**

<!-- Notas: Publicamos las features para colaborar con PR. Es una adaptación del modelo clásico al trabajo en GitHub. -->

---

## Release y hotfix

| | release/* | hotfix/* |
| --- | --- | --- |
| Punto de partida | develop | main |
| Motivo | Preparar una entrega | Corregir la versión estable |
| Cambios habituales | Ajustes y correcciones | Corrección concreta |
| Cierre | main y develop | main y develop |

**La corrección debe llegar también al desarrollo futuro.**

<!-- Notas: Si hay una release abierta al crear el hotfix, hay que llevar la corrección a esa release antes de publicarla. Su cierre la propagará a develop. Fuente: https://nvie.com/posts/a-successful-git-branching-model/ -->

---

## Una estrategia según el proyecto

| Contexto | Alternativa a valorar |
| --- | --- |
| Entregas versionadas y estabilización separada | GitFlow |
| Equipo pequeño y una versión activa | GitHub Flow |
| Integración frecuente y cambios muy pequeños | Desarrollo basado en trunk |

**Actividad:** justificar qué coste de coordinación acepta el equipo.

<!-- Notas: GitFlow no es obligatorio para todos los proyectos. El propio autor recomienda modelos más simples para entrega continua. Fuentes: https://nvie.com/posts/a-successful-git-branching-model/ y https://docs.github.com/en/get-started/using-github/github-flow -->

---

## Acuerdo de ramificación del equipo

El archivo `docs/estrategia-ramas.md` debe responder:

- ¿Qué representa cada rama permanente?
- ¿De dónde sale cada cambio y dónde se integra?
- ¿Quién revisa y qué pruebas deben pasar?
- ¿Cómo publicamos y propagamos correcciones?
- ¿Cuándo revisaremos este acuerdo?

**Debate en equipo: 10 minutos.**

<!-- Notas: Es una propuesta de actividad, no una entrega oficial de la asignatura. Cada equipo debe acordar también nombres y duración orientativa de las ramas. -->

---

## Aplicación del laboratorio

**Planificador de tareas en Java 17**

- Aplicación de consola con datos en memoria.
- Maven para construir y JUnit para probar.
- Siete pruebas iniciales.
- Una feature añadirá el contador de tareas.

Material: `proyecto-ejemplo.zip`, entregado junto a la guía.

<!-- Notas: Se reutiliza el ejemplo ya entregado. Es una aplicación JVM para centrar la práctica en Git y CI. La última ejecución local terminó con siete pruebas correctas. -->

---

## Primera ejecución local

Desde la carpeta que contiene `pom.xml`:

```sh
java -version
mvn -version
mvn -B -ntp verify
```

Ejecutar la aplicación:

```sh
java -cp target/classes es.ulpgc.pamn.Planificador "Estudiar Git"
```

**Esperado:** siete pruebas correctas y una tarea en consola.

<!-- Notas: Se necesita JDK 17 o superior y Maven 3.9. La primera compilación puede descargar dependencias. JAVA_HOME debe apuntar al JDK. Cada ejecución de la aplicación comienza con una lista vacía. -->

---

## Repositorio local y remoto

```sh
git init -b main
git add .
git commit -m "chore: crear aplicación y CI inicial"
git remote add origin URL-DEL-REPOSITORIO
git push -u origin main
git switch -c develop
git push -u origin develop
```

Crear antes un repositorio **vacío** en GitHub.
Sustituir `URL-DEL-REPOSITORIO` por su URL real.

<!-- Notas: Ejecutar desde proyecto-ejemplo. Si hace falta, configurar user.name y user.email antes del primer commit. En GitHub no añadir README ni .gitignore al crear el repositorio. Autenticarse con el gestor de credenciales o un cliente configurado. Nunca guardar tokens en el repositorio. -->

---

## Protección de las ramas permanentes

En `main` y `develop`:

- Exigir pull request y revisión de otra persona.
- Exigir el check `verificar-java`.
- Mantener la rama actualizada antes de integrar.
- Evitar force pushes y el borrado de estas ramas.

El laboratorio utiliza **merge commits**.
Una regla de historial lineal impediría estos merges.

<!-- Notas: Configurar protección o rulesets después de la primera ejecución para poder seleccionar el check. Las opciones dependen del plan y la visibilidad. Si no están disponibles, documentar la limitación y revisar manualmente. Revisar los permisos de bypass. Fuente: https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/about-protected-branches -->

---

## Componentes de un workflow

| Componente | En el ejemplo |
| --- | --- |
| Archivo | .github/workflows/ci.yml |
| Evento | push o pull_request |
| Job | verificar |
| Runner | ubuntu-latest |
| Steps | Obtener código, preparar Java, ejecutar Maven |

Cada job ejecuta sus pasos en un entorno de ejecución.

<!-- Notas: Los jobs pueden ejecutarse en paralelo. needs establece dependencias. Los pasos de un job comparten entorno, los jobs no comparten automáticamente el disco. Fuente: https://docs.github.com/en/actions/get-started/understand-github-actions -->

---

## Workflow: eventos y permisos

```yaml
name: CI Java
on:
  push:
    branches: [main, develop, 'feature/**', 'release/**', 'hotfix/**']
  pull_request:
    branches: [main, develop, 'release/**']
  workflow_dispatch:
permissions:
  contents: read
```

En `pull_request`, el filtro se aplica a la rama **de destino**.

<!-- Notas: Es la primera parte del archivo completo entregado. workflow_dispatch habilita la ejecución manual cuando el archivo está en la rama predeterminada. No hay filtros de tags en este workflow. Fuente: https://docs.github.com/en/actions/reference/workflows-and-actions/workflow-syntax -->

---

## Workflow: job y preparación de Java

```yaml
jobs:
  verificar:
    name: verificar-java
    runs-on: ubuntu-latest
    timeout-minutes: 10
    steps:
      - name: Obtener el código
        uses: actions/checkout@v7
        with:
          persist-credentials: false
      - name: Preparar Java 17
        uses: actions/setup-java@v6
        with:
          distribution: temurin
          java-version: '17'
          cache: maven
```

<!-- Notas: Segunda parte del mismo archivo. checkout obtiene el código y setup-java prepara el JDK. La versión de la acción y la del lenguaje son distintas. Fuentes: https://github.com/actions/checkout y https://github.com/actions/setup-java -->

---

## Workflow: construcción y pruebas

Último step, dentro de la misma lista `steps`:

```yaml
      - name: Compilar y ejecutar pruebas
        run: mvn -B -ntp verify
```

- `verify` incluye las fases anteriores, pruebas y empaquetado.
- `-B` evita la interacción y `-ntp` reduce los mensajes.
- Un fallo en las pruebas hace fallar este paso.

El workflow completo está en el proyecto de ejemplo.

<!-- Notas: No hace falta ejecutar mvn test después de mvn verify. Los tres fragmentos de las diapositivas anteriores forman un único archivo YAML. -->

---

## Eventos que observarán en Actions

| Acción | Resultado esperado |
| --- | --- |
| Push a una feature sin PR | CI del push |
| Abrir PR hacia develop | CI de la PR |
| Nuevo push con PR abierta | CI del push y de la PR |
| Merge en develop | CI del push en develop |
| Publicar el tag v1.0.0 | Ninguna ejecución con este YAML |

La duplicación de push y PR es deliberada en el laboratorio.

<!-- Fuente: https://docs.github.com/en/actions/reference/workflows-and-actions/workflow-syntax -->

---

## Feature: contador de tareas

```sh
git switch develop
git pull --ff-only origin develop
git switch -c feature/contar-tareas
```

Añadir `public int contar()` y dos pruebas:

- Devuelve cero con la lista vacía.
- Devuelve dos después de agregar dos tareas.

Ejecutar `mvn -B -ntp verify` antes del commit.

<!-- Notas: Se esperan nueve pruebas tras añadir las dos propuestas. El método puede devolver el tamaño de la lista sin exponer el estado interno. -->

---

## Pull request de la feature

```sh
git add src
git commit -m "feat: contar las tareas"
git push -u origin feature/contar-tareas
```

En GitHub, seleccionar:

- **Base:** `develop`.
- **Compare:** `feature/contar-tareas`.

Describir el cambio, indicar las pruebas y pedir revisión.

<!-- Notas: base recibe los cambios y compare los aporta. El check puede pasar incluso si el destino es incorrecto. El YAML de CI no impone todo el acuerdo de ramificación. -->

---

## Una regresión que CI puede detectar

1. Cambiar temporalmente `contar()` para devolver siempre cero.
2. Hacer commit y push a la misma feature.
3. Observar el fallo de la prueba con dos tareas.
4. Corregir el método y enviar otro commit.
5. Comprobar que la PR vuelve a tener el check verde.

**Evidencia:** enlace a la ejecución fallida y a la corregida.

<!-- Notas: Realizar el experimento antes de integrar la PR. Mantener las pruebas y sus resultados esperados. Un check verde solo garantiza las comprobaciones configuradas. -->

---

## Revisión e integración

La persona revisora comprueba:

- La rama de destino y el alcance del cambio.
- El comportamiento y los casos de prueba.
- El diff, los archivos generados y las credenciales.

Con aprobación y CI correcta: **Create a merge commit**.

Después: actualizar `develop` y eliminar la feature integrada.

<!-- Notas: Usar git switch develop y git pull --ff-only origin develop. Después, git branch -d feature/contar-tareas y git fetch --prune. No activar borrado automático para releases o hotfixes que todavía tengan otro destino pendiente. -->

---

## Conflictos durante una integración

Desde una feature que sigue abierta:

```sh
git fetch origin
git merge origin/develop
```

1. Localizar los archivos con `git status`.
2. Resolver el contenido y retirar los marcadores de conflicto.
3. Hacer `git add`, confirmar el merge y repetir las pruebas.
4. Enviar el resultado con `git push`.

Para cancelar el merge pendiente: `git merge --abort`.

<!-- Notas: La guía detallada incluye el ejemplo completo. --ff-only en pull evita merges inesperados. Si falla, inspeccionar el historial antes de elegir una solución. -->

---

## Release 1.0.0: preparación

```sh
git switch develop
git pull --ff-only origin develop
git switch -c release/1.0.0
```

- Cambiar la versión del proyecto en el POM a `1.0.0`.
- Añadir las notas en `CHANGELOG.md`.
- Ejecutar las pruebas, confirmar y publicar la rama.
- Abrir PR de `release/1.0.0` hacia `main`.

Durante la estabilización, reservar las nuevas features para otra entrega.

<!-- Notas: git add pom.xml CHANGELOG.md; git commit -m "chore: preparar versión 1.0.0"; git push -u origin release/1.0.0. Revisar e integrar mediante merge commit. -->

---

## Release 1.0.0: etiqueta y propagación

Tras integrar la release en `main` y comprobar su CI:

```sh
git switch main
git pull --ff-only origin main
git log -1 --oneline
git tag -a v1.0.0 -m "Versión 1.0.0"
git push origin v1.0.0
```

Abrir otra PR de `release/1.0.0` hacia **develop**.
Eliminar la release cuando termine esa segunda integración.

<!-- Notas: Confirmar que HEAD es el merge esperado antes de etiquetar. Un tag identifica un commit, GitHub Release añade notas y un despliegue ejecuta otro proceso. Para continuar, se puede subir a 1.1.0-SNAPSHOT en develop mediante otra PR. -->

---

## Hotfix 1.0.1

**Incidencia del ejercicio:** rechazar títulos duplicados tras eliminar espacios exteriores, con comparación sensible a mayúsculas.

```sh
git switch main
git pull --ff-only origin main
git switch -c hotfix/1.0.1
```

Añadir una prueba de regresión, corregir `agregar()` y actualizar la versión y el changelog.

Abrir PR hacia **main** y después hacia **develop**.

Tras el merge y CI en `main`, crear la etiqueta `v1.0.1`.
Con una release abierta, integrar también allí el hotfix.

<!-- Notas: La segunda llamada con " Estudiar " después de "Estudiar" debe lanzar IllegalArgumentException. Tras el merge y CI en main, crear v1.0.1 como en la release anterior. Conservar la versión de desarrollo si surge un conflicto en el POM. Si hay una release abierta, llevar allí la corrección antes de publicarla. -->

---

## Diagnóstico de una ejecución fallida

En **Actions**, abrir la ejecución y el paso que falla.

| Síntoma | Primera comprobación |
| --- | --- |
| No aparece ejecución | Ruta del YAML, evento y filtros |
| Check pendiente | Nombre exigido y cobertura de esa PR |
| Falla una prueba | Nombre, esperado y obtenido |
| Solo falla en el runner | JDK, rutas y archivos versionados |

Comprobar también la rama y el commit de la ejecución.

<!-- Notas: Si falla la preparación de Java o la descarga, todavía no se han ejecutado las pruebas. Revisar restricciones de Actions en la organización y acceso a dependencias. -->

---

## Adaptación a la aplicación móvil

Con Gradle Wrapper, las tareas podrían ser:

```sh
./gradlew testDebugUnitTest lintDebug assembleDebug
```

- Comprobar las tareas de sus módulos y variantes.
- Elegir un JDK compatible con Gradle y Android Gradle Plugin.
- Preparar el SDK y distinguir pruebas unitarias e instrumentadas.
- Mantener claves de firma y tokens fuera del historial.

<!-- Notas: En Windows, usar gradlew.bat. Este comando es orientativo y no un workflow universal de Android. La aplicación JVM del ejemplo no comprueba recursos, emuladores ni firma. Los secretos necesarios se configuran en GitHub, con permisos mínimos. -->

---

## Evidencias para discutir en clase

- Acuerdo de ramas y comparación con otra estrategia.
- PR de feature con revisión de otro integrante.
- Ejecución fallida y corrección comprobada por CI.
- Release etiquetada y cambios propagados a `develop`.
- Hotfix con prueba de regresión e integraciones completas.

**Pregunta final:** ¿qué simplificarían ustedes en su proyecto y por qué?

<!-- Notas: Propuesta de autoevaluación, sin carácter de rúbrica oficial. Preguntar también a qué rama afecta pull_request.branches y por qué CI no valida todo el acuerdo de colaboración. -->

---

## Referencias y material de práctica

- [Documentación de PAMN facilitada por la coordinadora](https://mltechdrawer.github.io/PAMN/Bloque1_Ingenieria_Apps/ciclo_vida_arquitectura/github_actions/)
- [GitHub Actions: conceptos](https://docs.github.com/en/actions/get-started/understand-github-actions) y [sintaxis de workflows](https://docs.github.com/en/actions/reference/workflows-and-actions/workflow-syntax)
- [GitFlow: modelo original y reflexión del autor](https://nvie.com/posts/a-successful-git-branching-model/)
- [GitHub Flow](https://docs.github.com/en/get-started/using-github/github-flow) y [protección de ramas](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/about-protected-branches)
- [actions/checkout](https://github.com/actions/checkout) y [actions/setup-java](https://github.com/actions/setup-java)

Guía ampliada y aplicación: materiales entregados junto a esta presentación.

<!-- Notas: Fuentes consultadas el 28/10/2026 para preparar la guía. Versiones mayores de acciones por legibilidad. En un proyecto real, fijar SHA completos revisados y planificar actualizaciones. No cambiar a pull_request_target para ejecutar código de PR no confiables con permisos elevados. -->
