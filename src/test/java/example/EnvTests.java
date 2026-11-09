package example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


@Tag("Smoke")
public class EnvTests {
    private boolean isNotEven(int value) {
        return !(value % 2 == 0);
    }

    @Test
    @Tag("Smoke")
    void envTest1() {
        System.out.println("test circuit: " + System.getProperty("CIRCUIT"));
  /*      String testlogin = (System.getenv("TEST_LOGIN") != null) ? System.getenv("TEST_LOGIN") : "ADMIN";
        System.out.println("test account: " + System.getProperty("TEST_LOGIN"));*/
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 1000, 1001})
    void isNotEvenTests(int value) {
        System.out.println("Test with value = " + value);
        if (isNotEven(value) == true) {
            System.out.println("TRUE!");
        } else {
            System.out.println("FALSE!");
        }
    }

    @ParameterizedTest
    @CsvSource({"0, false", "1, true", "2, false", "1000, false", "1001, false"})
    void isNotEventSecondTest(int value, boolean expectedResult) {
        if (isNotEven(value) == expectedResult) {
        System.out.println("PASSED");
    } else {
            System.out.println("FAILED");
        }

    }

    @ParameterizedTest
//    @EnumSource(value = Role.class, names = {"Admin"}) //запустится с ролью Admin
    @EnumSource(value = Role.class) //Запустится со всеми ролями
    void ruleTest(Role role) {
        switch (role) {
            case Admin -> {
                System.out.println("Login as ADMIN");
            }
            case Tester -> {
                System.out.println("Login as TESTER");
            }
            case Observer -> {
                System.out.println("Login as OBSERVER");
            }
        }

    }

    @ParameterizedTest
    @MethodSource("getTestData")
    void tenDivTest(int value) {
        System.out.println(value % 10);
    }
    static List<Integer> getTestData() {
        return List.of(25, 31, 44, 58);
    }

}

