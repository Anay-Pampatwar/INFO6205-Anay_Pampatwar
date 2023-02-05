package edu.neu.coe.info6205.util;
//This is the part 3 main class to be implemented in Assignment 3 (Benchmark).
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import java.util.Random;
import java.util.function.Consumer;

public class InsertionSortBenchmarks {
    public static void main(String[] args) {
        int m = 500; //number of runs
        Random random = new Random();

        System.out.println(" ");
        System.out.println("Type1. Random Array");
        System.out.println(" ");
        //doubling method starting with n= 1000
        for (int n = 1000; n <= 64000; n = n * 2) {
            InsertionSort<Integer> insertSort = new InsertionSort<>();
            Consumer<Integer[]> consumer = array -> insertSort.sort(array, 0, array.length);
            Benchmark_Timer<Integer[]> benchmarkTimer = new Benchmark_Timer<>("InsertionSort for Random Ordered Array: " + n, consumer);
            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++){
                array[i] = random.nextInt();
            }


            consumer.accept(array);
            System.out.println(benchmarkTimer.run(array, m));
        }

        System.out.println(" ");
        System.out.println("Type2. Ordered Array");
        System.out.println(" ");
        //doubling method starting with n= 1000
        for (int n = 1000; n <= 64000; n = n * 2) {
            InsertionSort<Integer> insertSort = new InsertionSort<>();
            Consumer<Integer[]> consumer = array -> insertSort.sort(array, 0, array.length);
            Benchmark_Timer<Integer[]> benchmarkTimer = new Benchmark_Timer<>("InsertionSort for Ordered Array: " + n, consumer);

            Integer[] array = new Integer[n];
            for (int i = 0; i < n; i++){
                array[i] = i;
            }


            consumer.accept(array);
            System.out.println(benchmarkTimer.run(array, m));
        }

        System.out.println(" ");
        System.out.println("Type3. Reverse Ordered");
        System.out.println(" ");
        //doubling method starting with n= 1000

        for (int n = 1000; n <= 64000; n = n * 2) {
            InsertionSort<Integer> insertSort = new InsertionSort<>();
            Consumer<Integer[]> consumer = array -> insertSort.sort(array, 0, array.length);
            Benchmark_Timer<Integer[]> benchmarkTimer = new Benchmark_Timer<>("InsertionSort for Reverse Ordered Array: " + n, consumer);

            Integer[] array = new Integer[n];
            for (int i = n - 1; i >= 0; i--){
                array[i] = i;
            }


            consumer.accept(array);
            System.out.println(benchmarkTimer.run(array, m));
        }

        System.out.println(" ");
        System.out.println("Type 4. Partially Ordered");
        System.out.println(" ");
        //doubling method starting with n= 1000
        for (int n = 1000; n <= 64000; n = n * 2) {
            InsertionSort<Integer> insertSort = new InsertionSort<>();
            Consumer<Integer[]> consumer = array -> insertSort.sort(array, 0, array.length);
            Benchmark_Timer<Integer[]> benchmarkTimer = new Benchmark_Timer<>("InsertionSort for Partially Ordered Array: " + n, consumer);

            Integer[] array = new Integer[n];
            for (int i = 0; i < n/2; i++){
                array[i] = i;
            }

            for (int j = n - 1 ; j >= n/2; j--){
                array[j] = j;
            }
            consumer.accept(array);
            System.out.println(benchmarkTimer.run(array, m));
        }
    }
}
