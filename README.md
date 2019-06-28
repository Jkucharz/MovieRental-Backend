# Wypożyczalnia Filmów

Wypożyczalnia filmów na projekt z projektowania aplikacji internetowych 2

## Wykorzystano

* Java 8
* Oracle Database 12c
* Spring Boot 2.1.1
* JPA
* Oauth2
* Lombok

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
* Pobieranie tokena
* Sprwadzanie nazwy użytkownika (dla kogo został wygenerowany token)
* Sprawdzanie czy użytkownik jest administratorem
* Wylogowanie (usunięcie tokena)
* Przypisywanie ról użytkownika

### Wszyscy

Rejestracja użytkownika - POST
```
/register
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

Sprwadzanie czy użytkownik jest administratorem - POST
```
/checkUserAdmin
{
	"name":"userName"
}
```

### Zalogowany użytkownik

Wylogowanie - GET
```
/logouts?access_token=xxx
```

### Admin
Pobieranie listy użytkowników wraz z rolami- GET
```
/admin/users
```

Przypisywanie ról użytkownikowi - POST
```
/admin/user/setRole
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
{
	"name":"xxx"
}
```

Usuwanie gatunku filmu - POST
```
/admin/movie/type/delete
{
	"name":"xxx"
}
```

## Filmy

* Wyświetlanie wszystkich filmów 
* Wyświetlanie posortowanych filmów //TODO
* Dodawanie filmu
* Usuwanie filmu
* Edycja filmu
* Dodawanie oceny filmu

### Wszyscy

Pobieranie wszystkich filmów - GET
```
/getAllMovie
```

### Admin

Dodawanie filmu - POST
```
/admin/movie/add
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

Usuwanie filmu - POST
```
/admin/movie/remove
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

Dodawanie oceny filmu - POST
```
/movie/rate
{
	"title":"Zielona mila",
	"rate":3
}
```

## Wypożyczenia

* Wyświetlanie top5 wypożyczeń //TODO
* Wypożyczanie filmów przez użytkownika
* Sprawdzanie wypożyczeń przez użytkownika
* Przeglądanie wszystkich wypożyczeń przez administratora
* Usuwanie (zwrot) wypożyczeń przez administratora 

### Zalogowany użytkownik

Wypożyczanie filmów przez użytkownika - POST
```
/rental/add
{
	"movies":[
        {
            "title":"Avatar"
        }
	]
}
```

Sprawdzanie wypożyczeń przez użytkownika - GET
```
/rental/add
```

### Admin

Przeglądanie wszystkich wypożyczeń przez administratora - GET
```
/admin/rental
```

Usuwanie (zwrot) wypożyczeń przez administratora - POST 
```
/admin/rental/remove
{
	"id":42
}
```
# Pozostałe informacje

* Podczas startu serwera dodają się przykładowe dane(użytkownicy, gatunki filmów, filmy, wypożyczenia)
* Dane do konta administratora:<br />
Login: admin<br />
Hasło: admin
