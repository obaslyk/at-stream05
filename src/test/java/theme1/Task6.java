package theme1;

public class Task6 {


    public static void main(String[] args) {
//При n=0 цикл не выполнится ни разу
        System.out.println(sumToN(5));
        System.out.println(sumToN(-7));
        System.out.println(sumToN(1));

    }

    public static int sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }
}


