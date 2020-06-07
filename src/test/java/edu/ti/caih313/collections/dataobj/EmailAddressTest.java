package edu.ti.caih313.collections.dataobj;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailAddressTest {

    // You should have at least three tests: one with no email addresses,
    // one with one email, and one with all three types.

    EmailAddress john, sam, harry, mark;

    @Before
    public void makeEmails() {
        john = new EmailAddress("john@gmail.com", EmailAddress.Type.HOME);
        john.emailMap.put(EmailAddress.Type.WORK, "johnwork@gmail.com");
        john.emailMap.put(EmailAddress.Type.SCHOOL, "johnschool@gmail.com");

        sam = new EmailAddress("samschool@gmail.com", EmailAddress.Type.SCHOOL);
        sam.emailMap.put(EmailAddress.Type.WORK, "samwork@gmail.com");

        harry = new EmailAddress("harryschool@gmail.com", EmailAddress.Type.SCHOOL);
    }

    @Test
    public void oneEmailEach() {
        assertEquals("john@gmail.com", john.getEmailAddress());
        assertEquals("samwork@gmail.com", sam.getEmailAddress());
        assertEquals("harryschool@gmail.com", harry.getEmailAddress());
    }

    @Test
    public void threeEmailsEach() {
        String johnToString = john.toString();
        assertEquals("< HOME: john@gmail.com WORK: johnwork@gmail.com SCHOOL: johnschool@gmail.com>", johnToString);

        String samToString = sam.toString();
        assertEquals("< WORK: samwork@gmail.com SCHOOL: samschool@gmail.com>", samToString);

        String harryToString = harry.toString();
        assertEquals("< SCHOOL: harryschool@gmail.com>", harryToString);

        harry.emailMap.remove(EmailAddress.Type.SCHOOL);
        String removedToString = harry.toString();
        assertEquals("There are no email addresses", removedToString);
        assertNull(harry.getEmailAddress());
    }
}