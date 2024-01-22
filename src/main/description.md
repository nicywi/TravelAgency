# Serwis do biura podróży

## Krótki opis systemu

W ramach projektu należy utworzyć system umożliwiający wyszukiwanie wycieczek po zadanych kryteriach oraz ich „zakup”.

## Główne funkcje systemu

* Strona główna
* Konfigurowanie oferty wycieczek (administrator)
* Wyszukiwanie wycieczek po zadanych kryteriach
* „Zakup” wycieczki – wyliczenie końcowej kwoty wg ilości osób
* (opcjonalnie) Dodatkowe usługi: wynajem auta, wycieczki fakultatywne
* (opcjonalnie) Konfiguracja obostrzeń związanych z paszportem i wizami

## Technologie
* Spring + Hibernate
* (opcjonalnie) Frontend w Angular/React/Thymeleaf

## Podstawowe byty (propozycja)
### Kontynent
* nazwa
### Kraj
* nazwa
* przynależność do kontynentu (klucz obcy)
### Miasto
* nazwa
* przynależność do kraju (klucz obcy)
### Hotel
* nazwa
* standard (ilość gwiazdek)
* opis
* przynależność do miasta (klucz obcy)
### Lotnisko
* nazwa
* przynależność do miasta (klucz obcy)
### Wycieczka
* skąd (Miasto, Lotnisko)
* dokąd (Miasto, Hotel, Lotnisko)
* data wyjazdu
* data powrotu
* ilość dni
* typ: (BB, HB, FB, AI - http://zw.lt/rozmaitosci/wyzywienie-w-hotelach-co-oznaczaja-bb-hb-fb-ai-ov-zpr/)
* cena za dorosłego
* cena za dziecko
* promowana
* ilość miejsc dorosłych
* ilość miejsc dla dzieci
### Zakup wycieczki
* wycieczka
* dane uczestników
* kwota

## Funkcjonalności
### Strona główna
* prezentacja promowanych wycieczek
* prezentacja zbliżających się wycieczek (globalnie)
* prezentacja zbliżających się wycieczek (z podziałem na kontynenty)
* prezentacja zbliżających się wycieczek (z podziałem na kraje)
* prezentacja ostatnio zakupionych wycieczek
* (opcjonalnie) prezentacja wycieczek z obniżoną ceną (trzeba dorobić mechanizm)
* (opcjonalnie) prezentacja wycieczek, w których zostało tylko 1 lub 2 miejsca
### Strona główna - 2
* każda z poniższych list powinna prezentować np. po 3 wpisy + link zobacz więcej kierujący na wyniki wyszukiwania wg zadanego kryterium, np. klikając w link Teneryfa powinno nas przekierować na stronę z wynikami wyszukiwania wycieczek na Teneryfę
* kontynent, kraj, miasto, hotel powinny być klikalne i prowadzić na wyniki wyszukiwania
* po kliknięciu konkretną wycieczkę prezentowane są szczegółowe dane
* (opcjonalnie) pod wycieczką prezentujemy wycieczki w to samo miejsce, ale z późniejszą datą
* (opcjonalnie) pod wycieczką prezentujemy wycieczki do innych hoteli z tego miasta
* (opcjonalnie) pod wycieczką prezentujemy wycieczki do innych miast z tego kraju
### Konfigurowanie oferty wycieczek
* administrator (na osobnej stronie) ma możliwość dodawania i edycji wycieczek
* formularz powinien umożliwiać wpisanie wszystkich parametrów wycieczki
* należy wstępnie skonfigurować bazę kontynentów, krajów, miast, lotnisk i hoteli
* (opcjonalnie) osobne stronki do zarządzania kontynentami, krajami, miastami, lotniskami i hotelami
### Wyszukiwanie wycieczek po zadanych kryteriach
* wszystkie klikalne elementy (kontynenty, kraje, miasta, hotele kierują na stronę z wynikami wyszukiwania
* dodatkowo strona posiada formularz umożliwiający filtrowanie i sortowanie wyników
* można wyszukiwać wycieczki po (np.):
  * mieście (Lotnisku) wylotu
  * mieście (Hotelu) pobytu
  * dacie wyjazdu (opcjonalnie zakresie)
  * dacie powrotu (opcjonalnie zakresie)
  * typie (BB, HB, FB, AI)
  * standardzie hotelu
  * ilości dni
* sortować można po (np.):
  * cenie
  * dacie wylotu
* (opcjonalnie) w miarę wzrostu ilości danych, można wprowadzić stronicowanie wyników wyszukiwania

### Zakup wycieczki
* po wyborze konkretnej wycieczki można ją zakupić
* należy podać ilość dorosłych oraz dzieci
* jeśli będzie odpowiednia ilość wolnych miejsc, wycieczka zostanie „zakupiona”
* ilość wolnych miejsc zostanie pomniejszona
* kwota za wycieczkę zostanie wyliczona (na podstawie ilości osób)
* na stronie/stronach administracyjnych prezentowane są zakupione wycieczki
* (opcjonalnie) można odpowiednio pogrupować ww wycieczki i wprowadzić także prostą wyszukiwarkę
### Dodatkowe wymagania
* należy zadbać o estetyczny i funkcjonalny sposób prezentowania danych
* dane pobierane od użytkowników powinny być wstępnie walidowane