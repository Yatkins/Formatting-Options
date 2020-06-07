package edu.ti.caih313.collections.dataobj;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private Name name;
    private Gender gender;

    private EmailAddress emailAddress;

    private LocalDate birthDate;

    public enum Gender {MALE, FEMALE}

    public Person(Name name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        Period ageNow = Period.between(birthDate, LocalDate.now());
        return ageNow.getYears();
    }

    public void setEmailAddress(String emailAddress, EmailAddress.Type type)
    {
        if (this.emailAddress == null)
        {
            this.emailAddress = new EmailAddress(emailAddress, type);
        } else {
            this.emailAddress.emailMap.put(type, emailAddress);
        }
    }


    @Override
    public String toString() {
        String primaryEmail;
        if(this.emailAddress == null){
            primaryEmail = "There are no email addresses";
        }else{
            primaryEmail = emailAddress.getEmailAddress();
        }
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("MMM d, yyyy 'C.E.'");
        String birthday = birthDate.format(dateTimeFormat);
        return String.format("Person { Name = %s, Gender = %s, Birth Date = %s, Primary Email Address = %s }",
                name, gender, birthday, primaryEmail);
    }
}
