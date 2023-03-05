import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        Converter converter = new Converter();
        MonthData  monthData = new MonthData();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.printStatistic();
            }
            else if (command == 2) {
                stepTracker.addNewNumberStepsPerDay();
            }
            else if (command == 3) {
                stepTracker.changeStepGoal();
            }
            else if (command == 0) {
                System.out.println("До свидания!");
                break;
            }
            else {
                System.out.println("Извините, но такой команды нет, поробуйте снова!");
            }
        }
    }
    public static void printMenu() {
        System.out.println();
        System.out.println("Программа `Счетчик шагов и калорий` v.1");
        System.out.println();
        System.out.println("     =Что вы хотите сделать?=");
        System.out.println();
        System.out.println("1 -   Смотреть статистику за месяц");
        System.out.println("2 -            Ввести шаги за день");
        System.out.println("3 -     Изменить цель шагов в день");
        System.out.println();
        System.out.println("0 - Выйти из приложения");
        System.out.println();
    }
}