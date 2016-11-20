import org.junit.Test;
import static org.junit.Assert.*;
import pl.edu.pw.ee.zadanie1.Zadanie1;

/**
 *
 * @author bladekp
 */
public class SolvingTest {
    
    /* Test z treści zadania */
    @Test
    public void testZadanie() {
        assertEquals(2, Zadanie1.solve(new int[]{1,2,5,2,1}));
    }
    
    /* Test gdzie mamy dwa punkty przegiecia na indeksach 1 oraz 3 */
    @Test
    public void testDwaPunkty() {
        assertEquals(1, Zadanie1.solve(new int[]{1,2,-2,2,1}));
    }
    
    @Test
    public void testNull() {
        assertEquals(-1, Zadanie1.solve(null));
    }
    
    @Test
    public void testPustaTablica() {
        assertEquals(-1, Zadanie1.solve(new int[]{}));
    }
    
    @Test
    public void testJedenElementUjemny() {
        /* 
         * Powinien zwrócić -1 ponieważ suma po lewej będzie wynosić -1 podczas gdy suma 
         * po prawej będzie wynosić 0, czyli będzie większa bądź równa (szukamy mniejszej).
         */
        assertEquals(-1, Zadanie1.solve(new int[]{-1}));
    }
    
    @Test
    public void testJedenElementZerowy() {
        /* 
         * Powinien zwrócić -1 ponieważ suma po lewej będzie wynosić 0 podczas gdy suma 
         * po prawej będzie wynosić 0, czyli będzie większa bądź równa (szukamy mniejszej).
         */
        assertEquals(-1, Zadanie1.solve(new int[]{0}));
    }
    
    @Test
    public void testJedenElementDodatni() {
        /* 
         * Powinien zwrócić 0 ponieważ suma po lewej będzie wynosić 1 podczas gdy suma 
         * po prawej będzie wynosić 0, czyli będzie mniejsza (takiej szukamy).
         */
        assertEquals(0, Zadanie1.solve(new int[]{1}));
    }    
}
