package theme2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import theme1.Methods;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static javax.swing.text.html.parser.DTDConstants.NAMES;
import static theme1.Methods.reverse;
import static theme1.Methods.sumToN;

public class Task2 {

    @BeforeEach
    void beforeEach() {
        System.out.println("========================Test method start");
    }

    @AfterEach
    void afterEach() {
        System.out.println("========================Test method end");
    }


    @Test
    void hasBugTest() {
        String[] withBug = {"Ok", "Fine", "Bug", "Done", "Test"}; // Bug есть, ожидаем true
        //вызываем тестируемый метод
        boolean actualWith = Methods.hasBug(withBug);
        System.out.println("hasBug(" + Arrays.toString(withBug) + ") = " + actualWith);

        if (actualWith) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        String[] withoutBug = {"Debug", "Bugs", "Ok"}; // Bug нет, ожидаем false
        //вызываем тестируемый метод
        boolean actualWithout = Methods.hasBug(withoutBug);
        System.out.println("hasBug(" + Arrays.toString(withoutBug) + ") = " + actualWithout);

        if (!actualWithout) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
    void reverseTest() {
        Random random = new Random();
        // генерируем случайный массив
        int size = 5 + random.nextInt(6); // Случайный размер массива от 5 до 10
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = String.valueOf(random.nextInt(100));
        }

        //создаем ожидаемый результат - переворачиваем массив
        String[] expected = new String[size];
        for (int i = 0; i < size; i++) {
            expected[i] = arr[size - 1 - i];
        }

        //вызываем тестируемый метод
        String[] actual = Methods.reverse(arr);
        System.out.println("reverse(" + Arrays.toString(arr) + ") = " + Arrays.toString(actual));

        if (Arrays.equals(expected, actual)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
    void calcAverageTest() {
        Random random = new Random();
        //генерируем случайный список чисел
        List<Integer> list = new ArrayList<>();
        int size = random.nextInt(1, 11);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(-50, 51));
        }

        //считаем среднее арифметическое ожидаемое
        double expected = 0;
        for (int i = 0; i < list.size(); i++) {
            expected = expected + list.get(i);
        }
        expected = expected / list.size();

        //вызываем тестируемый метод
        double actual = Methods.calcAverage(list);

        System.out.println("calcAverage(" + list + ") = " + actual);

        //сравниваем суммы
        if (Math.abs(expected - actual) < 0.00001)  {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    private static final String[] NAMES = {"Ana", "Ola", "Max", "Ivan", "Eva"};

    @Test
    void removeSpecificNameTest() {
        Random random = new Random();
        //генерируем случайный список имен
        int size = 5 + random.nextInt(3);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            // Берем случайный индекс из массива NAMES
            list.add(NAMES[random.nextInt(NAMES.length)]);
        }
        String name = NAMES[random.nextInt(NAMES.length)];
        List<String> copy = new ArrayList<>(list);

        //ожидаемый результат - список без указанного имени
        List<String> expected = new ArrayList<>(copy);
        expected.removeIf(n -> n.equals(name)); // удаляем все совпавшие имена из ожидаемого списка

        //вызываем тестируемый метод
        List<String> actual = Methods.removeSpecificName(list, name);
        System.out.println("removeSpecificName(" + copy + ", " + name + ") = " + actual);

        // сравниваем списки
        if (expected.equals(actual))  {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(5)
    void isEvenTest() {
        Random random = new Random();
        int n = random.nextInt(1, 101);
        boolean expected = n % 2 == 0;
        //вызываем тестируемый метод
        boolean actual = Methods.isEven(n);
        System.out.println("isEven(" + n + ") = " + actual);
        if (actual == expected) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(20)
    void checkAccessTest() {
        Random random = new Random();
        int age = random.nextInt(0, 100);

        String expected;
        if (age > 18) {
            expected = "Allowed";
        } else {
            expected = "Denied";
        }

        //вызываем тестируемый метод
        String actual = Methods.checkAccess(age);
        System.out.println("checkAccess(" + age + ") = " + actual);

        if ((actual.equals(expected))) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(5)
    void isPositiveTest() {
        Random random = new Random();
        int n = random.nextInt(-50, 51);
        boolean expected = (n >= 0);

        //вызываем тестируемый метод
        boolean actual = Methods.isPositive(n);
        System.out.println("isPositive(" + n + ") = " + actual);

        //сравниваем результат
        if (actual == expected) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(5)
    void sumToNTest() {
        Random random = new Random();
        int n = random.nextInt(1, 20);
        int expected = n * (n + 1) / 2; //вместо цикла for
        /*int expected = 0;
        for (int i = 1; i <= n; i++) {
            expected = expected + i;
        }*/

        //вызываем тестируемый метод
        int actual = Methods.sumToN(n);
        System.out.println("sumToN(" + n + ") = " + actual);

        //сравниваем результат
        if (actual == expected) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }


    static IntStream scores() {
        return new Random().ints(10, 0, 101);
    }

    @ParameterizedTest
    @MethodSource("scores")
    void getGradeTest(int score) {
        //вызываем тестируемый метод
        String actual = Methods.getGrade(score);

        String[] letters = {"E", "D", "C", "B", "A"};
        int index = score == 0 ? 0 : (score - 1) / 20;  // 1..20 -> 0, 21..40 -> 1, ...
        String expected = letters[index];
        System.out.println("getGrade(" + score + ") = " + actual);

        if (actual.equals(expected)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    static IntStream start() {
        return new Random().ints(5, 1, 20);
    }

    @ParameterizedTest
    @MethodSource("start")
    void blastOffTest(int start) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= start; i++) {
            sb.append(start - i + 1).append(" ");
        }
        sb.append("Поехали!");
        String expected = sb.toString();

        //вызываем тестируемый метод
        String actual = Methods.blastOff(start);
        System.out.println("blastOff(" + start + ") = " + actual);

        //сравниваем строки
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    static Stream<Arguments> ranges() {
        Random r = new Random();
        return Stream.generate(() -> {
            int start = r.nextInt(-20, 21);             // -20..20
            int end = start + r.nextInt(0, 21);         // end >= start
            return Arguments.of(start, end);
        }).limit(5);                                    // ограничиваем бесконечный поток
    }

    @ParameterizedTest
    @MethodSource({"ranges"})
    void getEvenInRangeTest(int start, int end) {

        String expected = IntStream.rangeClosed(start, end).toString();

        //вызываем тестируемый метод
        String actual = Methods.getEvenInRange(start, end);
        System.out.println("getEvenInRange(" + start + ", " + end + ") = [" + actual + "]");

        //сравниваем результат
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }


    static Stream<Arguments> arrays() {
        Random r = new Random();
        return Stream.generate(() -> {
            // Генерируем случайный размер от 1 до 10
            int size = r.nextInt(10) + 1;
            // Генерируем сам массив
            int[] arr = r.ints(size, -50, 51).toArray();
            // Возвращаем аргументы
            return Arguments.of(arr);
        }).limit(5);
    }

    @ParameterizedTest
    @MethodSource("arrays")
    void findMaxTest(int[] arr) {
        int expected = Arrays.stream(arr).max().getAsInt();

        int actual = Methods.findMax(arr);
        System.out.println("findMax(" + Arrays.toString(arr) + ") = " + actual);

        if (expected == actual) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }


}

