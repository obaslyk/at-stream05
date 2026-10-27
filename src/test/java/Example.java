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

//    Пример 3
 /*   public void whileLoopExample() {
        // ЗАДАЧА: Реализовать механизм "умного ожидания" (Smart Wait).
        // Нужно пытаться загрузить страницу не более 5 раз.
        // Если на 2-й попытке произошел сбой — пропустить её и попробовать снова.
        // Если попытки исчерпаны — прервать процесс и выдать ошибку.
        int attempt = 1;
        boolean pageLoaded = false;

        // Работаем, пока страница НЕ загружена
        while (!pageLoaded) {
            System.out.println("Статус: Попытка загрузки №" + attempt);

            if (attempt == 2) {
                System.out.println("Лог: Известная ошибка на 2-й попытке. Пропускаем...");
                attempt++;
                continue; // Пропускаем остаток кода в теле цикла и идем на новую проверку условия
            }

            if (attempt > 5) {
                System.out.println("Лог: Превышено максимальное количество попыток (5).");
                break; // Немедленно выходим из цикла, страница так и не загрузилась
            }

            // Здесь могла бы быть логика реальной проверки:
            // if (driver.findElement(By.id("success")).isDisplayed()) { pageLoaded = true; }
            pageLoaded = Instant.now().toEpochMilli() % 2 == 0;

            attempt++;
        }
    }*/
}

