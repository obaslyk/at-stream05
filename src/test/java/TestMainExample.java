import org.junit.jupiter.api.Test;

public class TestMainExample {
    public TestMainExample() {
        this.hi = "part";
    }

    public String hi = "Hi";
    private String bro = "Bro";

    @Test
    void printTest1() {
        System.out.println("Hello, world!");
    }

    @Test
    void anotherPrintTest() {
        System.out.println("123 Hello, world!");
    }

    @Test
    void printTest2() {
        int a = 123;
        int b = 510;

        a = a + 10;
        a = b;
        b = b + 50;

        System.out.println(a);
        System.out.println(b);
    }

    @Test
    void printTest3() {
        boolean quer = true;
        System.out.println(quer);

    }

    @Test
    void printTest4() {
        float x = 12.5f;
        System.out.println(x);

    }

    @Test
    void printTest5() {
        double x = 12.5;
        System.out.println(x);

    }

    @Test
    void printTest6() {
        char x = 's';
        System.out.println(x);

    }

    @Test
    void printTest7() {
        String hello = "Hello";
        String world = hello;
        world = "world";
        hello = "Hello!!!!!";

        System.out.println(hello + ' ' + world);
    }

    @Test
    void printTest8() {
        String hello = "Hello";
        String world = hello;
        world = "world";
        hello = "Hello!!!!!";

        System.out.println(hello + ' ' + world);
    }

    @Test
    void printTest9() {
        int x = 10;
        int y = 5;

        if (!(x > y)) {
            System.out.println("Bigger");
        } else if (!(x < y)) {
            System.out.println("Lower");
        }

    }

    @Test
    void printTest10() {
        int x = 10;
        int y = 5;

        if ((x > y) && (y > 1)) {
            System.out.println("Bigger");
        } else if (!(x < y)) {
            System.out.println("Lower");
        }

    }

    @Test
    public void test() {
        printFive();
        System.out.println(returnFive());
        System.out.println(plus(2, 2));
        System.out.println(AnotherClass.getHi());
        System.out.println(AnotherClass.capital( "Help me"));

        for(String word : AnotherClass.getWords()) {
            System.out.println(word);
        }

        AnotherClass.getBerries().forEach(berry -> {
            System.out.println(berry);
        });
    }

    void printFive() {
        System.out.println("5");
    }

    int returnFive() {
        return 5;
    }
    int plus(int a, int b) {
        int result = a + b;
        return result;
    }


}

