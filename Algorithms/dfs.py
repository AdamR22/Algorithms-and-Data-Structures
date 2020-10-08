from typing import List

class Node:
    def __init__(self, name: str):
        self.adjacency_list: List[Node] = []
        self.name = name
        self.visited = False

class DepthFirstSearch:
    def dfs(self, starting_node: Node):
        print(f"{starting_node.name}")
        starting_node.visited = True
        for n in starting_node.adjacency_list:
            if not n.visited:
                self.dfs(n)

node_one = Node("Lamu")
node_two = Node("Garissa")
node_three = Node("Moyale")
node_four = Node("Narok")
node_five = Node("Kakamega")

node_one.adjacency_list.append(node_two)
node_one.adjacency_list.append(node_three)
node_two.adjacency_list.append(node_four)
node_four.adjacency_list.append(node_five)

dsf = DepthFirstSearch()
dsf.dfs(node_one)