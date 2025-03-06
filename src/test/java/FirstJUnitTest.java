import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstJUnitTest {

    int result;

    @BeforeEach
    void eachMethod(){
        System.out.println("####    eachMethod");
        result = getResult();

    }

    @Test
    void firstTest() {
        System.out.println("####    firstTest()");
        Assertions.assertTrue(result > 2);

    }


    @Test
    void secondTest() {
        System.out.println("####    secondTest()");
        Assertions.assertTrue(result > 2);

    }

    @Test
    void thirdTest() {
        System.out.println("####    fhirdTest()");
        Assertions.assertTrue(result > 2);

    }
    private int getResult(){
        return 3;
    }
}