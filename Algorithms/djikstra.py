from typing import List
import sys
import heapq

class Node:
    """
    Class that defines the nodes of the graph
    """
    def __init__(self, name: str):
        self.name = name # name of node
        # Edge list also known as adjacency list
        # List containing not only neighbour nodes but also its edges
        # Necessary due to distance attribute. I might write and article as to why this is so
        self.edge_list: List[Edge] = []
        self.distance: int = sys.maxsize # We set initial distance from source to infinity or max possible number
        self.predecessor: Node = None # Node that is behind defined node

    def __gt__(self, other):
        return self.distance > other.distance

class Edge:
    """
    Class that defines the link between nodes and the weights between
    """
    def __init__(self, weight: int, start_node: Node, end_node: Node):
        self.weight = weight # Distance between nodes in kilometres
        self.start_node = start_node
        self.end_node = end_node

class DijkstraAlgorithm:
    @staticmethod
    def find_shortest_path(graph: List[Node], start_node: Node, end_node: Node):
        """
        Finds the shortest path between start node and end_node
        Prints out distance and path to end node from start node
        """
        q = []
        start_node.distance = 0
        heapq.heappush(q, start_node)

        while len(q) > 0:
            actual_node = heapq.heappop(q)

            for edge in actual_node.edge_list:
                u = edge.start_node
                v = edge.end_node

                temp_dist = u.distance + edge.weight

                if temp_dist < v.distance:
                    v.distance = temp_dist
                    v.predecessor = u
                    heapq.heappush(q, v)

        print(f"Shortest Distance to {end_node.name} is {end_node.distance}")

        print(f"Path: ")
        while end_node is not None:
            print(f"{end_node.name}")
            end_node = end_node.predecessor


# Creating a graph representing distance between 6 towns and cities in Kenya
NBI = Node("Nairobi")
NKS = Node("Nakuru")
NRK = Node("Narok")
KSI = Node("Kisii")
KSM = Node("Kisumu")
HBAY = Node("Homa Bay")

NBI_NKS = Edge(158, NBI, NKS)
NBI_NRK = Edge(142, NBI, NRK)
NKS_NRK = Edge(118, NKS, NRK)
NRK_KSI = Edge(165, NRK, KSI)
NKS_KSM = Edge(183, NKS, KSM)
KSM_KSI = Edge(106, KSM, KSI)
KSI_HBAY = Edge(82, KSI, HBAY)
KSM_HBAY = Edge(105, KSM, HBAY)

NBI.edge_list.append(NBI_NKS)
NBI.edge_list.append(NBI_NRK)
NKS.edge_list.append(NKS_NRK)
NKS.edge_list.append(NKS_KSM)
NRK.edge_list.append(NRK_KSI)
KSM.edge_list.append(KSM_KSI)
KSM.edge_list.append(KSM_HBAY)
KSI.edge_list.append(KSI_HBAY)

graph: List[Node] = [NBI, NKS, NRK, KSI, KSM, HBAY]

DijkstraAlgorithm.find_shortest_path(graph, NBI, HBAY)