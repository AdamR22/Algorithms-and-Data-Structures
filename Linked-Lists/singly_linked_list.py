class Node:
    def __init__(self, data: int):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.size: int = 0

    def insert_first(self, data: int):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
        else:
            new_node.next = self.head
            self.head = new_node
    
    def insert_last(self, data: int):
        current_node = self.head
        new_node = Node(data)
        while current_node.next != None:
            current_node = current_node.next
        current_node.next = new_node

    def delete_node(self, data: int, prev_node_data: int = None):
        current_node = self.head
        while current_node.data != data:
            current_node = current_node.next
        if current_node == self.head:
            self.head = current_node.next
        else:
            previous_node = self.find_item(prev_node_data)
            previous_node.next = current_node.next
        del(current_node)

    def find_item(self, data: int) -> Node:
        current_node = self.head
        while current_node.data != data:
            current_node = current_node.next
        return current_node
    
    def traverse(self):
        current_node = self.head
        while current_node != None:
            self.size += 1
            print(current_node.data)
            current_node = current_node.next
    
    def list_size(self) -> int:
        return self.size

if __name__ == '__main__':
    linked_list = LinkedList()
    linked_list.insert_first(2)
    linked_list.insert_first(5)
    linked_list.insert_last(7)
    linked_list.insert_last(8)
    linked_list.delete_node(8, 7)
    linked_list.traverse()
    print("Linked List Size: ", linked_list.list_size())