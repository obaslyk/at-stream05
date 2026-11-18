package example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class TestMainExample3 {

    @RepeatedTest(20)
    public void test() {
        Random random = new Random();
//        String actualResult = "";
        Integer actualResult = random.nextInt(1,10);
        Integer expectadBound = 5;

       /* for (int i = 0; i < 10; i++) {
            actualResult= actualResult + random.nextInt(20,70);
           // actualResult= actualResult + new Character();  //символы
        }*/

//        org.junit.jupiter.api.Assertions.assertTrue(actualResult < expectadBound);

        assertThat(actualResult)
                .as("String must be equals")
                .isLessThan(expectadBound)
                .isNotEqualTo(3)
                .isOdd();


    }

   /* @Test
    public void test() {
        Integer dig = new Random().nextInt(1,10);
        Integer expectedResult = 3;
//        assert dig.equals(expectedResult);
//        Assertions.assertEquals(expectedResult, dig);
        assertEquals(expectedResult, dig);
    }*/




 /*   @Test
    public void test() {
        File someFile = new File("1.txt");
        String[] strings = someFile.list();

        //проверяемое исключение
//            throw new RuntimeException()


        //не проверяемое исключение
*//*        try {
            for (String str : strings) {
                System.out.println(str);
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
//            System.out.println("Obrabotka");
//            throw ex;
        }*//*

        System.out.println("End of code");
    }*/

}
