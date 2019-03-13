# Wypożyczalnia Filmów

Wypożyczalnia filmów na projekt z projektowania aplikacji internetowych 2

## Wykorzystano

* Java 8
* Oracle Database 12c
* Spring Boot 2.1.1
* JPA
* Oauth2
* Lombok 
* Angular
* Bootstrap

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

## Token

Użytkownik
```
my-trusted-client
```

Hasło
```
secret
```

## API

Pobieranie tokena - POST
```
/oauth/token?grant_type=password&username=xxx&password=xxx
```

Usuwanie tokena - GET
```
/logouts?access_token=xxx
```

Pobieranie nazwy aktualnie zalogowanego użytkownika - GET
```
/getUsername
```

Rejestracja użytkownika - POST
```
/register
```
```
{
	"userName": "xxx",
	"password": "xxx",
	"passwordConfirmation": "xxx",
	"email":"xxx@xxx"  
}
```

Pobieranie wszystkich filmów - GET
```
/getAllMovie
```

## Inne informacje

* Podczas startu serwera dodają się dwaj użytkownicy: user:user, admin:admin (tymczasowo)
* Podczas startu serwera dodają się dwa filmy (tymczasowo)

