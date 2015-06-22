# BankTest

Zmodyfikowana tresc tego zadania:
Napisz prostą implementację banku, zwierającego kolekcję (np. tablicę) użytkowników (identyfikowanych przez nazwisko), gdzie każdy użytkownik zawiera kolekcję (np. tablicę) kont (identyfikowanych przez nr). Zaimplementuj operacje:
•	stan konta o podanym numerze
•	stan wszystkich kont podanego klienta
•	wpłać na konto o podanym numerze
•	wypłać z konta o podanym numerze
Błędy zgłaszaj jako wyjątki i reaguj w następujący sposób:
•	brak konta o podanym numerze – wyświetlenie informacji o tym
•	brak użytkownika o podanym nazwisku – wczytanie nowego nazwiska – trzy próby
•	debet – pobranie nowej kwoty – do skutku
•	ujemna kwota – zakończenie programu
Wyjątki te powinny dziedziczyć z klasy Exception (exception).
Po przechwyceniu każdego wyjątku wyświetlaj stos programu.

