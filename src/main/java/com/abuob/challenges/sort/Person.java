package com.abuob.challenges.sort;

import com.google.common.base.Objects;

import java.util.Comparator;

public class Person {

    private String firstName;

    private String lastName;

    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equal(firstName, person.firstName) &&
                Objects.equal(lastName, person.lastName) &&
                Objects.equal(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(firstName, lastName, age);
    }

    public static Comparator sortByAgeDescLastNameAsc() {
        return Comparator.comparing(Person::getAge).reversed()
                .thenComparing(Comparator.comparing(Person::getLastName));
    }
}
