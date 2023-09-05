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
public class Item {
    private String description;
    private double weight;
    public Item(double weight, String description) {
        if (weight < 0)
            throw new IllegalArgumentException("Вага повинна бути додатним числом.");;
        this.weight = weight;
        if (description.length() > 1) {
            this.description = description;
        } else this.description = "No description";
    }
    public double getWeight(){
        return weight;
    }
    public String getDescription(){
        return description;
    }

}
