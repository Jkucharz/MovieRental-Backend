package com.pai2.movierental;

import com.pai2.movierental.persistence.model.Movie;
import com.pai2.movierental.persistence.model.Rental;
import com.pai2.movierental.persistence.model.Type;
import com.pai2.movierental.persistence.model.User;
import com.pai2.movierental.service.MovieService;
import com.pai2.movierental.service.RentalService;
import com.pai2.movierental.service.TypeService;
import com.pai2.movierental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

@Component
public class ExampleData {
    @Autowired
    UserService userService;

    @Autowired
    TypeService typeService;

    @Autowired
    MovieService movieService;

    @Autowired
    RentalService rentalService;


    @PostConstruct()
    public void addExampleData(){
        addUsers();
        addTypes();
        addMovies();
        addRentals();
    }


    public void addUsers() {
        userService.save(new User("Tomek", "kikut", "Tomekk@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("KKKamil", "haslo", "Kamil1995@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Wojtek", "k3512kw", "Wojtek69@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Mariusz", "ship6k6k", "Mariusz11@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Kamillo", "azsxdcfvgbhn", "Ziomek01@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Zbychu", "zbychu16", "Zbychuzabawa@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("JakuP", "JAAAKUP", "JakubP@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Krzysiek", "krzychu1999", "krzysiek12@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Mateusz111", "matt205", "MattCK@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Mateusz12", "password", "MateuszK@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Buba", "bukaj", "KuchJakub@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Karol", "123456qwert", "KaKiwet@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Adam", "losoweznaki", "AdamSz@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Tomasz", "hasl0o", "TomcioPaluch@gmail.com", Arrays.asList(userService.getRole("user"))));
        userService.save(new User("Wojteczek", "09887612345", "Dostro69@gmail.com", Arrays.asList(userService.getRole("user"))));
    }

    public void addTypes() {
        typeService.save(new Type("Horror"));
        typeService.save(new Type("Komedia"));
        typeService.save(new Type("Akcja"));
        typeService.save(new Type("Dramat"));
        typeService.save(new Type("Familijny"));
        typeService.save(new Type("Romans"));
        typeService.save(new Type("Sci-Fi"));
        typeService.save(new Type("Thriller"));
        typeService.save(new Type("Przygodowy"));
    }

    public void addMovies() {
        movieService.save(new Movie("Zielona mila", Arrays.asList(typeService.getType("Dramat")), "Frank Darabont", LocalDate.of(1999, 12, 06), "Emerytowany strażnik więzienny opowiada przyjaciółce o niezwykłym mężczyźnie, którego skazano na śmierć za zabójstwo dwóch 9-letnich dziewczynek.", 5));
        movieService.save(new Movie("Skazani na Shawshank", Arrays.asList(typeService.getType("Dramat")), "Frank Darabont", LocalDate.of(1994, 8, 10), "Adaptacja opowiadania Stephena Kinga. Niesłusznie skazany na dożywocie bankier, stara się przetrwać w brutalnym, więziennym świecie.", 5));
        movieService.save(new Movie("Forrest Gump", Arrays.asList(typeService.getType("Dramat"), typeService.getType("Komedia")), "Robert Zemeckis", LocalDate.of(1994, 05, 23), "Historia życia Forresta, chłopca o niskim ilorazie inteligencji z niedowładem kończyn, który staje się miliarderem i bohaterem wojny w Wietnamie.", 4));
        movieService.save(new Movie("Matrix", Arrays.asList(typeService.getType("Akcja"), typeService.getType("Sci-Fi")), "Wachowski", LocalDate.of(1999, 03, 24), "Haker komputerowy Neo dowiaduje się od tajemniczych rebeliantów, że świat, w którym żyje, jest tylko obrazem przesyłanym do jego mózgu przez roboty.", 4));
        movieService.save(new Movie("Avatar", Arrays.asList(typeService.getType("Akcja"), typeService.getType("Sci-Fi")), "James Cameron", LocalDate.of(2009, 12, 10), "Jake, sparaliżowany były komandos, zostaje wysłany na planetę Pandora, gdzie zaprzyjaźnia się z lokalną społecznością i postanawia jej pomóc. ", 4));
        movieService.save(new Movie("Podziemny krąg", Arrays.asList(typeService.getType("Thriller")), "David Fincher", LocalDate.of(1999, 11, 30), "Dwóch mężczyzn znudzonych rutyną zakłada klub, w którym co tydzień odbywają się walki na gołe pięści.", 4));
        movieService.save(new Movie("Szósty zmysł", Arrays.asList(typeService.getType("Thriller")), "M Night Shyamalan", LocalDate.of(1999, 9, 02), "Psycholog dziecięcy próbuje pomóc ośmioletniemu chłopcu widzącemu zmarłych poradzić sobie z tym niezwykłym darem.", 4));
        movieService.save(new Movie("Nietykalni", Arrays.asList(typeService.getType("Dramat"), typeService.getType("Komedia")), "Eric Toledano", LocalDate.of(2011, 10, 23), "Sparaliżowany milioner zatrudnia do opieki młodego chłopaka z przedmieścia, który właśnie wyszedł z więzienia.", 5));
        movieService.save(new Movie("Piraci z Karaibów: Klątwa Czarnej Perły", Arrays.asList(typeService.getType("Przygodowy")), "Gore Verbinski", LocalDate.of(2003, 06, 28), "Kowal Will Turner sprzymierza się z kapitanem Jackiem Sparrowem, by odzyskać swoją miłość - porwaną córkę gubernatora.", 3));
        movieService.save(new Movie("Władca Pierścieni", Arrays.asList(typeService.getType("Przygodowy")), "Peter Jackson", LocalDate.of(2001, 12, 10), "Podróż hobbita z Shire i jego ośmiu towarzyszy, której celem jest zniszczenie potężnego pierścienia pożądanego przez Czarnego Władcę - Saurona.", 4));
        movieService.save(new Movie("Incepcja", Arrays.asList(typeService.getType("Thriller"), typeService.getType("Sci-Fi")), "Christopher Nolan", LocalDate.of(2010, 07, 8), "Czasy, gdy technologia pozwala na wchodzenie w świat snów. Złodziej Cobb ma za zadanie wszczepić myśl do śpiącego umysłu.", 5));
        movieService.save(new Movie("Wyspa tajemnic", Arrays.asList(typeService.getType("Dramat"), typeService.getType("Thriller")), "Martin Scorsese", LocalDate.of(2010, 02, 13), "PSzeryf federalny Daniels stara się dowiedzieć, jakim sposobem z zamkniętej celi w pilnie strzeżonym szpitalu dla chorych psychicznie przestępców zniknęła pacjentka.", 5));
        movieService.save(new Movie("Seksmisja", Arrays.asList(typeService.getType("Komedia"), typeService.getType("Sci-Fi")), "Juliusz Machulski", LocalDate.of(1983, 05, 14), "Rok 2044, zostają odhibernowani dwaj ostatni przedstawiciele płci męskiej. Władza jest w rękach Ligi Kobiet, która nie zamierza z niej zrezygnować.", 3));
        movieService.save(new Movie("Jak wytresować smoka", Arrays.asList(typeService.getType("Familijny")), "Chris Sanders", LocalDate.of(2010, 03, 18), "Chuderlawy Wiking przewróci porządek w wiosce, kiedy zamiast zabić w ramach inicjacji jakiegoś smoka, zaprzyjaźni się z najgroźniejszym z nich.", 3));
        movieService.save(new Movie("Spider-Man Uniwersum", Arrays.asList(typeService.getType("Familijny")), "Bob Persichetti", LocalDate.of(2018, 12, 07), "Miles Morales po ukąszeniu przez radioaktywnego pająka staje do walki z nikczemnym Kingpinem. Pomogą mu w tym Spider-Menowie z innych wymiarów.", 2));
        movieService.save(new Movie("Król Lew", Arrays.asList(typeService.getType("Familijny")), "Roger Allers", LocalDate.of(1994, 06, 15), "Targany niesłusznymi wyrzutami sumienia po śmierci ojca mały lew Simba skazuje się na wygnanie, rezygnując z przynależnego mu miejsca na czele stada.", 5));
        movieService.save(new Movie("Sherlock Holmes", Arrays.asList(typeService.getType("Przygodowy")), "Guy Ritchie", LocalDate.of(2009, 12, 01), "Najsłynniejszy detektyw Sherlock Holmes z nieodłącznym przyjacielem dr. Watsonem szukają sprawcy rytualnych morderstw.", 2));
        movieService.save(new Movie("Bruce Wszechmogący", Arrays.asList(typeService.getType("Komedia"), typeService.getType("Familijny")), "Tom Shadyac", LocalDate.of(2004, 05, 11), "Reporter, który narzekał nadmiernie na Boga, otrzymuje jego moc i przekona się, że nie łatwo jest rządzić światem.", 2));
        movieService.save(new Movie("Epoka lodowcowa", Arrays.asList(typeService.getType("Familijny"), typeService.getType("Komedia"), typeService.getType("Przygodowy")), "Chris Wedge", LocalDate.of(2002, 03, 12), "W czasie wielkiej migracji zwierząt tygrys szablozębny, mamut i leniwiec starają się oddać ludzkie dziecko jego plemieniu.", 4));
        movieService.save(new Movie("Jestem legendą", Arrays.asList(typeService.getType("Horror"), typeService.getType("Sci-Fi")), "Francis Lawrence", LocalDate.of(2007, 12, 05), "Tajemniczy wirus wymordował lub zamienił w krwiożercze bestie prawie całą ludzkość. Samotny naukowiec Robert Neville poszukuje szczepionki, by odwrócić mutację.", 3));
        movieService.save(new Movie("Lśnienie", Arrays.asList(typeService.getType("Horror")), "Stanley Kubrick", LocalDate.of(1980, 05, 23), "PJack podejmuje pracę stróża odciętego od świata hotelu Overlook. Wkrótce idylla zamienia się w koszmar.", 5));
        movieService.save(new Movie("Zmierzch", Arrays.asList(typeService.getType("Romans"), typeService.getType("Horror")), "Catherine Hardwicke", LocalDate.of(2008, 05, 11), "Adaptacja książki Stephenie Meyer. Nieśmiała i zagubiona nastolatka zakochuje się w wampirze.", 1));
        movieService.save(new Movie("Czas na miłość", Arrays.asList(typeService.getType("Romans"), typeService.getType("Komedia"), typeService.getType("Dramat")), "Richard Curtis", LocalDate.of(2013, 03, 12), "Kończąc 21 lat Tim Lake odkrywa, że może podróżować w czasie. Postanawia więc uczynić świat lepszym, znajdując sobie dziewczynę. ", 2));
        movieService.save(new Movie("Przed północą", Arrays.asList(typeService.getType("Dramat"), typeService.getType("Romans")), "Richard Linklater", LocalDate.of(2013, 01, 05), "Jesse i Celine – po dwudziestu latach od pierwszego spotkania – są już małżeństwem. W czasie wakacji w Grecji rozmawiają o swoim związku i problemach z nim związanych. ", 3));
        movieService.save(new Movie("Byle zero", Arrays.asList(typeService.getType("Horror")), "Stanley Kubrick", LocalDate.of(1999, 05, 23), "Jakiś film", 0));

    }

    public void addRentals() {
        rentalService.save(new Rental(userService.getUser("Wojtek"), Arrays.asList(movieService.getMovie("Matrix"), movieService.getMovie("Avatar"), movieService.getMovie("Jestem legendą"), movieService.getMovie("Lśnienie")),  LocalDate.of(2012, 01, 14)));
        rentalService.save(new Rental(userService.getUser("Krzysiek"), Arrays.asList(movieService.getMovie("Przed północą"), movieService.getMovie("Byle zero")),  LocalDate.of(2015, 11, 24)));
        rentalService.save(new Rental(userService.getUser("Tomek"), Arrays.asList(movieService.getMovie("Władca Pierścieni"), movieService.getMovie("Król Lew"), movieService.getMovie("Byle zero")),  LocalDate.of(2014, 05, 24)));
        rentalService.save(new Rental(userService.getUser("Mariusz"), Arrays.asList(movieService.getMovie("Jak wytresować smoka"), movieService.getMovie("Zielona mila")),  LocalDate.of(2012, 8, 12)));
        rentalService.save(new Rental(userService.getUser("Mateusz12"), Arrays.asList(movieService.getMovie("Jak wytresować smoka"), movieService.getMovie("Epoka lodowcowa"), movieService.getMovie("Avatar")),  LocalDate.of(2019, 02, 12)));
        rentalService.save(new Rental(userService.getUser("Mateusz111"), Arrays.asList(movieService.getMovie("Nietykalni"), movieService.getMovie("Forrest Gump")),  LocalDate.of(2011, 9, 12)));
        rentalService.save(new Rental(userService.getUser("Buba"), Arrays.asList(movieService.getMovie("Zielona mila"), movieService.getMovie("Szósty zmysł")),  LocalDate.of(2019, 11, 14)));
        rentalService.save(new Rental(userService.getUser("JakuP"), Arrays.asList(movieService.getMovie("Nietykalni"), movieService.getMovie("Matrix"), movieService.getMovie("Avatar")),  LocalDate.of(2012, 10, 14)));
        rentalService.save(new Rental(userService.getUser("Kamillo"), Arrays.asList(movieService.getMovie("Forrest Gump"), movieService.getMovie("Incepcja")),  LocalDate.of(2017, 9, 24)));
        rentalService.save(new Rental(userService.getUser("KKKamil"), Arrays.asList(movieService.getMovie("Zielona mila"), movieService.getMovie("Zmierzch"), movieService.getMovie("Matrix")),  LocalDate.of(2011, 11, 24)));
        rentalService.save(new Rental(userService.getUser("Wojtekczek"), Arrays.asList(movieService.getMovie("Szósty zmysł"), movieService.getMovie("Incepcja"), movieService.getMovie("Piraci z Karaibów: Klątwa Czarnej Perły")),  LocalDate.of(2019, 10, 04)));
        rentalService.save(new Rental(userService.getUser("Zbychu"), Arrays.asList(movieService.getMovie("Seksmisja"), movieService.getMovie("Piraci z Karaibów: Klątwa Czarnej Perły"), movieService.getMovie("Król Lew")),  LocalDate.of(2001, 11, 24)));
    }
}
