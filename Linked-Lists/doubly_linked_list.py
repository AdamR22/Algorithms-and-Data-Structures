#Code for doubly linked list article

class Node:
    """
    Node has two pointers, one to the next node and
    one to the previous node.
    """
    def __init__(self, data: int):
        self.data = data
        self.next = None
        self.prev = None

class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.size: int = 0

    def insert_first(self, data: int) -> None:
        new_node = Node(data)
        if not self.head:
            self.head = new_node
        else:
            self.head.prev = new_node
            new_node.next = self.head
            self.head = new_node
        
    def insert_last(self, data: int) -> None:
        new_node = Node(data)
        current_node = self.head

        while current_node.next != None:
            current_node = current_node.next

        current_node.next = new_node
        new_node.prev = current_node

    def search(self, key: int) -> "Node":
        #key = data node holds
        current_node = self.head
        while current_node.data != key:
            current_node = current_node.next

        return current_node

    def insert_between_nodes(self, data: int, prev_node_data: int = None) -> None:
        #Function inserts node between nodes that aren't in first of last position of list
        previous_node = self.search(prev_node_data)
        new_node = Node(data)
        new_node.prev = previous_node
        new_node.next = previous_node.next
        previous_node.next.prev = new_node
        previous_node.next = new_node

    def traverse_list(self):
        current_node = self.head
        while current_node != None:
            self.size += 1
            print(current_node.data)
            current_node = current_node.next

    def list_size(self) -> int:
        return self.size

if __name__ == '__main__':
    doubly_linked_list = DoublyLinkedList()
    doubly_linked_list.insert_first(2)
    doubly_linked_list.insert_first(1)
    doubly_linked_list.insert_first(3)
    doubly_linked_list.insert_last(7)
    doubly_linked_list.insert_last(5)
    doubly_linked_list.insert_between_nodes(8, 7)
    doubly_linked_list.insert_between_nodes(9, 3)
    doubly_linked_list.delete_node(5)
    doubly_linked_list.traverse_list()
    print(f"List size: {doubly_linked_list.list_size()}")

"""
Challenge

Try implementing deletion in a doubly linked list.

Solution

def delete_node(self, data: int):
        #data will act as key to node
        current_node = self.head

        while current_node.data != data:
            current_node = current_node.next

        if current_node == self.head:
            
            # Set new head to node after head
            # delete head
            # exit function
            
            self.head = current_node.next
            del(current_node)
            return
        elif current_node.next is None:
            #delete last node and exit function
            current_node.prev.next = current_node.next
            del(current_node)
            return
        else:
            current_node.prev.next = current_node.next
            current_node.next.prev = current_node.prev
            del(current_node)

"""