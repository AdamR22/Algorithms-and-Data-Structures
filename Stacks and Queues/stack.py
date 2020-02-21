"""
Stack, data structure that operates on a LIFO basis
Data appended last is also first to go out
"""

class Stack:
    def __init__(self):
        # uses python list to implement stack
        self.stack = []

    def push(self, data: int) -> int:
        # adds stack to list
        self.stack.append(data)
    
    def peek(self) -> int:
        # returns last element in stack
        return self.stack[-1]
    
    def pop(self):
        # removes last item to be added
        self.stack.pop()

    def return_stack_items(self):
        # prints all items in stack
        for i in self.stack:
            print(i)

    def stack_size(self):
        # returns the size of the stack
        return self.stack.__len__()

if __name__ == '__main__':
    stack = Stack()
    stack.push(5)
    stack.push(6)
    stack.push(7)
    stack.push(8)
    stack.return_stack_items()
    print(f"Last item in stack {stack.peek()}")
    print(f"Stack size: {stack.stack_size()}")
