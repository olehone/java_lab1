package Task5;

import java.time.LocalDateTime;

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
public class ReceivePoint {
    private boolean isCourier;
    private Courier courier;
    private DeliveryDepartment deliveryDepartment;

    public ReceivePoint(Courier courier){
        this.courier = courier;
        this.isCourier = true;
    }
    public ReceivePoint(DeliveryDepartment deliveryDepartment){
        this.deliveryDepartment = deliveryDepartment;
        this.isCourier = false;
    }
    public double getMaxWeight(){
        if(isCourier)
            return 30;
        return deliveryDepartment.getMaxWeight();
    }
    public String getAddress(){
        if(isCourier)
            return courier.getAddress();
        return deliveryDepartment.getAddress();
    }
    public boolean getIsCourier()
    {
        return isCourier;
    }
}
