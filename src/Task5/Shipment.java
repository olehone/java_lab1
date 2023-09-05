package Task5;

import java.util.Scanner;

//Завдання No 5.
//        Створіть ієрархію класів предметної області “Сервіс доставки”.
//        Обов’язково використати класи:
//        Task5.Item, Shipment, Customer, Receive Point,Departure Point.
//        Товар, Доставка, Клієнт, Пункт отримання, Пункт відправлення.
//        1. Умови: Реалізувати методи для створення та скасування відправлення.
//        2. Одне відділення доставки може отримувати та відправляти посилки.
//        3. Кожна доставка має мати обмеження по розміру і/або ваги посилок.
//        4. Обмеження залежать від способу доставки (вантажівка, потяг, бус,
//        велокур’єр).
//        5. Якщо адреса точки призначення не належить до адрес відділень
//        доставки, її має доставляти велокур’єр.
//        6. Не використовувати Java Collection, виключно масиви
public class Shipment {
    private static final int MAX_ITEMS = 15;
    private Item[] items;
    private Customer sender, receiver;
    private DeparturePoint departure;
    private ReceivePoint receive;
    private double maxWeight;
    private double totalWeight;

    public Shipment(Customer sender, Customer receiver, DeparturePoint departure, ReceivePoint receive) {
        this.items = new Item[MAX_ITEMS];
        this.totalWeight = 0;
        this.sender = sender;
        this.receiver = receiver;
        this.departure = departure;
        this.receive = receive;
        this.maxWeight = Math.max(departure.getMaxWeight(), receive.getMaxWeight());
    }

    public Shipment(ReceivePoint[] receivePoints, DeparturePoint[] departurePoints, Scanner scanner) {
        this.createShipment(receivePoints, departurePoints, scanner);
    }

    public void createShipment(ReceivePoint[] receivePoints, DeparturePoint[] departurePoints, Scanner scanner) {
        try {

            System.out.println("Введіть ініціали відправника:");
            String senderName = scanner.nextLine();
            sender = new Customer(senderName);
            System.out.println("Введіть ініціали отримувача:");
            String receiverName = scanner.nextLine();
            receiver = new Customer(receiverName);
            boolean good = false;
            do {
                System.out.println("Список адрес доступних для відправлення:");
                for (DeparturePoint departurePoint : departurePoints) {
                    System.out.print(departurePoint.getAddress() + " ");
                }
                System.out.println();
                System.out.println("Введіть адресу відправника:");
                String senderAddress = scanner.nextLine();
                for (DeparturePoint departurePoint : departurePoints) {
                    if (senderAddress.equalsIgnoreCase(departurePoint.getAddress())) {
                        departure = departurePoint;
                        good = true;
                        break;
                    }
                }


            } while (!(good));
            good = false;
            do {
                System.out.println("Список адрес доступних для отримання в відділенні:");
                for (ReceivePoint receivePoint : receivePoints) {
                    System.out.print(receivePoint.getAddress() + " ");
                }
                System.out.println();
                System.out.println("Введіть адресу отримувача:");
                String receiverAddress = scanner.nextLine();
                for (ReceivePoint receivePoint : receivePoints) {
                    if (receiverAddress.equalsIgnoreCase(receivePoint.getAddress())) {
                        receive = receivePoint;
                        good = true;
                        break;
                    }
                }
                if (good)
                    break;
                System.out.println("Не знайдено поштового відділення, відправити кур'єром? (т/н)");
                String isCourier = scanner.nextLine();
                if (isCourier.equalsIgnoreCase("т")) {
                    receive = new ReceivePoint(new Courier(receiverAddress));
                    good = true;
                }
            } while (!(good));
            maxWeight = Math.max(departure.getMaxWeight(), receive.getMaxWeight());

            items = new Item[MAX_ITEMS];
            totalWeight = 0;
            while (AddItemFromConsole(scanner)) ;
            //this.printShipment();
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());

        }
    }

    public void printShipment() {
        System.out.println("Кількість товарів: " + totalItems());
        for (Item item : items) {
            if (item != null)
                System.out.println("Вага: " + item.getWeight() + " кг, опис: " + item.getDescription());
        }
        System.out.println("Загальна вага: " + totalWeight);
        System.out.println("Відправник: " + sender.getInitials());
        System.out.println("Отримувач: " + receiver.getInitials());
        System.out.println("Адреса відправки: " + departure.getAddress());
        System.out.print("Адреса отримування: " + receive.getAddress());
        if (receive.getIsCourier())
            System.out.println(" кур'єром");
        else
            System.out.println(" відділення");
        System.out.println("Максимальна вага: " + maxWeight);
    }

    public boolean AddItemFromConsole(Scanner scanner) {
        System.out.println("Додати товари? (т/н)");
        String isCourier = scanner.nextLine();
        if (isCourier.equalsIgnoreCase("т")) {
            System.out.println("Опис: ");
            String description = scanner.nextLine();
            System.out.println("Вага: ");
            double weight = Double.parseDouble(scanner.nextLine());
            System.out.println(weight);
            AddItem(new Item(weight, description));
            return true;
        }
        return false;
    }

    public void AddItem(Item item) {

        if (totalWeight + item.getWeight() > maxWeight) {
            System.out.println("Завелика вага!");
            return;
        }
        if (totalItems() >= MAX_ITEMS) {
            System.out.println("Забагато товарів для однієї посилки!");
            return;
        }
        items[totalItems()] = item;
        totalWeight += item.getWeight();
    }

    public int totalItems() {
        int count = 0;
        for (Item item : items) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }
}
