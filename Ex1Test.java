import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
       public void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        public void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for (String s : good) {
                boolean ok = Ex1.isNumber(s);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }

    @Test
    public void int2NumberTest() {
        // טסטים לבסיסים שונים

        // בדיקות לבסיס 2
        assertEquals("0", Ex1.int2Number(0, 2));
        assertEquals("1010", Ex1.int2Number(10, 2));
        assertEquals("1111", Ex1.int2Number(15, 2));

        // בדיקות לבסיס 16
        assertEquals("A", Ex1.int2Number(10, 16));
        assertEquals("1F", Ex1.int2Number(31, 16));
        assertEquals("FF", Ex1.int2Number(255, 16));

        // בדיקות עבור קלט לא חוקי
        assertEquals("", Ex1.int2Number(-10, 10));
        assertEquals("", Ex1.int2Number(10, 1));
        assertEquals("", Ex1.int2Number(10, 17));
    }
    @Test
    public void equalsTest() {
        // טסטים למקרים תקניים
        assertTrue(Ex1.equals("123b10", "123b10"));
        assertTrue(Ex1.equals("ABb16", "ABb16"));
        assertTrue(Ex1.equals("1001b2", "1001b2"));
        assertTrue(Ex1.equals("0b10", "0b10"));
    }

        // Add additional test functions - test as much as you can.
    }
