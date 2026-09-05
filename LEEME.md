# AppFutbol

Versión propia del proyecto que el profesor lleva en clase (originalmente
"apprickmorty", una app de Rick and Morty). Aquí el tema es **fútbol**: en vez
de personajes se consultan **equipos de fútbol**.

## Qué se cambió respecto al repo del profesor

| Antes (profe) | Ahora (tú) |
|---|---|
| Paquete `com.danidev.apprickmorty` | `com.johnmoraleslo.appfutbol` |
| `rootProject.name = "apprickmorty"` | `"appfutbol"` |
| App name `apprickmorty` | `AppFutbol` |
| Tema `Theme.Apprickmorty` / `ApprickmortyTheme` | `Theme.AppFutbol` / `AppFutbolTheme` |
| API `https://rickandmortyapi.com/api` | `https://www.thesportsdb.com/api/v1/json/3/` (gratis, sin API key) |
| `data/model/Character.kt` (`CharacterResponse`, `RickCharacter`, `Origin`) | `data/model/Team.kt` (`TeamResponse`, `FootballTeam`) |
| `data/remote/RickAndMortyApi.kt` (`RickAndMortyApi`) | `data/remote/FootballApi.kt` (`FootballApi`) |
| `data/repository/CharacterRepository.kt` | `data/repository/TeamRepository.kt` |

La estructura de carpetas y el punto de avance son los mismos que los del
profesor: `MainActivity` sigue siendo la plantilla por defecto ("Hello Android")
y falta construir el ViewModel, las pantallas de Compose y la navegación. A
partir de aquí sigues tú con tu propia app.

Nota: el repo original del profe tenía errores que impedían compilar (imports
de Retrofit faltantes en la API, un typo `getCgaracters`, y sintaxis inválida
en el repositorio). Aquí esos archivos quedaron **escritos correctamente** para
que el proyecto compile; cuando el profe los complete en clase, compara y ajusta.

## API usada (TheSportsDB)

- Listar equipos de una liga: `search_all_teams.php?l=Spanish La Liga`
- Buscar equipo por id: `lookupteam.php?id=133739`
- La API key `3` es la de pruebas pública, no requiere registro.

## Abrir en Android Studio

1. Android Studio → **Open** → selecciona la carpeta `appfutbol`.
2. Deja que sincronice Gradle (descarga dependencias la primera vez).
3. `local.properties` se genera solo con la ruta de tu SDK.
4. Ejecuta en un emulador o dispositivo.
