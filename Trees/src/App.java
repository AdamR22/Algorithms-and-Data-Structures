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
    }
}
