public class IntegerBubbleSort {
    static int sorts = 1;

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int n1 = array[i];

                array[i] = array[i + 1];
                array[i + 1] = n1;

                sorts++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 6, 4, 10, 8, 1, 9, 3, 7};

        while (sorts != 0) {
            sorts = 0;
            sort(array);
        }
    }
}
