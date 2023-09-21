import Task5.DeliveryDepartment;
import Task5.DeparturePoint;
import Task5.ReceivePoint;
import Task5.Shipment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Task 1

        final int a = 12;
        final int b = 4;
        final int c = 0;
        final String plus = "+";
        final String minus = "-";
        final String division = "/";
        final String wrong = "Hello world!";
        //==============================
        System.out.println(" Завдання 1");
        System.out.println("Додавання " + b + " i " + a + " : " + Task1.operation(a, b, plus));
        System.out.println("Віднімання " + c + " i " + a + " : " + Task1.operation(c, a, minus));
        System.out.println("Ділення на " + a + " i " + c + " : " + Task1.operation(a, c, division));
        System.out.println("Неправильне введення : " + Task1.operation(a, b, wrong));

        //Task 2
        final String[] unsortedList = {"ЛітерАми", "масИв", "ЗА ВелИкими", "ОСЬ ПОСОРТОВАНИЙ"};
        //==============================
        Task2.bubbleSortByCapitalLetters(unsortedList);
        //==============================
        System.out.println("\n Завдання 2");
        System.out.println("Сортований масив: ");
        for (String currentString : unsortedList) {
            System.out.print(currentString + " ");
        }

        //Task 3
        final String[] emailExamples = {
                "example@gmail.com",
                "exa123mple@gma|il.com",
                "example@gmail.",
                "examplegmail.com",
                "example@ukr.net",
                "@gmail.com",
                "example@gmailcom"};
        final String[] phoneExamples = {
                "+380961574384",
                "1654861315511",
                "++545646654555",
                " +380961574384",
                "example@ukr.net",
                "1264789423467",
                "+380hehe88654",
                "+847539512420"};
        //==============================
        System.out.println("\n\n Завдання 3");
        for (String str : emailExamples) {
            if (Task3.validateEmail(str))
                System.out.print(" Успішно ");
            else System.out.print(" Помилка ");

            System.out.println(" для адреси " + str);
        }
        for (String str : phoneExamples) {
            if (Task3.validatePhoneNumber(str))
                System.out.print(" Успішно ");
            else System.out.print(" Помилка ");

            System.out.println(" для телефону " + str);
        }

        //Task 4
        final int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        final int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        final int[][] matrix4 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        //==============================
        final int[][] multiplyFirstAndSecond = Task4.multiplyMatrices(matrix1, matrix2);
        final int[][] multiplyThirdAndFourth = Task4.multiplyMatrices(matrix3, matrix4);
        final int[][] wrongMultiply = Task4.multiplyMatrices(matrix1, matrix4);
        //==============================
        System.out.println("\n Завдання 4");
        System.out.println("Множення матриць:");
        Task4.printMatrix(matrix1);
        Task4.printMatrix(matrix2);
        System.out.println(" Результат:");
        Task4.printMatrix(multiplyFirstAndSecond);
        System.out.println("Множення матриць:");
        Task4.printMatrix(matrix3);
        Task4.printMatrix(matrix4);
        System.out.println(" Результат:");
        Task4.printMatrix(multiplyThirdAndFourth);
        System.out.println("Множення матриць:");
        Task4.printMatrix(matrix1);
        Task4.printMatrix(matrix4);
        System.out.println(" Результат:");
        Task4.printMatrix(wrongMultiply);

        //Task5
        final DeliveryDepartment lviv = new DeliveryDepartment("Львів", true, true, true);
        final DeliveryDepartment kyiv = new DeliveryDepartment("Київ", true, true, true);
        final DeliveryDepartment rivne = new DeliveryDepartment("Рівне", false, false, true);
        final DeliveryDepartment dnipro = new DeliveryDepartment("Дніпро", true, false, false);
        final ReceivePoint[] receivePoints = {new ReceivePoint(kyiv), new ReceivePoint(dnipro)};
        final DeparturePoint[] departurePoints = {new DeparturePoint(lviv), new DeparturePoint(rivne), new DeparturePoint(kyiv)};
        final int MAX_SHIPMENTS = 10;
        boolean isContinue = true;
        Shipment[] shipments = new Shipment[MAX_SHIPMENTS];
        Scanner scanner = new Scanner(System.in);
        //==============================
        System.out.println("\n Завдання 5");
        do {
            System.out.println("Меню:\n1. Переглянути всі відправлення\n2. Додати відправлення\n3. Видалити відправлення\n0. Вийти");
            String choice = scanner.nextLine();
            int countOfShipmens = 0;
            for (Shipment ship : shipments) {
                if (ship != null) {
                    countOfShipmens++;
                }
            }
            switch (choice) {

                case "1": {
                    if (countOfShipmens < 1)
                        System.out.println("Немає відправлень");
                    for (int i = 0; i < countOfShipmens; i++) {
                        System.out.println("Відправлення №" + i + 1);
                        shipments[i].printShipment();
                    }
                    break;
                }
                case "2": {

                    if (countOfShipmens >= 10) {
                        System.out.println("Забагато відправлень в масиві");
                        break;
                    }
                    Shipment newShipment = new Shipment(receivePoints, departurePoints, scanner);
                    if (countOfShipmens > 0)
                        shipments[countOfShipmens - 1] = newShipment;
                    else
                        shipments[0] = newShipment;
                    break;
                }
                case "3": {
                    if (countOfShipmens < 1) {
                        System.out.println("Немає відправлень");
                        break;
                    }
                    if (countOfShipmens == 1)
                        shipments = new Shipment[MAX_SHIPMENTS];
                    System.out.println("Номер відправлень ?");
                    int choiceofDelete;
                    try {
                        String receiverName = scanner.nextLine();
                        choiceofDelete = Integer.parseInt(receiverName);
                        if (choiceofDelete > countOfShipmens || choiceofDelete < 0)
                            throw new IllegalArgumentException("Неправильно введене число");

                        shipments[choiceofDelete - 1] = shipments[countOfShipmens - 1];
                    } catch (Exception e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                    break;
                }
                case "0":
                {
                    isContinue=false;
                    break;
                }

            }

        } while (isContinue);
        for (int i = 0; i < 5; i++) {
            Shipment shipmentLvivKyiv = new Shipment(receivePoints, departurePoints, scanner);
            shipmentLvivKyiv.printShipment();
            System.out.println("Привіт1");
        }
        scanner.close();
    }
}
