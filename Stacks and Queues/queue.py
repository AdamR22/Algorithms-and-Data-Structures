"""
Queue is another data structure.
Its similar to a queue in a bank or a bus station
Works using the FIFO operation
First in First out
"""

class Queue:
    def __init__(self):
        self.queue = []
    
    def enqueue(self, data: int):
        # adds item to queue
        self.queue.append(data)

    def dequeue(self):
        # removes first item from queue
        self.queue.remove(self.queue[0])

    def traverse(self):
        # prints values stored in queue 
        for i in self.queue:
            print(i)

    def return_queue_size(self) -> int:
        # returns number of items in queue
        return self.queue.__len__()

if __name__ == '__main__':
    queue = Queue()
    queue.enqueue(4)
    queue.enqueue(5)
    queue.enqueue(6)
    queue.traverse()
    print(f"Size of queue before dequeing: {queue.return_queue_size()}")
    queue.dequeue()
    print(f"Size of queue after dequeing: {queue.return_queue_size()}")
    print("Items after dequeing: ")
    queue.traverse()