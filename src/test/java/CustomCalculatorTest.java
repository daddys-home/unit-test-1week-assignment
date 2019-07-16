
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    //Test by 영인
    @Test
    public void add() {
        customCalculator= new CustomCalculator();
        assertTrue(customCalculator.add(4,5)==9);
        int result=customCalculator.add(5,2);
        assertThat(result,is(7));

        System.out.println("result :: " + result);
    }

    //빼기 테스트 작성
    //Test by 영인
    @Test
    public void subtract() {
        customCalculator= new CustomCalculator();
        int result = customCalculator.subtract(14,10);
        assertThat(result,not(3));
        assertThat(result,greaterThan(3));
        assertThat(result,is(4));

        System.out.println("result :: " + result);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        /* 이곳에 테스트 코드를 작성하세요. */
        System.out.println("result :: " + result);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        /* 이곳에 테스트 코드를 작성하세요. */
        System.out.println("result :: " + result);
    }
}