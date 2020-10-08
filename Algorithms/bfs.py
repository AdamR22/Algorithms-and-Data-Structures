from typing import List

class Node:
    """
    Class representing node in graph
    Takes in a name in its constructor
    Each node has a list containing nodes adjacent to it
    Each node also has a boolean tag showing if its been visited or not
    """
    def __init__(self, name: str):
        self.name = name
        self.adjacency_list: List[Node] = []
        self.visited = False


class BreadthFirstSearch:
    """
    Class containing nessecary function for breadth first search
    """

    def bsf(self, starting_node: Node):
        """
        starting_node: Variable of type node dictating where bfs should start
        Performs breadth first algorithm
        """
        queue: List[Node] = [] # List housing visited nodes
        queue.append(starting_node)
        starting_node.visited =True

        while queue:
            actual_node = queue.pop(0)
            print(f"{actual_node.name}")

            for n in actual_node.adjacency_list:
                if not n.visited:
                    n.visited = True
                    queue.append(n)


## Trying out our algorithm with a graph who's nodes are named after some Kenyan towns
node_one = Node("Lamu")
node_two = Node("Garissa")
node_three = Node("Moyale")
node_four = Node("Narok")
node_five = Node("Kakamega")

node_one.adjacency_list.append(node_two)
node_one.adjacency_list.append(node_three)
node_two.adjacency_list.append(node_four)
node_four.adjacency_list.append(node_five)

bsf = BreadthFirstSearch()
bsf.bsf(node_one)