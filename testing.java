import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class testing {
    
    public static void main(String[] args) {

    Random random = new Random();



        //
        //HEAP SORT SECTION
        //



        //heap sort of 100
        int[] heapArray1 = new int[100];

        for(int i=0; i < heapArray1.length; i++){
            heapArray1[i] = random.nextInt(100);
        }
        long start = System.currentTimeMillis();
        heapSort(heapArray1);
        long end = System.currentTimeMillis();
        writeToFile(heapArray1, "heapSize100.txt", end-start);



        //heap sort of 1,000
        int[] heapArray2 = new int[1000];

        for(int i=0; i < heapArray2.length; i++){
            heapArray2[i] = random.nextInt(1000);
        }
        start = System.currentTimeMillis();
        heapSort(heapArray2);
        end = System.currentTimeMillis();
        writeToFile(heapArray2, "heapSize1000.txt", end-start);



        //heap sort of 10,000
        int[] heapArray3 = new int[10000];

        for(int i=0; i < heapArray3.length; i++){
            heapArray3[i] = random.nextInt(10000);
        }
        start = System.currentTimeMillis();
        heapSort(heapArray3);
        end = System.currentTimeMillis();
        writeToFile(heapArray3, "heapSize10000.txt", end-start);



        //heap sort of 100,000
        int[] heapArray4 = new int[100000];

        for(int i=0; i < heapArray4.length; i++){
            heapArray4[i] = random.nextInt(100000);
        }
        start = System.currentTimeMillis();
        heapSort(heapArray4);
        end = System.currentTimeMillis();
        writeToFile(heapArray4, "heapSize100000.txt", end-start);



        //
        //QUICK SORT SECTION
        //



        //quick sort of 100
        int[] quickArray1 = new int[100];

        for(int i=0; i < quickArray1.length; i++){
            quickArray1[i] = random.nextInt(100);
        }
        start = System.currentTimeMillis();
        quickSort(quickArray1, 0, quickArray1.length - 1);
        end = System.currentTimeMillis();
        writeToFile(quickArray1, "quickSize100.txt", end-start);



        //quick sort of 1,000
         int[] quickArray2 = new int[1000];

        for(int i=0; i < quickArray2.length; i++){
            quickArray2[i] = random.nextInt(1000);
        }
        start = System.currentTimeMillis();
        quickSort(quickArray2, 0, quickArray2.length - 1);
        end = System.currentTimeMillis();
        writeToFile(quickArray2, "quickSize1000.txt", end-start);



        //quick sort of 10,000
         int[] quickArray3 = new int[10000];

        for(int i=0; i < quickArray3.length; i++){
            quickArray3[i] = random.nextInt(10000);
        }
        start = System.currentTimeMillis();
        quickSort(quickArray3, 0, quickArray3.length - 1);
        end = System.currentTimeMillis();
        writeToFile(quickArray3, "quickSize10000.txt", end-start);



        //quick sort of 100,000
         int[] quickArray4 = new int[100000];

        for(int i=0; i < quickArray4.length; i++){
            quickArray4[i] = random.nextInt(100000);
        }
        start = System.currentTimeMillis();
        quickSort(quickArray4, 0, quickArray4.length - 1);
        end = System.currentTimeMillis();
        writeToFile(quickArray4, "quickSize100000.txt", end-start);


        System.out.println("All sorted arrays written to text files.");
    }

    //
    //HEAP SORT METHODS
    //

    private static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
        
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    //
    //QUICK SORT METHODS
    //

    private static void quickSort(int[] array, int start, int end) {
        if(end <= start) return;
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }

    //fuction in order to separate each array size into their own text file with runtime
    private static void writeToFile(int[] array, String filename, long runtimeMs) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Runtime: " + runtimeMs + " ms\n");
            for (int num : array) {
                writer.write(num + "\n");
            }
            System.out.println(filename + " (runtime: " + runtimeMs + " ms)");
        } catch (IOException e) {
            System.out.println("Error writing to " + filename + ": " + e.getMessage());
        }
    }
}
