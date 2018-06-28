import org.junit.Test;

import java.io.File;

public class ShellSortTest {

    @Test
    public void testWithNewData() throws Exception {

        int capacity = 1000;
        ShellSort.createNewInputData(capacity);

        File inputData = new File("input.data");
        Queue qu = new Queue(inputData);

        Iterator.NOP = 0;
        ShellSort.sortForQueue(qu);

        System.out.println("OUTPUT: Queue with " + qu.size() + " elements has been sorted.");
        System.out.println("OUTPUT: NOP = " + Iterator.NOP);
    }

    @Test
    public void testWithExistingData() throws Exception {
        File inputData = new File("input.data");
        Queue qu = new Queue(inputData);

        Iterator.NOP = 0;
        ShellSort.sortForQueue(qu);

        System.out.println("OUTPUT: Queue with " + qu.size() + " elements has been sorted.");
        System.out.println("OUTPUT: NOP = " + Iterator.NOP);
    }

}