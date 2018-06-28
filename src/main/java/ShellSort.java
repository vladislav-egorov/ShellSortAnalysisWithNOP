import java.io.*;
import java.util.Random;

class ShellSort {

    static void sortForQueue(Queue queue) {
        int n = queue.size();
        Iterator.NOP += 2;

        int h = 1;
        Iterator.NOP++;
        while (h < n/3) {
            h = 3*h + 1;
            Iterator.NOP += 2;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(queue.get(j), queue.get(j-h)); j -= h) {
                    swap(queue, j, j-h);
                    Iterator.NOP += 3;
                }
            }
            h /= 3;
            Iterator.NOP++;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        Iterator.NOP += 3;
        return v.compareTo(w) < 0;
    }

    private static void swap(Queue a, int i, int j) {
        Integer swap = a.get(i);
        Iterator.NOP += 2;
        a.set(i, a.get(j));
        Iterator.NOP += 2;
        a.set(j, swap);
        Iterator.NOP += 2;
    }

    static void createNewInputData(int capacity){
        Writer writer = null;
        Random randomGenerator = new Random();

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("input.data"), "utf-8"));
            for (int i = 0; i < capacity; i++) {
                writer.write((randomGenerator.nextInt(1000) * (randomGenerator.nextBoolean() ? -1 : 1)) + " ");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception ex) {/*ignore*/}
        }

    }
}
