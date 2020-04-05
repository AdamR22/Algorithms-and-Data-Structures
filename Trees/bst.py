class Node:

    """
    A node is a container which will hold our data
    It will have to pointers, one to its right and another to its left
    """

    def __init__(self, data: int):
        self.data = data
        self.left_child = None
        self.right_child = None

class BinarySearchTree:
    def __init__(self):
        self.root_node = None

    def insert_node(self, data: int, node: Node):
        if data < node.data:
            if node.left_child:
                self.insert_node(data, node.left_child)
            else:
                node.left_child = Node(data)
        if data > node.data:
            if node.right_child:
                self.insert_node(data, node.right_child)
            else:
                node.right_child = Node(data)

    def insert(self, data: int):
        if not self.root_node:
            self.root_node = Node(data)
        self.insert_node(data, self.root_node)

    def traverse_in_order(self, node):
        if node.left_child:
            self.traverse_in_order(node.left_child)
        
        print(node.data)

        if node.right_child:
            self.traverse_in_order(node.right_child)

    def traverse(self):
        if self.root_node:
            self.traverse_in_order(self.root_node)

    def get_previous_node(self, node):
        if node.right_child:
            return self.get_previous_node(node.right_child)

        return child
        
    def remove_node(self, data, node):
        if not node:
            return node

        if data < node.data:
            node.left_child = self.remove_node(data, node.left_child)
        elif data > node.data:
            node.right_child = self.remove_node(data, node.right_child)
        else:
            if not node.left_child and not node.right_child:
                print('Remove leaf node')
                del(node)
                return None
            if not node.left_child:
                print('Removing node with single right child')
                temp_node = node.right_child
                del(node)
                return temp_node
            elif not node.right_child:
                print('Removing node with single left child')
                temp_node = node.left_child
                del(node)
                return temp_node
            
            print('Removing node with two children...')
            temp_node = self.get_previous_node(node.left_child)
            node.data = temp_node.data
            node.left_child = self.remove_node(temp_node.data, node.left_child)
    
        return node

    def remove(self, data):
        if self.root_node:
            self.root_node = self.remove_node(data, self.root_node)

if __name__ == "__main__":
    bst = BinarySearchTree()
    bst.insert(1)
    bst.insert(2)
    bst.insert(3)
    bst.insert(5)
    bst.insert(9)

    bst.traverse()