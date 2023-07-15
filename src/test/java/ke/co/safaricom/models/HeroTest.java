package ke.co.safaricom.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class HeroTest {

    @Test
    @DisplayName("Verify age calculation from date of birth where DOB is today")
    void getAgeDOBToday() {
        Hero hero = new Hero();
        hero.setDateOfBirth(LocalDate.now());
        Assertions.assertEquals(0, hero.getAge());
    }

    @Test
    @DisplayName("Verify that age is 1 if the hero was born 400 days ago")
    void getAgeDOB400DaysAgo() {
        Hero hero = new Hero();
        LocalDate dob = LocalDate.now().minusDays(400);
        hero.setDateOfBirth(dob);
        Assertions.assertEquals(1, hero.getAge());
    }

    @Test
    @DisplayName("Verify the age if the hero was born 800 days ago")
    void getAgeDOB800DaysAgo() {
        Hero hero = new Hero();
        LocalDate dob = LocalDate.now().minusDays(800);
        hero.setDateOfBirth(dob);
        Assertions.assertEquals(2, hero.getAge());
    }

    @Test
    @DisplayName("Verify that the hero name set with setName() can be read with getName()")
    void getName() {
        Hero hero = new Hero();
        hero.setName("Superman");
        Assertions.assertEquals("Superman", hero.getName());
    }
}