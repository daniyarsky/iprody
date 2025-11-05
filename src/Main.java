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

    public static int findSymbolOccurance(String text, char symbol) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == symbol) {
                count++;
            }
        }
        return count;
    }

    public static int findWordPosition(String source, String target) {
        if (source == null || target == null || target.isEmpty()) {
            return -1;
        }

        return source.indexOf(target);
    }

    public static String stringReverse(String text) {
        if (text == null) {
            return null;
        }

        StringBuilder reversed = new StringBuilder(text);
        return reversed.reverse().toString();
    }

    public static boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }

        String reversed = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(reversed);
    }

    public static void main(String[] args) {
        System.out.println(findSymbolOccurance("test", 't'));

        String source1 = "Apollo";
        String target1 = "pollo";
        System.out.println(findWordPosition(source1, target1));

        String source2 = "Apple";
        String target2 = "plant";
        System.out.println(findWordPosition(source2, target2));

        String text = "Hello";
        System.out.println(stringReverse(text));

        System.out.println(isPalindrome("ERe"));
        System.out.println(isPalindrome("Allo"));
    }
}