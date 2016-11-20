package pl.edu.pw.ee.zadanie1;

/*
 * Nie jestem pewny czy dobrze zrozumiałem problem, w swoim rozwiązaniu szukam minimalnej
 * różnicy pomiędzy sumą ciągu od indeksu 0 do pewnego indeksu P, a sumą ciągu od indeksu P+1
 * do końca. I zwracam indeks pod którym taką minimalną różnicę udało mi się znaleźć.
 * Problem nie jest doprecyzowany, ponieważ może być N takich punktów przegięcia ciągu,
 * jeżeli w założeniu zadania mamy że kolekcja zawiera liczby całkowite (a więc również
 * liczby ujemne) zakładam więc, w swoim rozwiązaniu że podaję pierwszy taki punkt
 * patrząc na ciąg od lewej jego strony.
 * Problem rozwiązuję w następujący sposób. Na początku liczę sumę wszystkich elementów
 * ciągu i przypisuję wyliczoną wartość do zmiennej sumaP. Następnie w każdej iteracji 
 * po elementach tablicy t[], od sumaP odejmuję wartość elementu pod indeksem w którym się aktualnie 
 * znajduję, a do sumaL (początkowo zainicjowanej na 0) dodaję tę wartość. Później 
 * następuje warunek którego działanie jest opisane poniżej.
 * Złożoność obliczeniowa to O(n), tablicę przemierzam zawsze dwa razy.
 */
public class Zadanie1 {

    public static int solve(int[] t) {
        /* Jeżeli t jest nullem lub jest puste, zwrócę -1*/
        if (t == null) return -1;
        if (t.length == 0) return -1;
        long sumaL = 0;
        long sumaP = 0;
        
        /* Inicjujemy sumę prawą jako sumę wszytkich elementów */
        for (int i = 0; i < t.length; i++) {
            sumaP += t[i];
        }
        
        /* Jeżeli sumaP zawsze będzie mniejsza od sumaL zwrócę -1*/
        long minPrzegiecieWartosc = Long.MAX_VALUE;
        int minPrzegiecieIndex = -1;
        long tmp;
        
        for (int i = 0; i < t.length; i++) {  
            sumaP -= t[i];
            sumaL += t[i];
            /* 
             * Jeżeli jesteśmy w miejscu gdzie suma lewego podciągu przekroczyła sumę prawego,
             * sprawdzamy czy wartość przekroczenia jest większa od znalezionej poprzednio
             * wartości, jeżeli tak przesuwamy punkt przegięcia w prawo. Znak < w instrukcji warunkowej
             * mówi nam o tym że będziemy brać pierwszy najmniejszy punkt przegięcia patrząc 
             * od lewej strony. Żeby znaleźć taki punkt patrząc od striny prawej, musimy dodać
             * znak = za znakiem <.
             */
            if((sumaL > sumaP) && ((tmp = sumaL - sumaP) < minPrzegiecieWartosc)){
                minPrzegiecieWartosc = tmp;
                minPrzegiecieIndex = i;
            }
        }
        return minPrzegiecieIndex;
    }
}
