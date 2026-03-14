# IUM_TWEB_BE_DataPos

Server dati secondario per l'applicazione calcistica del progetto universitario **IUM/TWEB**. È un'applicazione **Spring Boot** che espone una REST API versioned (`/v1/rest/`) su **PostgreSQL**, fungendo da sorgente dati principale per il [MainServer (Node.js)](../IUM_TWEB_BE_MainServer).

## Descrizione

Questo server gestisce i dati strutturati e relazionali del dominio calcistico: giocatori, club, competizioni, formazioni, partite per club e storico delle valutazioni di mercato. Comunica esclusivamente con PostgreSQL tramite **Spring Data JPA / Hibernate**, ed è il backend che il MainServer interroga internamente sulla porta `8989`.

## Stack tecnologico

- **Linguaggio:** Java 17
- **Framework:** Spring Boot 3.2.3
- **Persistenza:** Spring Data JPA + Hibernate (dialetto PostgreSQL)
- **Database:** PostgreSQL
- **Build tool:** Gradle
- **Documentazione API:** SpringDoc OpenAPI 2 (Swagger UI)

## Architettura interna

Il progetto segue una classica architettura a strati Spring:

```
Controller  →  Service (interfaccia + impl)  →  Repository (JpaRepository)  →  PostgreSQL
```

Ogni entità ha la propria eccezione custom (`*NotFoundException`) per gestire i 404 in modo pulito.

## Struttura del progetto

```
src/main/java/com/ium/tweb/footballprojpostgres/
├── FootballprojpostgresApplication.java   # Entry point Spring Boot
├── controller/                            # REST controller per ogni entità
│   ├── PlayerController.java
│   ├── ClubController.java
│   ├── CompetitionController.java
│   ├── PlayerValuationController.java
│   ├── ClubGameController.java
│   └── GameLineUpController.java
├── data/
│   ├── model/                             # Entità JPA mappate su tabelle PostgreSQL
│   │   ├── Player.java
│   │   ├── Club.java
│   │   ├── Competition.java
│   │   ├── PlayerValuation.java           # Chiave primaria composita (player_id + date)
│   │   ├── ClubGame.java                  # Chiave primaria composita (game_id + club_id)
│   │   └── GameLineUp.java
│   └── output/
│       └── PlayerValuationDTO.java        # DTO per le query JPQL di join multi-entità
├── repository/                            # Interfacce Spring Data JPA
├── service/                               # Interfacce dei servizi
├── service/impl/                          # Implementazioni dei servizi
└── exception/                             # Eccezioni custom per ogni entità
```

## API Endpoints

Il server è in ascolto sulla porta **`8989`**. Tutti gli endpoint paginati accettano `pageSize` (default: 25) e `pageNumber` (default: 0).

### Giocatori — `/v1/rest/player`

| Metodo | Path | Descrizione |
|---|---|---|
| GET | `/` | Tutti i giocatori (max 100) |
| GET | `/page` | Giocatori paginati |
| GET | `/{id}` | Giocatore per ID |
| GET | `/club/{clubId}` | Giocatori per club attuale |
| GET | `/search/name?name=` | Ricerca per nome (parziale, case-insensitive) |
| GET | `/search/name/position?name=&position=` | Ricerca per nome e ruolo |
| GET | `/search/playerIds?playerIds=&position=` | Ricerca per lista di ID e ruolo |
| POST | `/` | Crea giocatore |
| PUT | `/{id}` | Aggiorna giocatore |
| DELETE | `/{id}` | Elimina giocatore |

### Club — `/v1/rest/clubs`

| Metodo | Path | Descrizione |
|---|---|---|
| GET | `/` | Tutti i club |
| GET | `/page` | Club paginati |
| GET | `/{clubId}` | Club per ID |
| GET | `/competition/{competitionId}` | Club per competizione domestica |
| GET | `/search/name?name=` | Ricerca per nome (parziale) |
| GET | `/search/clubIds?clubIds=` | Ricerca per lista di ID |
| POST | `/` | Crea club |
| PUT | `/{clubId}` | Aggiorna club |
| DELETE | `/{clubId}` | Elimina club |

### Valutazioni di mercato — `/v1/rest/playerValuations`

La chiave primaria è composita: `(player_id, date)`.

| Metodo | Path | Descrizione |
|---|---|---|
| GET | `/` | Tutte le valutazioni |
| GET | `/page` | Valutazioni paginate |
| GET | `/player/{playerId}` | Storico valutazioni per giocatore |
| GET | `/player/{playerId}/date/{date}` | Valutazione specifica per giocatore e data |
| GET | `/club/{clubId}` | Valutazioni per club |
| GET | `/info/player/{playerId}?startDate=&endDate=` | Valutazioni con info giocatore e club (join JPQL) |
| GET | `/info/club/{clubId}` | Valutazioni con info giocatore e club per clubId |
| GET | `/info/top/page?startDate=&endDate=` | Top giocatori per valore di mercato in un periodo |
| POST | `/` | Crea valutazione |
| PUT | `/player/{playerId}/date/{date}` | Aggiorna valutazione |
| DELETE | `/player/{playerId}/date/{date}` | Elimina valutazione |

### Competizioni — `/v1/rest/competitions`

| Metodo | Path | Descrizione |
|---|---|---|
| GET | `/` | Tutte le competizioni |
| GET | `/page` | Competizioni paginate |
| GET | `/{competitionId}` | Competizione per ID |
| GET | `/type/{type}` | Competizioni per tipo |
| POST | `/` | Crea competizione |
| PUT | `/{competitionId}` | Aggiorna competizione |
| DELETE | `/{competitionId}` | Elimina competizione |

### Altre risorse

- **Partite per club:** `/v1/rest/clubGames` — CRUD + paginazione, chiave composita `(game_id, club_id)`
- **Formazioni:** `/v1/rest/gameLineUps` — CRUD + paginazione

## Documentazione Swagger

Una volta avviato, la documentazione interattiva è disponibile a:

```
http://localhost:8989/swagger-ui.html
```

Il file OpenAPI JSON è disponibile a:

```
http://localhost:8989/api-docs
```

## Configurazione

Il file di configurazione principale è `src/main/resources/application.properties`:

```properties
server.port=8989

spring.datasource.url=jdbc:postgresql://<host>:<port>/<database>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
```

Per il container PostgreSQL Docker già in esecuzione sulla porta `5432`, la configurazione sarà:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/IUMTWEB
spring.datasource.username=pguser
spring.datasource.password=<password>
```

## Installazione e avvio

### Prerequisiti

- Java 17
- PostgreSQL in esecuzione (es. Docker su `localhost:5432`) con il database `IUMTWEB` già popolato

### Build e avvio

```bash
# Build
./gradlew build

# Avvio
./gradlew bootRun
```

Oppure esegui direttamente il JAR generato:

```bash
java -jar build/libs/footballprojpostgres-0.0.1-SNAPSHOT.jar
```

Il server sarà in ascolto su `http://localhost:8989`.

## Note

- Le query JPQL più complesse (join su `PlayerValuation`, `Player` e `Club`) restituiscono `List<Object[]>` mappati poi nel `PlayerValuationDTO` a livello di service.
- `spring.jpa.show-sql=true` è attivo di default: in produzione è consigliabile disabilitarlo.
- Il server non gestisce autenticazione: si assume che sia raggiungibile solo internamente dal MainServer.