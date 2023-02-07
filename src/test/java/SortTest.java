import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class SortTest {
    @Test
    void mergeNumberAscendingTest() {
        Sorter sorter = new MergeSorter();
        sorter.setAscendingOrder();
        Object[] array = {1, 12, 5, 45, 2};

        Object[] sortedArray = sorter.sort(array);

        assertArrayEquals(sortedArray, new Object[]{1, 2, 5, 12, 45});
    }

    @Test
    void mergeNumberDescendingTest() {
        Sorter sorter = new MergeSorter();
        sorter.setDescendingOrder();
        Object[] array = {1, 12, 5, 45, 2};

        Object[] sortedArray = sorter.sort(array);

        assertArrayEquals(sortedArray, new Object[]{45, 12, 5, 2, 1});
    }

    @Test
    void mergeWordAscendingTest() {
        Sorter sorter = new MergeSorter();
        sorter.setAscendingOrder();
        Object[] array = {"cat", "tiger", "dog", "lion", "bird"};

        Object[] sortedArray = sorter.sort(array);

        assertArrayEquals(sortedArray, new Object[]{"bird", "cat", "dog", "lion", "tiger"});
    }

    @Test
    void mergeWordDescendingTest() {
        Sorter sorter = new MergeSorter();
        sorter.setDescendingOrder();
        Object[] array = {"cat", "tiger", "dog", "lion", "bird"};

        Object[] sortedArray = sorter.sort(array);

        assertArrayEquals(sortedArray, new Object[]{"tiger", "lion", "dog", "cat", "bird"});
    }

    @Test
    void bubbleNumberAscendingTest() {
        Sorter sorter = new BubbleSorter();
        sorter.setAscendingOrder();
        Object[] array = {1, 12, 5, 45, 2};

        Object[] sortedArray = sorter.sort(array);

        assertArrayEquals(sortedArray, new Object[]{1, 2, 5, 12, 45});
    }

    @Test
    void bubbleNumberDescendingTest() {
        Sorter sorter = new BubbleSorter();
        sorter.setDescendingOrder();
        Object[] array = {1, 12, 5, 45, 2};

        Object[] sortedArray = sorter.sort(array);

        assertArrayEquals(sortedArray, new Object[]{45, 12, 5, 2, 1});
    }

    @Test
    void bubbleWordAscendingTest() {
        Sorter sorter = new BubbleSorter();
        sorter.setAscendingOrder();
        Object[] array = {"cat", "tiger", "dog", "lion", "bird"};

        Object[] sortedArray = sorter.sort(array);

        assertArrayEquals(sortedArray, new Object[]{"bird", "cat", "dog", "lion", "tiger"});
    }

    @Test
    void bubbleWordDescendingTest() {
        Sorter sorter = new BubbleSorter();
        sorter.setDescendingOrder();
        Object[] array = {"cat", "tiger", "dog", "lion", "bird"};

        Object[] sortedArray = sorter.sort(array);

        assertArrayEquals(sortedArray, new Object[]{"tiger", "lion", "dog", "cat", "bird"});
    }
}
