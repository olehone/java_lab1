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
        Task2.sortStrings(unsortedList);
        //==============================
        System.out.println("\n Завдання 2");
        System.out.println("Сортований масив: ");
        for (String currentString : unsortedList) {
            System.out.print(currentString + " ");
        }

        //Task 3
        final String forbiddenChars = "!@#$%^&*()_+?><\"'|{}[]`/*-+.,";
        final String[] examples = {
                "example@gmail.com",
                "exa123mple@gma|il.com",
                "example@gmail.",
                "examplegmail.com",
                "example@ukr.net",
                "@gmail.com",
                "example@gmailcom"};
        //==============================
        System.out.println("\n\n Завдання 3");
        for (String str : examples) {
            if (Task3.validateEmail(str, forbiddenChars))
                System.out.print(" Успішно ");
            else System.out.print(" Помилка ");

            System.out.println(" для адреси " + str);
        }

        //Task 4
        final int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        final int[][] matrix2 = {{9,8,7},{6,5,4},{3,2,1}};
        final int[][] matrix3 = {{1,2,3,4},{5,6,7,8}};
        final int[][] matrix4 = {{1,2},{3,4},{5,6},{7,8}};
        //==============================
        final int[][] multiplyFirstAndSecond = Task4.multiplyMatrices(matrix1,matrix2);
        final int[][] multiplyThirdAndFourth = Task4.multiplyMatrices(matrix3,matrix4);
        final int[][] wrongMultiply = Task4.multiplyMatrices(matrix1,matrix4);
        //==============================
        System.out.println("\n Завдання 4");
        System.out.println( "Множення матриць:");
        Task4.printMatrix(matrix1);
        Task4.printMatrix(matrix2);
        System.out.println(" Результат:");
        Task4.printMatrix(multiplyFirstAndSecond);
        System.out.println( "Множення матриць:");
        Task4.printMatrix(matrix3);
        Task4.printMatrix(matrix4);
        System.out.println(" Результат:");
        Task4.printMatrix(multiplyThirdAndFourth);
        System.out.println( "Множення матриць:");
        Task4.printMatrix(matrix1);
        Task4.printMatrix(matrix4);
        System.out.println(" Результат:");
        Task4.printMatrix(wrongMultiply);
    }
}
