package theme3;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import theme1.Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3_2 {

    // каждый тестовый метод запускается не менее 10 раз
    private static final int RUNS = 10;

    @BeforeEach
    void beforeEach() {
        System.out.println("========================Test method start");
    }

    @AfterEach
    void afterEach() {
        System.out.println("========================Test method end");
    }


    @Tag("regression")
    @Test
    void hasBugTest() {
        // @Test запускается один раз, поэтому повторяем 10 раз циклом
        for (int run = 1; run <= RUNS; run++) {
            Random random = new Random();
            String[] withBug = {"Ok", "Fine", "Done", "Test", "Ok"};
            withBug[random.nextInt(withBug.length)] = random.nextBoolean() ? "Bug" : "BUG";
            //вызываем тестируемый метод
            boolean actualWith = Methods.hasBug(withBug);
            System.out.println("hasBug(" + Arrays.toString(withBug) + ") = " + actualWith);

            // Bug есть, ожидаем true
            assertEquals(true, actualWith, "hasBug(" + Arrays.toString(withBug) + "), запуск " + run);

            String[] withoutBug = {"Debug", "Bugs", "Ok"};
            //вызываем тестируемый метод
            boolean actualWithout = Methods.hasBug(withoutBug);
            System.out.println("hasBug(" + Arrays.toString(withoutBug) + ") = " + actualWithout);

            // Bug нет, ожидаем false
            assertEquals(false, actualWithout, "hasBug(" + Arrays.toString(withoutBug) + "), запуск " + run);
        }
    }

    @Tag("regression")
    @Test
    void reverseTest() {
        for (int run = 1; run <= RUNS; run++) {
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

            assertArrayEquals(expected, actual, "reverse(" + Arrays.toString(arr) + "), запуск " + run);
        }
    }

    @Tag("regression")
    @Test
    void calcAverageTest() {
        for (int run = 1; run <= RUNS; run++) {
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

            //сравниваем с допустимой погрешностью для double
            assertEquals(expected, actual, 0.00001, "calcAverage(" + list + "), запуск " + run);
        }
    }

    private static final String[] NAMES = {"Ana", "Ola", "Max", "Ivan", "Eva"};

    @Tag("regression")
    @Test
    void removeSpecificNameTest() {
        for (int run = 1; run <= RUNS; run++) {
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
            assertEquals(expected, actual,
                    "removeSpecificName(" + copy + ", " + name + "), запуск " + run);
        }
    }

    @Tag("smoke")
    @RepeatedTest(10)
    void isEvenTest() {
        Random random = new Random();
        int n = random.nextInt(1, 101);
        boolean expected = n % 2 == 0;
        //вызываем тестируемый метод
        boolean actual = Methods.isEven(n);
        System.out.println("isEven(" + n + ") = " + actual);

        assertEquals(expected, actual, "isEven(" + n + ")");
    }

    @Tag("smoke")
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

        assertEquals(expected, actual, "checkAccess(" + age + ")");
    }

    @Tag("smoke")
    @RepeatedTest(10)
    void isPositiveTest() {
        Random random = new Random();
        int n = random.nextInt(-50, 51);
        boolean expected = (n >= 0);

        //вызываем тестируемый метод
        boolean actual = Methods.isPositive(n);
        System.out.println("isPositive(" + n + ") = " + actual);

        //сравниваем результат
        assertEquals(expected, actual, "isPositive(" + n + ")");
    }

    @Tag("smoke")
    @RepeatedTest(10)
    void sumToNTest() {
        Random random = new Random();
        int n = random.nextInt(1, 20);
        int expected = n * (n + 1) / 2; //вместо цикла for

        //вызываем тестируемый метод
        int actual = Methods.sumToN(n);
        System.out.println("sumToN(" + n + ") = " + actual);

        //сравниваем результат
        assertEquals(expected, actual, "sumToN(" + n + ")");
    }


    static IntStream scores() {
        return new Random().ints(10, 0, 101);
    }

    @Tag("smoke")
    @ParameterizedTest
    @MethodSource("scores")
    void getGradeTest(int score) {
        //вызываем тестируемый метод
        String actual = Methods.getGrade(score);

        String[] letters = {"E", "D", "C", "B", "A"};
        int index = score == 0 ? 0 : (score - 1) / 20;  // 1..20 -> 0, 21..40 -> 1, ...
        String expected = letters[index];
        System.out.println("getGrade(" + score + ") = " + actual);

        assertEquals(expected, actual, "getGrade(" + score + ")");
    }

    static IntStream start() {
        return new Random().ints(10, 1, 20);
    }

    @Tag("smoke")
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
        assertEquals(expected, actual, "blastOff(" + start + ")");
    }

    static Stream<Arguments> ranges() {
        Random r = new Random();
        return Stream.generate(() -> {
            int start = r.nextInt(-20, 21);             // -20..20
            int end = start + r.nextInt(0, 21);         // end >= start
            return Arguments.of(start, end);
        }).limit(10);                                   // ограничиваем бесконечный поток
    }

    @Tag("regression")
    @ParameterizedTest
    @MethodSource({"ranges"})
    void getEvenInRangeTest(int start, int end) {

        String expected = IntStream.rangeClosed(start, end)
                .filter(i -> i % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        //вызываем тестируемый метод
        String actual = Methods.getEvenInRange(start, end);
        System.out.println("getEvenInRange(" + start + ", " + end + ") = [" + actual + "]");

        //сравниваем результат
        assertEquals(expected, actual, "getEvenInRange(" + start + ", " + end + ")");
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
        }).limit(10);
    }

    @Tag("regression")
    @ParameterizedTest
    @MethodSource("arrays")
    void findMaxTest(int[] arr) {
        int expected = Arrays.stream(arr).max().getAsInt();

        int actual = Methods.findMax(arr);
        System.out.println("findMax(" + Arrays.toString(arr) + ") = " + actual);

        assertEquals(expected, actual, "findMax(" + Arrays.toString(arr) + ")");
    }
}
