# Założenia Projektowe - Kompilator Protobuf do Javy

**Dane studenta(-ów):** Mikhail Danilau, Roman Chmirou
**Dane kontaktowe:** danilovmv@student.agh.edu.pl, 

## Założenia programu

### Ogólne cele programu
Zaprojektowanie i implementacja translatora (kompilatora) transformującego opisy struktur danych, usług oraz interfejsów RPC napisanych w formacie **Protocol Buffers (składnia proto3)** do jednoznacznie odpowiadającego im kodu źródłowego w języku **Java**. Projekt obejmuje stworzenie kompletnego front-endu kompilatora, poczynając od analizy leksykalnej (skaner). 

### Rodzaj translatora
Kompilator (konwerter kod źródłowy -> kod źródłowy). Tłumaczy deklaratywny kod języka .proto na postać obiektową ze ścisłym systemem typów w języku Java.

### Planowany wynik działania programu
- **Wynik końcowy:** plik lub zestaw plików z wygenerowanym kodem źródłowym `.java`, z bezbłędnie odwzorowaną strukturą wiadomości, paczek, enumów i usług z początkowego pliku `.proto`.

### Planowany język implementacji
Algorytmy kompilatora są implementowane w języku **Java** (wersja standardowa).

### Sposób realizacji skanera/parsera
Skaner zaimplementowano całkowicie od podstaw programistycznych (ręcznie) jako maszynę stanów z odpowiednim buforowaniem w języku Java. Analizator składniowy (parser) będzie prawdopodobnie zaimplementowany w sposób zstępujący (Recursive Descent Parser) jako kontynuacja prac w języku Java.
