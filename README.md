# Wypożyczalnia Filmów

Wypożyczalnia filmów na projekt z projektowania aplikacji internetowych 2

## Wykorzystane 

* Java 8
* Oracle Database 12c
* Spring Boot 2.1.1
* JPA
* Oauth2
* Lombok 
* *Coś do frontu (?)*

## Baza danych

Nazwa
```
MovieRental
```

Użytkownik
```
system
```

Hasło
```
MovieRental1
```

## Autoryzacja tokena

Użytkownik
```
my-trusted-client
```

Hasło
```
secret
```

## API

Pobieranie tokena
```
/oauth/token?grant_type=password&username=xxx&password=xxx
```

Usuwanie tokena
```
/logouts?access_token=xxx
```

Pobieranie nazwy aktualnie zalogowanego użytownika
```
/getUsername
```

## Inne informacje

* Podczas startu serwera dodają się dwaj użytkownicy: user:user, admin:admin (tymczasowo)

