//Завдання No 1. Калькулятор.
//        Реалізувати калькулятор, який буде виконувати операції додавання,
//        віднімання, множення та ділення для двох змінних. Знак операції повинен
//        бути заданим як char або String. Необхідно коректно обробляти такі
//        виключні ситуації:
//        ● ділення на 0;
//        ● введення невірного знаку операції.
public class Task1 {
    public static Integer operation(int a, int b, String opchar) {
        try {
            switch (opchar) {

                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/": {
                    if (b == 0) {
                        throw new Exception("Ділення на нуль");
                    }
                    return a / b;
                }
                default:
                    throw new Exception("Некоректний символ");
            }
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
            return null;
        }

    }
}
