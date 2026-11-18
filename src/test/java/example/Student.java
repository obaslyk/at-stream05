package example;

public class Student {

    String name;    // поле: имя студента
    int score;      // поле: баллы

    public String getGrade() {              // обычный метод, без static
        if (score >= 81) {
            return "A";
        } else if (score >= 61) {
            return "B";
        } else {
            return "C";
        }
    }
}

