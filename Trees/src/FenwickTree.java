import java.util.Arrays;

public class FenwickTree {
    private Integer[] fenwickTree;

    public FenwickTree(int capacity) {
        // Naive construction: Create new tree and fill it with zeros

        fenwickTree = new Integer[capacity];
        Arrays.fill(fenwickTree, 0);
    }

    public FenwickTree(Integer[] values) {
        // Linear Construction

        fenwickTree = values.clone();
        fenwickTree[0] = 0; // Fenwick trees are one based
        linearConstruction(fenwickTree);
    }

    private int lsb(int i) {
        return Integer.lowestOneBit(i);
    }

    private void linearConstruction(Integer[] tree) {
        for (int i = 1; i < tree.length; i++) {
            int j = i + lsb(i);
            if (j < tree.length)
                tree[j] += tree[i];
        }
    }

    private void pointUpdate(int index, int data) {
        do {
            fenwickTree[index] += data;
            index += lsb(index);
        } while (index < fenwickTree.length);
    }

    private int prefixSum(int index) {
        int sum = 0;

        do {
            sum += fenwickTree[index];
            index -= lsb(index);
        } while (index != 0);

        return sum;
    }

    private int prefixSumInterval(int firstIndex, int lastIndex) {
        return prefixSum(lastIndex) - prefixSum(firstIndex - 1);
    }

    public void update(int index, int data) {
        pointUpdate(index, data);
    }

    public int prefixSumOfTree(int i) {
        return prefixSum(i);
    }

    public int prefixSumBetweenIntervals(int i, int j) {
        return prefixSumInterval(i, j);
    }

    public void add(int index, int data) {
        if (index <= 0)
            throw new IllegalArgumentException("Index must be greater or equal to one");
        pointUpdate(index, data);
    }

    public void traverse() {
        System.out.println("Fenwick tree values");
        for (Integer value : fenwickTree) {
            System.out.println(value);
        }
    }
}
