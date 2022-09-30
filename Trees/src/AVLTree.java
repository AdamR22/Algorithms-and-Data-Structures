public class AVLTree<T extends Comparable<T>> {
    private Node<T> root = null;

    private class Node<U> {
        private U data;
        private int balanceFactor = 0;
        private int nodeHeight = 0;
        private Node<U> leftChild;
        private Node<U> rightChild;

        private Node(U value) {
            this.data = value;
            this.leftChild = null;
            this.rightChild = null;
        }

    }

    private boolean isLessThan(T node1Data, T node2Data) {
        return node1Data.compareTo(node2Data) < 0;
    }

    private boolean isGreaterThan(T node1Data, T node2Data) {
        return node1Data.compareTo(node2Data) > 0;
    }

    public void insert(T value) {
        if (root == null)
            root = new Node<T>(value);

        if (root != null)
            insertNode(value, root);
    }

    private void insertNode(T value, Node<T> node) {

        if (isLessThan(value, node.data)) {
            if (node.leftChild == null)
                node.leftChild = new Node<T>(value);

            if (node.leftChild != null)
                insertNode(value, node.leftChild);
        }

        if (isGreaterThan(value, node.data)) {
            if (node.rightChild == null)
                node.rightChild = new Node<T>(value);

            if (node.rightChild != null)
                insertNode(value, node.rightChild);
        }

        update(node);

        balance(node);
    }

    private void balance(Node<T> node) {
        int balanceFactor = node.balanceFactor;

        if (balanceFactor == -2) {
            if (node.leftChild.balanceFactor <= 0)
                leftLeftCase(node);
            else
                leftRightCase(node);
        }

        if (balanceFactor == 2) {
            if (node.rightChild.balanceFactor >= 0)
                rightRightCase(node);
            else
                rightLeftCase(node);
        }
    }

    private void rightRightCase(AVLTree<T>.Node<T> node) {
        leftRotation(node);
    }

    private void leftRotation(AVLTree<T>.Node<T> node) {
        Node<T> newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;

        update(node);
        update(newRoot);
    }

    private void rightLeftCase(AVLTree<T>.Node<T> node) {
        rightLeftRotation(node);
    }

    private void leftRightRotation(AVLTree<T>.Node<T> node) {
        leftRotation(node.leftChild);
        rightRotation(node);
    }

    private void leftLeftCase(AVLTree<T>.Node<T> node) {
        rightRotation(node);
    }

    private void rightRotation(AVLTree<T>.Node<T> node) {
        Node<T> newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;

        update(node);
        update(newRoot);
    }

    private void leftRightCase(AVLTree<T>.Node<T> node) {
        leftRightRotation(node);
    }

    private void rightLeftRotation(AVLTree<T>.Node<T> node) {
        rightRotation(node.rightChild);
        leftRotation(node);
    }

    private void update(Node<T> node) {

        int leftHeight = node.leftChild == null ? -1 : node.leftChild.nodeHeight;
        int rightHeight = node.rightChild == null ? -1 : node.rightChild.nodeHeight;

        node.nodeHeight = Math.max(leftHeight, rightHeight) + 1;

        node.balanceFactor = rightHeight - leftHeight;
    }

    private Node<T> getPredecessor(Node<T> node) {

        while (node.rightChild != null)
            node = node.rightChild;

        return node;
    }

    private Node<T> getSuccessor(Node<T> node) {
        while (node.leftChild != null)
            node = node.leftChild;

        return node;
    }

    public void delete(T value) {
        if (root == null)
            return;

        deleteNode(root, value);
    }

    private Node<T> deleteNode(AVLTree<T>.Node<T> node, T value) {

        if (node == null) return null;

        if (isLessThan(value, node.data))
            node.leftChild = deleteNode(node.leftChild, value);

        if (isGreaterThan(value, node.data))
            node.rightChild = deleteNode(node.rightChild, value);

        if (node.leftChild == null) {
            return node.rightChild;
        }

        if (node.rightChild == null) {
            return node.leftChild;
        }

        if (node.rightChild != null && node.leftChild != null) {

            if (node.leftChild.nodeHeight > node.rightChild.nodeHeight) {
                Node<T> predecessor = getPredecessor(node.leftChild);
                node.data = predecessor.data;
                node.leftChild = deleteNode(node.leftChild, predecessor.data);
            } else {
                Node<T> successor = getSuccessor(node.rightChild);
                node.data = successor.data;
                node.rightChild = deleteNode(node.rightChild, successor.data);
            }

        }

        update(node);
        balance(node);

        return node;
    }

    private void preOrderTraversal(Node<T> node) {
        System.out.println(node.data);
        if (node.leftChild != null)
            preOrderTraversal(node.leftChild);
        if (node.rightChild != null)
            preOrderTraversal(node.rightChild);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.leftChild != null)
            inOrderTraversal(node.leftChild);
        System.out.println(node.data + " BF: " + node.balanceFactor);
        if (node.rightChild != null)
            inOrderTraversal(node.rightChild);
    }

    private void postOrderTraversal(Node<T> node) {
        if (node.leftChild != null)
            postOrderTraversal(node.leftChild);
        if (node.rightChild != null)
            postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    public void preOrderTraversal() {
        if (root == null)
            return;
        preOrderTraversal(root);
    }

    public void inOrderTraversal() {
        if (root == null)
            return;
        inOrderTraversal(root);
    }

    public void postOrderTraversal() {
        if (root == null)
            return;
        postOrderTraversal(root);
    }
}