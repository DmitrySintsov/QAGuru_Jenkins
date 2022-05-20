package com.demoqa.ui.models;

import com.demoqa.ui.helpers.Dates;
import com.demoqa.ui.helpers.Randomizer;
import com.github.javafaker.Faker;

import java.util.*;

public class Student {

    private final String   firstName,
                           lastName,
                           gender,
                           email,
                           mobile,
                           address,
                           state,
                           city;
    private final Date     birthday;
    private final List<String> subjects,
                               hobbies;
    private enum gend {Male,Female,Other}
    private enum states {NCR, Haryana, Rajasthan};
    private enum ncrCities {Delhi, Gurgaon, Noida};
    private enum haryanaCities {Karnal, Panipat};
    private enum rajasthanCities {Jaipur, Jaiselmer};

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
    public String getMobile() {
        return mobile;
    }
    public String getAddress() {
        return address;
    }
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }
    public Date getBirthday() {
        return birthday;
    }
    public List<String> getSubjects() {
        return subjects;
    }
    public List<String> getHobbies() {
        return hobbies;
    }


    public Student() {

        Faker faker = new Faker(new Locale("en-US"));

        this.firstName  = faker.name().firstName();
        this.lastName   = faker.name().lastName();
        this.email      = faker.internet().emailAddress();
        this.gender     = gend.values()[new Random().nextInt(gend.values().length)].toString();
        this.mobile     = faker.number().digits(10);
        this.birthday   = new Dates().getDate(faker.date().birthday(),"dd/MM/yyyy") ;
        this.address    = faker.address().fullAddress();
        this.state      = states.values()[new Random().nextInt(states.values().length)].toString();
        this.city       = getStateCity(getState());
        this.subjects   = new Randomizer().getRandomStringList(Arrays.asList("Maths", "Accounting", "Arts", "Biology", "Chemistry", "Commerce", "English", "Economics", "Hindi", "Physics"));
        this.hobbies    = new Randomizer().getRandomStringList(Arrays.asList("Sports","Reading","Music"));

    }

    private String getStateCity(String state) {
        switch (state) {
            case "NCR":
                return ncrCities.values()[new Random().nextInt(ncrCities.values().length)].toString();
            case "Haryana":
                return haryanaCities.values()[new Random().nextInt(haryanaCities.values().length)].toString();
            case "Rajasthan":
                return rajasthanCities.values()[new Random().nextInt(rajasthanCities.values().length)].toString();
        }
        return "Delhi";
    }



}
