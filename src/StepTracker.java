import java.util.Scanner;

public class StepTracker {
    String[] monthName = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();

    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int m = scanner.nextInt();
        if (m < 1 || m > 12) {
            System.out.println("Неверное значение! Введите цифру от 1 до 12");
            return;
        }

        System.out.println("Вы выбрали: " + monthName[m - 1]);

        System.out.println("Введите номер дня");
        int d = scanner.nextInt();
        if (d < 1 || d > 30) {
            System.out.println("Неверное значение! Введите цифру от 1 до 30");
            return;
        }

        System.out.println("Вы выбрали месяц: " + monthName[m - 1] + "; день: " + d);

        System.out.println("Введите количество шагов");
        int newSteps = scanner.nextInt();
        if (newSteps < 0) {
            System.out.println("Неверное значение! минимальное значение = 0");
            return;
        }

        System.out.println("Данные сохранены! Месяц: " + monthName[m - 1] + "; день: " + d + "; шаги: " + newSteps);

        MonthData monthData = monthToData[m - 1];
        monthData.days[d - 1] = newSteps;
    }

    void changeStepGoal() {
        System.out.println("Введите новое значение цели шагов в день:");
        int goal = scanner.nextInt();
        if (goal <= 0) {
            System.out.println("Неверное значение: цель - больше, чем ноль!");
            return;
        }
        System.out.println("Готово! Новое значение цели шагов в день: " + goal);
        goalByStepsPerDay = goal;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int m = scanner.nextInt();

        if (m < 1 || m > 12) {
            System.out.println("Неверное значение! Введите цифру от 1 до 12");
            return;
        }
        System.out.println("Вы выбрали: " + monthName[m - 1]);

        MonthData monthData = monthToData[m - 1];

        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + sumSteps);
        System.out.println("Максимально пройденное количество шагов: " + monthData.maxSteps());
        System.out.println("Среднее количество шагов за месяц: " + sumSteps / 30);
        System.out.println("Пройдено за месяц в км: " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}