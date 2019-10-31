package com.abuob.challenges.sort;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void sortTest() {
        List<Person> personList = Lists.newArrayList();


        personList.add(new Person("Lokesh", "Gupta", 28));
        personList.add(new Person("Alex", "Gussin", 71));
        personList.add(new Person("Brian", "Sux", 43));
        personList.add(new Person("Neon", "Piper", 59));
        personList.add(new Person("David", "Beckham", 38));
        personList.add(new Person("Alex", "Beckham", 71));
        personList.add(new Person("Brian", "Suxena", 64));

        personList.sort(Person.sortByAgeDescLastNameAsc());

        assertThat(personList).hasSize(7);

        assertThat(personList.get(0).getAge()).isEqualTo(71);
        assertThat(personList.get(0).getLastName()).isEqualTo("Beckham");

        assertThat(personList.get(1).getAge()).isEqualTo(71);
        assertThat(personList.get(1).getLastName()).isEqualTo("Gussin");

        assertThat(personList.get(6).getAge()).isEqualTo(28);
        assertThat(personList.get(6).getLastName()).isEqualTo("Gupta");
    }
}
