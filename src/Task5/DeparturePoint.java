package Task5;
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
public class DeparturePoint {
    private DeliveryDepartment deliveryDepartment;
    public DeparturePoint(DeliveryDepartment deliveryDepartment){
        this.deliveryDepartment = deliveryDepartment;
    }
    public double getMaxWeight(){
        return  deliveryDepartment.getMaxWeight();
    }
    public String getAddress(){
        return deliveryDepartment.getAddress();
    }
}
