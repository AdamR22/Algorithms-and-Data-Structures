public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(6);
        bst.insert(14);

        bst.removeNode(14);

        System.out.println("In order traversal");
        bst.inOrderTraversal();
        System.out.println();

        System.out.println("Pre order traversal");
        bst.preOrderTraversal();
        System.out.println();

        System.out.println("Post order traversal");
        bst.postOrderTraversal();
        System.out.println();
        
        
        // Fenwick Tree: Linear Construction
        Integer[] data = {1, 2, 3, 4, 5};
        FenwickTree ft = new FenwickTree(data);
        ft.traverse(); //Expected values = [0, 2, 5, 4, 14];

        System.out.println("Prefix sum of index 3: " + ft.prefixSumOfTree(3)); //Expected value: 9

        System.out.println("Prefix sum of 1-4: " + ft.prefixSumBetweenIntervals(1, 4)); // Expected value: 14

        // Fenwick Tree: Naive construction
        FenwickTree nc = new FenwickTree(16);
        nc.add(2, 4);
        nc.add(6, 17);
        nc.update(11, 77);
        nc.traverse();
    }
}
