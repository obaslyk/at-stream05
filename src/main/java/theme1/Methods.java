package theme1;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    //1 возвращает true, если число чётное, иначе false
    public static boolean isEven(int n) {
        if ((n % 2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    //2 возвращает "Allowed", если возраст строго больше 18, иначе "Denied"
    public static String checkAccess(int age) {
        if (age > 18) {
            return "Allowed";
        } else {
            return "Denied";
        }
    }

    //3 через тернарный оператор возвращает true, если число ≥ 0, иначе false
    public static boolean isPositive(int n) {
        return (n >= 0) ? true : false;
    }

    //4 возвращает оценку (E/D/C/B/A) по диапазону баллов или "Error" вне границ
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

    //5 возвращает строку с обратным отсчётом от start до 1 и словом «Поехали!»
    public static String blastOff(int start) {

        String result = "";

        for (int i = start; i >= 1; i--) {
            result = result + i + " ";
        }
        return result + "Поехали!";
    }

    //6 возвращает сумму всех целых чисел от 1 до n
    public static int sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        return sum;
    }

    //7 возвращает true, если хотя бы одна строка равна "Bug"
    public static boolean hasBug(String[] messages) {
        for (int i = 0; i < messages.length; i++) {
            if (messages[i].equalsIgnoreCase("Bug")) {
                return true;
            }
        }
        return false;
    }

    //8 возвращает строку из чётных чисел в диапазоне (включая границы)
    public static String getEvenInRange(int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            if ((i % 2) == 0) {
                if (!result.isEmpty()) {
                    result = result + " ";
                }
                result = result + i;
            }
        }
        return result;
    }


    //9 возвращает максимальное число в массиве
    public static int findMax(int[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //10 возвращает новый массив с элементами в обратном порядке
    public static String[] reverse(String[] arr) {

        String[] result = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] =  arr[arr.length - 1 - i];

        }
        return result;
    }

    //11 возвращает среднее арифметическое всех чисел в списке
    public static double calcAverage(List<Integer> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        sum = sum / list.size();
        return sum;
    }

    //12 возвращает новый список без указанного имени
    public static List<String> removeSpecificName(List<String> list, String nameToRemove){

        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equalsIgnoreCase(nameToRemove)) {
                result.add(list.get(i));
            }
        }
        return result;

    }


}


