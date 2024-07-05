package DSA;

public class mergeSort {

    public static void main(String[] args) {
        int[] array = {3, 7, 8, 5, 4, 2, 6, 1};

        mergeSorted(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void mergeSorted(int[] array) {
        int length = array.length;
        if (length <= 1) return; // base case

        int mid = length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < length; i++) {
            rightArray[i - mid] = array[i];
        }

        mergeSorted(leftArray);
        mergeSorted(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                l++;
            } else {
                array[i] = rightArray[r];
                r++;
            }
            i++;
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            l++;
            i++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            r++;
            i++;
        }
    }
}
