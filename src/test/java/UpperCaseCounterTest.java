import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    
    @Test
    public void null을_전달했을_때_0을_리턴하는지에_대한_테스트(){
        String str = null;
        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result::"+numberOfUpperCaseCharactersInString);
        assertTrue(numberOfUpperCaseCharactersInString==0);
    }

    @Test
    public void 대문자들이_포함된_문자열을_전달했을_때_카운팅된_숫자와_맞는지_검증하는_테스트() {
        String str = "LGTM";

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(numberOfUpperCaseCharactersInString,is(4));

    }

    @Test
    public void 반겂울_전달했을_때_0을_리턴하는지에_대한_테스트() {
        String str = "";
        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        System.out.println("result::"+numberOfUpperCaseCharactersInString);
        assertTrue(numberOfUpperCaseCharactersInString==0);


    }


   
    @Test
    public void 대소문자가_섞여_있을_때_정확히_카운팅_되는_지에_대한_테스트(){
        String str = "Tesung";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(result,is(1));
        System.out.println("result :: " + result);
    }

   
    @Test(expected=IndexOutOfBoundsException.class)
    public void 잘못된_값을_참조했을_때_IndexOutOfBoundsException_Exception이_발생하는지_테스트_코드_작성() {

        new ArrayList<Object>().get(2);

    }


    @Test(timeout=2468)
    public void 해당_메소드가_제한된_시간내에_실행되는지에_대한_테스트_코드() throws InterruptedException {
        Thread.sleep(1357);
        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");
    }
}
