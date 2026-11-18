package example;

public class StudentDemo {
    public static void main(String[] args) {

        Student anna = new Student();    // первый объект
        anna.name = "Анна";
        anna.score = 90;

        Student boris = new Student();   // второй объект
        boris.name = "Борис";
        boris.score = 55;

        Student clara = new Student();   // третий объект
        clara.name = "Клара";
        clara.score = 75;

        System.out.println(anna.name + ": " + anna.getGrade());     // Анна: A
        System.out.println(boris.name + ": " + boris.getGrade());   // Борис: C
        System.out.println(clara.name + ": " + clara.getGrade());   // Клара: B

        Student other = anna;  //C
        other.score = 40;
        System.out.println(anna.getGrade());

    }
}