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

# Konfiguracja

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

# API

## Użytkownicy

* Rejestracja
* Robieranie tokena
* Sprwadzanie nazwy użytkownika (dla kogo został wygenerowany token)
* Wylogowanie (usunięcie tokena)
* Przypisywanie ról użytkownika

### Wszyscy

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

Pobieranie tokena - POST
```
/oauth/token?grant_type=password&username=xxx&password=xxx
```

Sprwadzanie nazwy użytkownika - GET
```
/getUsername
```

### Zalogowany użytkownik

Wylogowanie - GET
```
/logouts?access_token=xxx
```

### Admin

Przypisywanie ról użytkownikowi - POST
```
/admin/user/setRole
```
```
{
	"userName":"xxx",
	"roles":[
		{
			"name": "xxx"
		},
		{
			"name": "xxx"
		}
	]
}

### ROLE - Admin


```

## Gatunki Filmów

* Wyświetlanie gatunków
* Dodawanie gatunków
* Usuwanie gatunków

### Wszyscy

Pobieranie listy gatunków filmowych - GET
```
/movie/type
```

### Admin

Dodadanie gatunku filmu - POST
```
/admin/movie/type/add
```
```
{
	"name":"xxx"
}
```

Usuwanie gatunku filmu - POST
```
/admin/movie/type/delete
```
```
{
	"name":"xxx"
}
```

## Filmy

* Wyświetlanie wszystkich filmów 
* Wyświetlanie posortowanych filmów //TODO
* Dodawanie filmu
* Edycja filmu
* Usuwanie filmu //TODO

### Wszyscy

Pobieranie wszystkich filmów - GET
```
/getAllMovie
```

### Admin

Dodawanie filmu - POST
```
/admin/movie/add
```
```
{
	"title":"Nowy film",
	"types":[
			{
				"name": "Dramat"
			},
			{
				"name": "Komedia"
			}
		],
	"director":"xxx",
	"productionYear":"2019-04-03",
	"description":""
}
```

Edycja filmu - POST
```
/admin/movie/edit
```
```
{
	"title":"Nowy film",
	"newTitle":"Nowy film1",
	"types":[
			{
				"name": "Dramat"
			},
			{
				"name": "Komedia"
			}
		],
	"director":"xxx",
	"productionYear":"2019-04-03",
	"description":""
}
```

## Wypożyczenia

* Wyświetlanie top5 wypożyczeń //TODO
* Wypożyczenie filmu przez użytkownika //TODO
* Sprawdzanie wypożyczeń przez użytkownika //TODO
* Przeglądanie wypożyczeń użytkowników przez administratora //TODO
* Edycja (np przedłużenie czasu zwrotu) wypożyczeń użytkowników przez administratora //TODO
* Usuwanie (zwrot) wypożyczeń użytkowników przez administratora //TODO

# Pozostałe informacje

* Podczas startu serwera dodają się przykładowe dane(użytkownicy, gatunki filmów, filmy, wypożeczenia)
* Dane do konta administratora:<br />
Login: admin<br />
Hasło: admin
