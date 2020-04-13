class Node:
    """
    Container holding our data
    data: integer value
    left_child: pointer to left child
    right_child: pointer to right child
    """

    def __init__(self, data: int):
        self.data = data
        self.left_child = None
        self.right_child = None

class BinarySearchTree:
    """
    Class implementing our data structure
    """
    def __init__(self):
        self.root_node = None

    def insert(self, data: int) -> None:
        """
        Performs insertion operation
        data: integer value
        """
        if not self.root_node:
            # If tree is empty, insert first node which then becomes the root node
            self.root_node = Node(data)
        else:
            self.insert_node(data, self.root_node) # helper function

    def insert_node(self, data: int, node: Node) -> None:
        """
        Inserts a node into our data structure
        data: integer value
        node: node where we want to insert our node as child
        """

        if data < node.data: # First check if value we wish to insert is less than that in current node
            if node.left_child: # check if current node has left child
                self.insert_node(data, node.left_child) # if so, recursively call this method on left child
            else: # if current node has no left child, insert new left child
                node.left_child = Node(data)
        elif data > node.data: # check if data we wish to insert is greater than that in current node
            if node.right_child: # if current node has a right child
                self.insert_node(data, node.right_child) # call method recursively on right child
            else: # if current node has no right child
                node.right_child = Node(data)
        elif data == node.data: # if data we wish to insert is already inside the tree exit function
            return 

    def get_max_value(self) -> int:
        """
        Returns maximum value inside tree
        """
        return self.get_max(self.root_node)

    def get_max(self, node: Node) -> int:
        """
        node: Node inside tree
        """
        if node.right_child:
            return self.get_max(node.right_child)

        return node.data

    def get_min_value(self) -> int:
        """
        Returns minimum value inside tree
        """

        return get_min(self.root_node)

    def get_min(self, node: Node) -> int:
        """
        node: Node inside tree
        """
        if node.left_child:
            return self.get_min(node.left_child)
        
        return node.data

    def traverse(self, mode:str='In Order') -> None:
        """
        mode: string value determining how you wish traversal to occur\
            default value set to In Order
            Accepted values: In Order, Pre Order, Post Order
        """
        if mode == 'In Order':
            self.traverse_in_order(self.root_node)
        elif mode == 'Pre Order':
            self.traverse_pre_order(self.root_node)
        elif mode == 'Post Order':
            self.traverse_post_order(self.root_node)

    def traverse_in_order(self, node: Node) -> None:
        """
        Performs in order traversal
        Left Subtree -> Root -> Right Subtree

        node: Node serving as starting point 
        """
        if node.left_child:
            self.traverse_in_order(node.left_child)

        print(f"{node.data}")

        if node.right_child:
            self.traverse_in_order(node.right_child)


    def traverse_pre_order(self, node: Node) -> None:
        """
        Performs pre order traversal
        Root -> Left Subtree -> Right Subtree

        node: Node serving as starting point
        """
        print(f"{node.data}")

        if node.left_child:
            self.traverse_pre_order(node.left_child)
        
        if node.right_child:
            self.traverse_pre_order(node.right_child)

    def traverse_post_order(self, node: Node) -> None:
        """
        Performs post order traversal
        Left Subtree -> Right Subtree -> Root

        node: Node serving as starting point
        """
        if node.left_child:
            self.traverse_post_order(node.left_child)

        if node.right_child:
            self.traverse_post_order(node.right_child)

        print(f"{node.data}")

    def remove(self, data: int, mode:str="predecessor") -> None:
        """
        Peforms deletion in the tree
        data: integer value
        mode: sets how deletion will take place\
            set to predecessor by default
            accepted values: predecessor, successor
        """
        self.remove_node(data, self.root_node, mode)

    def remove_node(self, data: int, node: Node, mode:str="predecessor") -> None:
        """
        removes a node from tree
        data: integer value
        node: starting point
        mode: string value specifying our deletion method
        """
        if data < node.data: # if data less than starting point, traverse left subtree till we reach node
            node.left_child = self.remove_node(data, node.left_child)
        elif data > node.data: # if data greater than starting point, traverse right subtree till we reach node
            node.right_child = self.remove_node(data, node.right_child)
        else: # if we are inside node we wish to remove
            if not node.left_child and not node.right_child: # if node has no children, remove it and create a null reference in its place
                del(node)
                return None
            elif not node.left_child: # if node has right child, remove right child and return its temporary reference
                temp = node.right_child
                del(node.right_child)
                return temp
            elif not node.right_child: # if node has left child, remove leftchild and return it's temporary reference
                temp = node.left_child
                del(node.left_child)
                return temp
            # The code below is executed in the case where we wish to remove the root node
            if mode == 'predecessor':
                temp = self.return_predecessor(node.left_child)
                node.data = temp.data
                node.left_child = self.remove_node(temp.data, node.left_child)
            elif mode == 'successor':
                temp = self.return_successor(node.right_child)
                node.data = temp.data
                node.right_child = self.remove_node(temp.data, node.right_child)
        
        return node

    def return_predecessor(self, node: Node) -> None:
        """
        Returns value before data held in root node of tree
        """
        if node.right_child:
            self.return_predecessor(node.right_child)
        
        return node

    def return_successor(self, node: Node) -> None:
        """
        Returns value after that held in root node of tree
        """
        if node.left_child:
            self.return_successor(node.left_child)
        
        return node


if __name__ == "__main__":
    bst = BinarySearchTree()
    bst.insert(10)
    bst.insert(5)
    bst.insert(15)
    bst.insert(6)
    bst.insert(14)

    # bst.remove(10)

    print("In order traversal")
    bst.traverse()
    print("")

    print("Pre order traversal")
    bst.traverse(mode="Pre Order")
    print("")

    print("Post order traversal")
    bst.traverse(mode="Post Order")