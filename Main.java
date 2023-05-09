import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryNode root = new BinaryNode(5);
        BinaryNode node1 = new BinaryNode(3);
        BinaryNode node2 = new BinaryNode(7);
        BinaryNode node3 = new BinaryNode(1);
        BinaryNode node4 = new BinaryNode(9);
        root.add(node2.getData());
        root.find(node2.getData());
        System.out.println("Binary Tree:");
        root.printTree();
        root.breadthFirstTraversal();



        root = new BinaryNode(5);
        root.add(node1.getData());
        root.add(node2.getData());
        root.add(node3.getData());
        root.add(node4.getData());

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Введіть команду (add, remove, breadthFirstSearch, depthFirstSearch):");
            input = scanner.nextLine();

            switch (input) {
                case "add" -> {
                    System.out.println("Введіть значення:");
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    BinaryNode newNode = new BinaryNode(value);
                    root.add(newNode.getData());
                }
                case "remove" -> {
                    System.out.println("Введіть значення:");
                    int value = scanner.nextInt();
                    scanner.nextLine();
                    root.remove(value);
                }
                case "breadthFirstSearch" -> root.breadthFirstTraversal();
                case "depthFirstSearch" -> root.depthFirstTraversal();
                default -> System.out.println("Невідома команда.");
            }
        }

    }
}

