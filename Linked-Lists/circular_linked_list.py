class Node:
    def __init__(self, data: int):
        self.data = data
        self.next = self

class CircularLinkedList:
    def __init__(self):
        self.head = None

    def insert_first(self, data: int) -> None:
        new_node = Node(data)
        if not self.head:
            # if list is empty, new node becomes head
            self.head = new_node
        else:
            # point new_node to last
            new_node.next = self.head
            current_node = self.head
            # traverse list till last node
            while current_node.next != self.head:
                current_node = current_node.next
            # point last node to new node
            current_node.next = new_node
            # make new node current head
            self.head = new_node

    def insert_last(self, data: int) -> None:
        new_node = Node(data)
        current_node = self.head

        # traverse list till the last node
        while current_node.next != self.head:
            current_node = current_node.next
        # point last node to newly created node
        current_node.next = new_node
        # point new node to head thus making it the last node
        new_node.next = self.head

    def insert_between_nodes(self, data: int, prev_node_data: int) -> None:
        new_node = Node(data)
        ref_node = self.search(prev_node_data)
        new_node.next = ref_node.next
        ref_node.next = new_node

    def search(self, data: int) -> Node:
        current_node = self.head
        while current_node.data != data:
            current_node = current_node.next
        return current_node

    def traverse(self) -> None:
        current_node = self.head
        while current_node.next != self.head:
            print(current_node.data)
            current_node = current_node.next
        print(current_node.data)

    def delete_node(self, prev_node_data: int, data: int) -> None:
        ref_node = self.search(prev_node_data)
        deleted_node = self.search(data)
        ref_node.next = deleted_node.next
        del(deleted_node)

if __name__ == '__main__':
    circular_linked_list = CircularLinkedList()
    circular_linked_list.insert_first(5)
    circular_linked_list.insert_first(2)
    circular_linked_list.insert_first(7)
    circular_linked_list.insert_last(6)
    circular_linked_list.insert_last(9)
    circular_linked_list.insert_between_nodes(4, 7)
    circular_linked_list.insert_between_nodes(8, 6)
    # circular_linked_list.delete_node(6, 8)
    circular_linked_list.traverse()