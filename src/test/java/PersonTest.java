import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person adultPeron = new Person("Cherif","KadaMOH",18);
    Person minorPeron = new Person("Lolo","KadaMOH",17);
    @Test
    @DisplayName("Full name test")
    void getFullName() {

        String adultFullName = adultPeron.getFullName();


        String minorFullName = minorPeron.getFullName();

        assertEquals("Cherif KadaMOH",adultFullName);
        assertEquals("Lolo KadaMOH",minorFullName);

    }

    @Test
    @DisplayName("testing age >= 18 okay ! return true else it's a minor and return false")
    void isAdultShouldReturnTrueIfAgeIsGreaterOrEquals18() {
        boolean adultBolean = adultPeron.isAdult();
        boolean minorPerson = minorPeron.isAdult();

        assertEquals(true , adultBolean);
        assertEquals(false , minorPerson);

    }
}