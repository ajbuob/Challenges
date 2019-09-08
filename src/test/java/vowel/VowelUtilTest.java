package vowel;

import com.abuob.challenges.vowel.VowelUtil;
import org.junit.Test;

public class VowelUtilTest {

    @Test
    public void test1() {
        String s = VowelUtil.vowelsCountString("lexicon");
        System.out.println(s);
    }

    @Test
    public void test2() {
        String s = VowelUtil.vowelsCountString("SAMPLE");
        System.out.println(s);
    }

    @Test
    public void test3() {
        String s = VowelUtil.vowelsCountString("e should be the most common vowel in this sentence");
        System.out.println(s);
    }

    @Test
    public void test4() {
        String s = VowelUtil.vowelsCountString("this is a sentence");
        System.out.println(s);
    }

    @Test
    public void test5() {
        String s = VowelUtil.vowelsCountString("the quick brown fox jumps over the lazy dog");
        System.out.println(s);
    }
}
