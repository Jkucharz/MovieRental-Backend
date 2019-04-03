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


### ROLE - Admin

Przypisywanie ról użytkownikom - POST
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
```


Pobieranie listy gatunków filmowych - GET
```
/admin/movie/type
```

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

### ROLE - Zalogowany użytkownik


Usuwanie tokena - GET
```
/logouts?access_token=xxx
```

### ROLE - Wszyscy

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

Pobieranie nazwy aktualnie zalogowanego użytkownika - GET
```
/getUsername
```


Pobieranie wszystkich filmów - GET
```
/getAllMovie
```


## Inne informacje

* Podczas startu serwera dodają się przykładowe dane, między innymi:
\Login: admin
\Hasło: admin

