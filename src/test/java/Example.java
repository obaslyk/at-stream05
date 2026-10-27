public class Example {

    public void forLoopExample(String[] shelf) {
        for (int i = 0; i < shelf.length; i++) {
            if (i == 4) {
                System.out.println("Ячейка №5 на ремонте, пропускаем...");
                continue;
            }

            System.out.println("Проверяем ячейку №" + (i + 1));

            if (shelf[i].equals("Подарок")) {
                System.out.println("Ура! Подарок найден на позиции " + (i + 1));
                break;
            }
        }
    }
}
//Пример 2
 /*   public void forEachExample(List<String> emails) {
        // Задача: отправить уведомления, но пропустить пустые адреса
        // и прекратить рассылку, если встретили "spam@mail.com".
        for (String email : emails) {
            if (email.isEmpty()) {
                continue; // Пропускаем пустую строку и берем следующий email
            }

            if (email.equals("spam@mail.com")) {
                System.out.println("Обнаружен спам-фильтр! Рассылка прервана.");
                break; // Выходим из цикла полностью
            }

            System.out.println("Отправляем письмо на: " + email);
        }
    }*/


