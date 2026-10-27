package theme1;

import java.util.List;

public class Task11 {
    public static void main(String[] args) {

        System.out.println(calcAverage(List.of(11, 22, 33, 44)));
        System.out.println(calcAverage(List.of(5)));
        System.out.println(calcAverage(List.of(-11, 22)));

    }
    public static double calcAverage(List<Integer> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        sum = sum / list.size();
        return sum;

    }
}
