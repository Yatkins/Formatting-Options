package edu.ti.caih313.collections.dataobj;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.time.Month;
import static org.junit.Assert.*;
public class PersonTest {

        Person john, sam, harry, mark;

        @Before
        public void createTesterPeople() {

            john = new Person(new Name("John", "A"), Person.Gender.MALE, LocalDate.of(1980, Month.MAY, 20));
            john.setEmailAddress("john@gmail.com", EmailAddress.Type.HOME);
            john.setEmailAddress("johnwork@gmail.com", EmailAddress.Type.WORK);
            john.setEmailAddress("johnschool@gmail.com", EmailAddress.Type.SCHOOL);

            sam = new Person(new Name("Sam", "B"), Person.Gender.MALE, LocalDate.of(2000, Month.FEBRUARY, 2));
            sam.setEmailAddress("samschool@gmail.com", EmailAddress.Type.SCHOOL);
            sam.setEmailAddress("samwork@gmail.com", EmailAddress.Type.WORK);

            harry = new Person(new Name("Harry", "C"), Person.Gender.MALE, LocalDate.of(1990, Month.APRIL, 17));
            harry.setEmailAddress("harryschool@gmail.com", EmailAddress.Type.SCHOOL);

            mark = new Person(new Name("Mark", "D"), Person.Gender.MALE, LocalDate.of(2005, Month.JULY, 27));
        }

        @Test
        public void testToString() {
            String johnString = john.toString();
            assertEquals("Person { Name = A, John, Gender = MALE, Birth Date = May 20, 1980 C.E., " +
                    "Primary Email Address = john@gmail.com }", johnString);

            String samString = sam.toString();
            assertEquals("Person { Name = B, Sam, Gender = MALE, Birth Date = Feb 2, 2000 C.E., " +
                    "Primary Email Address = samwork@gmail.com }", samString);

            String harryString = harry.toString();
            assertEquals("Person { Name = C, Harry, Gender = MALE, Birth Date = Apr 17, 1990 C.E., " +
                    "Primary Email Address = harryschool@gmail.com }", harryString);

            String noEmail = mark.toString();
            assertEquals("Person { Name = D, Mark, Gender = MALE, Birth Date = Jul 27, 2005 C.E., " +
                    "Primary Email Address = There are no email addresses }", noEmail);
        }

}