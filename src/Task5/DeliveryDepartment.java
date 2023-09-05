package Task5;

import java.time.LocalTime;

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
public class DeliveryDepartment {
    private String address;
    private boolean isAvailableForTruck;
    private boolean isAvailableForTrain;
    private boolean isAvailableForBus;
    public DeliveryDepartment(String address, boolean isAvailableForTruck, boolean isAvailableForTrain, boolean isAvailableForBus) {
        if (address.length() < 1)
            throw new IllegalArgumentException("Порожня адреса");
        else
            this.address = address;
        this.isAvailableForTruck = isAvailableForTruck;
        this.isAvailableForTrain = isAvailableForTrain;
        this.isAvailableForBus = isAvailableForBus;
    }
    public double getMaxWeight(){
        if(isAvailableForTrain)
            return 1000;
        if(isAvailableForTruck)
            return 500;
        if(isAvailableForBus)
            return 100;
        return 30;
    }
    public String getAddress(){
        return address;
    }
}
