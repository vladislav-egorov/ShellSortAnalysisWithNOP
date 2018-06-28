import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

class Queue {

    private LinkedList<Integer> queue;

    Queue(File inputData){

        try {
            Scanner scanner = new Scanner(inputData);
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");

            this.queue = new LinkedList<Integer>();

            for (String number : numbers) {
                int currentNumber = Integer.parseInt(number);
                this.queue.addLast(currentNumber);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void enqueue(int value){
        queue.addLast(value);
        Iterator.NOP += 3;
    }

    private void dequeue(){
        queue.removeFirst();
        Iterator.NOP += 3;
    }

    private int value(int position){
        Iterator.NOP += 2;
        return this.queue.get(position);
    }

    int size(){
        Iterator.NOP += 3;
        return this.queue.size();
    }

    void set(int position, int number){
        if (position > this.size()){
            System.out.println("Invalid pos to set");
            Iterator.NOP++;
            return;
        }

        int tempSize = this.size();
        Iterator.NOP++;
        LinkedList<Integer> temp = new LinkedList<Integer>();
        Iterator.NOP++;

        for (int i = 0; i < tempSize; i++) {
            temp.addFirst(this.value(0));
            Iterator.NOP += 2;
            this.dequeue();
        }

        for (int i = 0; i < position; i++) {
            this.enqueue(temp.getLast());
            temp.removeLast();
            Iterator.NOP++;
        }

        this.enqueue(number);
        temp.removeLast();
        Iterator.NOP++;

        while (temp.size() > 0) {
            this.enqueue(temp.getLast());
            temp.removeLast();
            Iterator.NOP++;
        }
    }

    int get(int position){
        Iterator.NOP++;
        return value(position);
    }

    @Override
    public String toString(){
        Iterator.NOP++;
        return Arrays.toString(this.queue.toArray());
    }

}
