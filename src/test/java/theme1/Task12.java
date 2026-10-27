package theme1;

import java.util.List;
import java.util.ArrayList;

public class Task12 {
    public static void main(String[] args) {

        System.out.println(removeSpecificName(List.of("Ana", "Ola", "Max"), "Ola"));
        System.out.println(removeSpecificName(List.of("Ana", "Ola", "Ola"), "Ola"));
        System.out.println(removeSpecificName(List.of("Ana"), "Max"));
        System.out.println(removeSpecificName(List.of("Ana"), "Ana"));
        System.out.println(removeSpecificName(List.of("Ana", "Ola"), "ola"));

    }

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
