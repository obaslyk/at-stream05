package theme3;

import org.junit.jupiter.api.*;
import theme1.Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3_1 {


    private static final String[] NAMES = {"Ana", "Ola", "Max", "Ivan", "Eva"};

    @BeforeEach
    void beforeEach() {
        System.out.println("========================Test method start");
    }

    @AfterEach
    void afterEach() {
        System.out.println("========================Test method end");
    }

    // 1) метод возвращает boolean
    @Test
    void isEvenTest() {
        Random random = new Random();
        int n = random.nextInt(1, 101);
        boolean expected = n % 2 == 0;

        //вызываем тестируемый метод
        boolean actual = Methods.isEven(n);
        System.out.println("isEven(" + n + ") = " + actual);

        assertEquals(expected, actual, "isEven(" + n + ")");
    }

    // 2) метод возвращает список
    @Test
    void removeSpecificNameTest() {
        Random random = new Random();
        //генерируем случайный список имен
        int size = 5 + random.nextInt(3);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(NAMES[random.nextInt(NAMES.length)]);
        }
        String name = NAMES[random.nextInt(NAMES.length)];
        List<String> copy = new ArrayList<>(list);

        //ожидаемый результат - список без указанного имени
        List<String> expected = new ArrayList<>(copy);
        expected.removeIf(n -> n.equals(name));

        //вызываем тестируемый метод
        List<String> actual = Methods.removeSpecificName(list, name);
        System.out.println("removeSpecificName(" + copy + ", " + name + ") = " + actual);

        assertEquals(expected, actual, "removeSpecificName(" + copy + ", " + name + ")");
    }

    // 3) метод возвращает строку
    @Test
    void getGradeTest() {
        Random random = new Random();
        int score = random.nextInt(0, 101);

        String[] letters = {"E", "D", "C", "B", "A"};
        int index = score == 0 ? 0 : (score - 1) / 20;  // 1..20 -> 0, 21..40 -> 1, ...
        String expected = letters[index];

        //вызываем тестируемый метод
        String actual = Methods.getGrade(score);
        System.out.println("getGrade(" + score + ") = " + actual);

        assertEquals(expected, actual, "getGrade(" + score + ")");
    }

    // 4) ассерт ДОЛЖЕН упасть: для возраста 0..17 метод вернёт Denied, а ожидаем Allowed
    @Test
    @Tag("fail")
    void checkAccessWrongExpectationTest() {
        Random random = new Random();
        int age = random.nextInt(0, 18);
        String expected = "Allowed"; // намеренно неверное ожидание

        //вызываем тестируемый метод
        String actual = Methods.checkAccess(age);
        System.out.println("checkAccess(" + age + ") = " + actual);

        assertEquals(expected, actual, "checkAccess(" + age + "), ожидание намеренно неверное");
    }
}
