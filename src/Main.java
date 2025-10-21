import java.util.Arrays;
import java.util.Random;

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
        int[] source1 = {1, 2, 3, 4};
        int[] target1 = {};
        System.out.println(Arrays.toString(arrayCopy(source1, target1)));

        int[] source2 = {1, 2, 3, 4};
        int[] target2 = {5, 6, 7};
        System.out.println(Arrays.toString(arrayCopy(source2, target2)));

        int[] array = new int[9];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(cocktailSort(array)));
    }
}