import java.util.Arrays;
import java.util.Random;
import model.Employee;

public class Main {

    public static int[] arrayCopy(int[] source, int[] target) {
        int[] result = new int[source.length + target.length];

        int lastFilledIndex = -1;
        for (int i = 0; i < target.length; i++) { //n
            lastFilledIndex = i;
        }

        for (int i = 0; i < target.length; i++) { //n
            result[i] = target[i];
        }

        int lastIndex = lastFilledIndex + 1;
        for (int i = 0; i < source.length; i++) { //n
            result[lastIndex + i] = source[i];
        }
// Итого O(n)
        return result;
    }

    public static int[] cocktailSort(int[] array) {
        boolean sorted = false;
        int leftIndex = 0, rightIndex = array.length - 1, lastIndex = 0;

        while (!sorted) { //n
            sorted = true;
            for (int i = leftIndex; i < rightIndex; i++) { //n
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                    lastIndex = i;
                }
            }

            rightIndex = lastIndex;
            if (sorted) break;

            sorted = true;
            for (int i = rightIndex; i > leftIndex; i--) { //n
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    sorted = false;
                    lastIndex = i;
                }
            }

            leftIndex = lastIndex;
            if (sorted) break;
        }
//Итого: O(n^2)
        return array;
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Тестов Тест Тестович", "Инженер", "test@mail.com", "+123456789", 250000, 35);
        employees[1] = new Employee("Иванов Иван Иванович", "Менеджер", "ivanov@mail.com", "+123456789", 300000, 42);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "Разработчик", "sidorov@mail.com", "+123456789", 400000, 45);
        employees[3] = new Employee("Лол Кек Рофл", "Бухгалтер", "rofl@mail.com", "+123456789", 280000, 38);
        employees[4] = new Employee("Доу Джон Дефолтович", "Тимлид", "defolt@mail.com", "+123456789", 500000, 50);

        for (Employee emp : employees) {
            if (emp.getAge() > 40) {
                emp.printInfo();
            }
        }
    }
}