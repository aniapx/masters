##Znalezienie zaleznosci
### 1. Skrypt do znalezienie relacji zaleznosci

## instrukcja nizej wywoluje narzedzie PET,
## ktore parsuje plik "my.c" i tworzy 
# reprezentacje wieloscienna petli zawartej w pliku "my.c"
# wynik PET jest pod zmienna P
P := parse_file "my.c";

## instrukcje nizej zwracaja przestrzen iteracji, Domain
print "Loop domain:";
Domain := P[0];
print Domain;

## instrukcje nizej zwracaja relacje, ktora  kazda instancje kazdej instrukcji
##  mapuje na element tablicy, ktory jest odczytywany 
print "Write:";
Write := P[1] * Domain;
print Write;


## instrukcje nizej zwracaja relacje, ktora  kazda instancje kazdej instrukcji
##  mapuje na element tablicy, ktory jest zapisywany 
print "Read:";
Read := P[3] * Domain;
print Read;



##  instrukcje nizej zwracaja szeregowanie oryginalne, ktore
## mapuje kazda instance kazdej instrukcji na czas wykonania, 
#ktory odpowiada wykonaniu  sekwencyjnemu (oryginalnemu).
print "Orginal schedule:";
Schedule := P[4];
print Schedule;


# instrukcje nizej zwracaja relacje, kt�rej  elementy dziedziny s�
##   leksykograficznie scisle mniejsze ni� elementy  zakresu.
Before := Schedule << Schedule;
print "Before";
print Before;

## obliczenie relacji dla  zaleznosci Read after Write,
## zapis-odczyt 
RaW := (Write . (Read^-1)) * Before;

## obliczenie relacji dla  zaleznosci Write after Write,
## zapis-zapis 
WaW := (Write . (Write^-1)) * Before;

## obliczenie relacji dla  zaleznosci Write after Read,
## odczyt-zapis 
WaR := (Read . (Write^-1)) * Before;
print "RaW deps";
print RaW;
print "WaW deps";
print WaW;
print "WaR deps";
print WaR;


# obliczenie relacji zaleznosci opisujacej
# wszystkie zaleznosci
R := (RaW+WaW+WaR);
print "R";
print R;


## !! UWAGA 1.   Kod w pliku "my.c" musi by� poprawny wzgledem
## standardu ISO C99 jezyka C
## Przed znalezieniem zaleznosci trzeba sprawdzic poprawnosc
# kodu w pliku "my.c" korzystajac z dowolnego kompilatora 
# uwzgledniajacego standard ISO C99  jezyka C

## !! Uwaga 2. Petla w pliku "my.c" musi byc umieszczona
## pomiedzy pragmami #pragma scop  i #pragma endscop.

## !! Uwga 3. Nie inicajlizowa� danych, czyli nie powinno byc deklaracji typu: int n=8;
## Powinno byc: int n;

## !! Uwaga 4. Deklaracje tablic powinne zawierac parametry, nie stale,
## czyli nie powinno byc deklaracji typu: int a[7][7];
## powinno byc: int a[n][n];  


###przyklad. Jesli trzeba znalezc zaleznosci dla petli nizej
## for(i = 1; i <= n; i++)
##   for(j = 1; j <= n; j++)
##      a[i,j]=a[i-1,j]; 

## to poprawny kod w pliku "my.c" jest jak nizej

#int main()
#{
#int i;
#int n;
#int a[n];
#pragma scop
#for(i = 1; i <= n; i++)
##   for(j = 1; j <= n; j++)
##      a[i,j]=a[i-1,j]; 
#pragma endscop
#return 0;
#}

##!!! Uwaga 5. Nazwa pliku moze byc dowolna, czyli zamiast my.c
# moze byc dowolna nazwa

## !!!! Uwaga 6.  Wywolanie skryptu:   iscc < dep.iscc, 
# gdzie dep.iscc jest to plik, ktory zawiera skrypt  wyzej. 



####GENEROWANIE KODU

### aktualna wersja kalkulatora ISCC oparta na  wersji:  "barvinok-0.41"
## generujemy kod za pomoca operatora

## "codegen m", gdzie   m jest szeregowanie
##starsze wersje ISCC umozliwiaja rowniez wygenerowanie kodu dla zbioru, s

##UWAGA on-line wersja kalkulatora ISCC na stronie 
#https://dtai.cs.kuleuven.be/cgi-bin/barvinok.cgi
#implementuje wersje 0.41" czyli kod mozna wygenerowac tylko dla relacji 

## natomiast wersja na stronie  http://compsys-tools.ens-lyon.fr/iscc/index.php
## generuje kod z relacji lub zbioru

## przyklad 1
## dla szeregowania nizej implementujacego wave-fronting

SCHED:=[n]->{[i,j]->[i+j,j]:  1<=i,j<=n};

## operator  
codegen SCHED;

##generuje pseudokod nizej 
#for (int c0 = 2; c0 <= 2 * n; c0 += 1)
#  for (int c1 = max(1, -n + c0); c1 <= min(n, c0 - 1); c1 += 1)
#    (c0 - c1, c1);

##UWAGA: nie jest to kod kompilowalny poniewaz:
## 1) (c0 - c1, c1);  jest to pseudoinstrukcja
## 2) brakuje pragm parallel i for jesli kod docelowy ma byc w OpenMP

##zeby wegenerowac kod przebierajacy elementy zbioru

S:=[n]->{[i,j]:  1<=i,j<=n};

##konwertujemy go na relacje nizej

 m:=[n]->{[i,j]->[i,j]:  1<=i,j<=n};

#Relacja wyzej jest wynikiem zastosowania operatora identity  do zbioru S

## i stosujemy do relacji m polecenie codegen jak nizej

codegen m;



###### POSTPROCESOR  

##Zeby wygenerowac kod kompilowalny przeksztalcamy pseudokod wyzej na kod:
  

#define P #pragma openmp parallel for 
#define S   a[i][j]=a[i][j-1];
#define i c0-c1  // zgodnie z pierwszym elementem pseudoinstrtukcji (c0 - c1, c1);
#define j c1 // zgodnie z drugim elementem pseudoinstrtukcji (c0 - c1, c1);

#int main() {
#        int  c1,c2,n;
#        int a[n][n];
#   for (int c0 = 1; c0 <= n; c0 += 1)
#     P
#     for (int c1 = 1; c1 <= n; c1 += 1)
#         S
#}



 #zalozmy ze kod wyzej jest  w pliku "test.c"

##korzystamy z polecenia:
#gcc 3-test.c -E -o 4-test.txt
## w pliku "4-test.txt" jest kod wynikowy


#int main() {
#        int c1,c2,n;
#        int a[n][n];
#   for (int c0 = 1; c0 <= n; c0 += 1)
#     #pragma openmp parallel for
#     for (int c1 = 1; c1 <= n; c1 += 1)
#       a[c0-c1][c1]=a[c0-c1][c1-1];
#}



##definicje funkcji, ktore moga sie pojawic w pseudokodzie

#include <math.h>
#define ceild(n,d)  ceil(((double)(n))/((double)(d)))
#define floord(n,d) floor(((double)(n))/((double)(d)))
#define max(x,y)    ((x) > (y)? (x) : (y))
#define min(x,y)    ((x) < (y)? (x) : (y))