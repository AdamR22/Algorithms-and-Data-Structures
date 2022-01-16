package src;

public class App {
    public static void main(String[] args) throws Exception {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        intStack.push(12);
        intStack.push(87);

        int topOfIntStack = intStack.peek(); // 87
        intStack.pop();
        int newTopOfIntStack = intStack.peek(); // 12

        strStack.push("Hello");
        strStack.push("From the other side");

        String topOfStrStack = strStack.peek(); //From the other side
        strStack.pop();
        String newTopOfStrStack = strStack.peek(); //Hello

        System.out.println(topOfIntStack);
        System.out.println(newTopOfIntStack);
        System.out.println(topOfStrStack);
        System.out.println(newTopOfStrStack);
    }
}
