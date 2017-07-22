package com.abuob.challenges.anagram;

import com.abuob.challenges.amagram.AnagramUtil;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramUtilTest {

    @Test
    public void isAnagramTest1(){
        assertThat(AnagramUtil.isAnagram1("Mother In Law", "Hitler Woman")).isTrue();
        assertThat(AnagramUtil.isAnagram1("keEp", "peeK")).isTrue();
        assertThat(AnagramUtil.isAnagram1("SiLeNt CAT", "LisTen AcT")).isTrue();
        assertThat(AnagramUtil.isAnagram1("Debit Card", "Bad Credit")).isTrue();
        assertThat(AnagramUtil.isAnagram1("School MASTER", "The ClassROOM")).isTrue();
        assertThat(AnagramUtil.isAnagram1("DORMITORY", "Dirty Room")).isTrue();
        assertThat(AnagramUtil.isAnagram1("ASTRONOMERS", "NO MORE STARS")).isTrue();
        assertThat(AnagramUtil.isAnagram1("Toss", "Shot")).isFalse();
        assertThat(AnagramUtil.isAnagram1("joy", "enjoy")).isFalse();
    }

    @Test
    public void isAnagramTest2(){
        assertThat(AnagramUtil.isAnagram2("Mother In Law", "Hitler Woman")).isTrue();
        assertThat(AnagramUtil.isAnagram2("keEp", "peeK")).isTrue();
        assertThat(AnagramUtil.isAnagram2("SiLeNt CAT", "LisTen AcT")).isTrue();
        assertThat(AnagramUtil.isAnagram2("Debit Card", "Bad Credit")).isTrue();
        assertThat(AnagramUtil.isAnagram2("School MASTER", "The ClassROOM")).isTrue();
        assertThat(AnagramUtil.isAnagram2("DORMITORY", "Dirty Room")).isTrue();
        assertThat(AnagramUtil.isAnagram2("ASTRONOMERS", "NO MORE STARS")).isTrue();
        assertThat(AnagramUtil.isAnagram2("Toss", "Shot")).isFalse();
        assertThat(AnagramUtil.isAnagram2("joy", "enjoy")).isFalse();
    }

    @Test
    public void isAnagramTest3(){
        assertThat(AnagramUtil.isAnagram3("Mother In Law", "Hitler Woman")).isTrue();
        assertThat(AnagramUtil.isAnagram3("keEp", "peeK")).isTrue();
        assertThat(AnagramUtil.isAnagram3("SiLeNt CAT", "LisTen AcT")).isTrue();
        assertThat(AnagramUtil.isAnagram3("Debit Card", "Bad Credit")).isTrue();
        assertThat(AnagramUtil.isAnagram3("School MASTER", "The ClassROOM")).isTrue();
        assertThat(AnagramUtil.isAnagram3("DORMITORY", "Dirty Room")).isTrue();
        assertThat(AnagramUtil.isAnagram3("ASTRONOMERS", "NO MORE STARS")).isTrue();
        assertThat(AnagramUtil.isAnagram3("Toss", "Shot")).isFalse();
        assertThat(AnagramUtil.isAnagram3("joy", "enjoy")).isFalse();
    }

    @Test
    public void isAnagramTest4(){
        assertThat(AnagramUtil.isAnagram4("Mother In Law", "Hitler Woman")).isTrue();
        assertThat(AnagramUtil.isAnagram4("keEp", "peeK")).isTrue();
        assertThat(AnagramUtil.isAnagram4("SiLeNt CAT", "LisTen AcT")).isTrue();
        assertThat(AnagramUtil.isAnagram4("Debit Card", "Bad Credit")).isTrue();
        assertThat(AnagramUtil.isAnagram4("School MASTER", "The ClassROOM")).isTrue();
        assertThat(AnagramUtil.isAnagram4("DORMITORY", "Dirty Room")).isTrue();
        assertThat(AnagramUtil.isAnagram4("ASTRONOMERS", "NO MORE STARS")).isTrue();
        assertThat(AnagramUtil.isAnagram4("Toss", "Shot")).isFalse();
        assertThat(AnagramUtil.isAnagram4("joy", "enjoy")).isFalse();
    }
}
