
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
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
    //Test by 영인
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(3,7);
        assertThat(result,is(21));
        assertThat(result,allOf(not(18),lessThan(22)));
        assertThat(result,lessThanOrEqualTo(21));
        System.out.println("result :: " + result);
    }

    //나누기 테스트 작성
    //Test by 영인
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        assertThat(result,is(5));
        assertFalse(result==10);
        assertThat(result,not(10));
        assertThat(result,anyOf(is(10),lessThan(10)));
        System.out.println("result :: " + result);
    }
}