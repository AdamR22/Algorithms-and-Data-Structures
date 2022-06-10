/**
 * BinarySearchTree
 */
public class BinarySearchTree<T extends Comparable<T>> {

    class Node<U> {
        private U data;
        private Node<U> leftNode;
        private Node<U> rightNode;

        private Node(U data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    private Node<T> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    private boolean isLessThan(Node<T> nodeOne, Node<T> nodeTwo) {
        return nodeOne.data.compareTo(nodeTwo.data) < 0;
    }

    private boolean isGreaterThan(Node<T> nodeOne, Node<T> nodeTwo) {
        return nodeOne.data.compareTo(nodeTwo.data) > 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insert(data, root);
        }

        size++;
    }

    private void insert(T data, Node<T> node) {
        Node<T> newNode = new Node<>(data);

        if (isLessThan(newNode, node)) {
            if (node.leftNode == null)
                node.leftNode = newNode;
            else
                insert(data, node.leftNode);
        } else if (isGreaterThan(newNode, node)) {
            if (node.rightNode == null)
                node.rightNode = newNode;
            else
                insert(data, node.rightNode);
        }
    }

    private Node<T> findLargestNodeInLeftSubtree(Node<T> node) {
        // Finds node with largest value in leftSubtree
        if (node.rightNode != null) {
            findLargestNodeInLeftSubtree(node.rightNode);
        }

        return node;
    }

    public void removeNode(T data) {
        if (root == null) return;
        
        removeNode(data, root);
    }

    private Node<T> removeNode(T data, Node<T> node) {
        if (data.compareTo(node.data) < 0) {
            node.leftNode = removeNode(data, node.leftNode);
        } else if (data.compareTo(node.data) > 0) {
            node.rightNode = removeNode(data, node.rightNode);
        } else {
            if (node.leftNode == null && node.rightNode == null) {
                // Node to be removed is leaf node
                node = null;
                return null;
            } else if (node.leftNode != null) {
                Node<T> temp = node.leftNode;
                node.leftNode = null;
                return temp;
            } else if (node.rightNode != null) {
                Node<T> temp = node.rightNode;
                node.rightNode = null;
                return temp;
            } else {
                Node<T> temp = findLargestNodeInLeftSubtree(node.leftNode);
                node.data = temp.data;
                node.leftNode = removeNode(temp.data, node.leftNode);
            }
        }

        return node;
    }

    private void preOrderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }

        System.out.println(node.data);

        if (node.leftNode != null) {
            preOrderTraversal(node.leftNode);
        }

        if (node.rightNode != null) {
            preOrderTraversal(node.rightNode);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }

        if (node.leftNode != null) {
            preOrderTraversal(node.leftNode);
        }

        System.out.println(node.data);

        if (node.rightNode != null) {
            preOrderTraversal(node.rightNode);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void postOrderTraversal(Node<T> node) {
        if (node == null) {
            return;
        }

        if (node.leftNode != null) {
            preOrderTraversal(node.leftNode);
        }

        if (node.rightNode != null) {
            preOrderTraversal(node.rightNode);
        }

        System.out.println(node.data);
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }
}