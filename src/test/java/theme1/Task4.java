package theme1;

public class Task4 {

    public static void main(String[] args) {

        System.out.println(getGrade(0));
        System.out.println(getGrade(12));
        System.out.println(getGrade(31));
        System.out.println(getGrade(45));
        System.out.println(getGrade(78));
        System.out.println(getGrade(99));
        System.out.println(getGrade(155));

    }

    public static String getGrade(int score) {

        if (score >= 0 && score <= 20) {
            return "E";
        } else if (score >= 21 && score <= 40) {
            return "D";
        } else if (score >= 41 && score <= 60) {
            return "C";
        } else if (score >= 61 && score <= 80) {
            return "B";
        } else if (score >= 81 && score <= 100) {
            return "A";
        } else return "Error";
    }
}


