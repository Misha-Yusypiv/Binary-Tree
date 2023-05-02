public class Main {
    public static void main(String[] args) {

        BinaryNode root = new BinaryNode(5);
        BinaryNode node1 = new BinaryNode(3);
        BinaryNode node2 = new BinaryNode(7);
        BinaryNode node3 = new BinaryNode(1);
        BinaryNode node4 = new BinaryNode(9);
        root.add(6);
        root.find (6);
        System.out.println("Binary Tree:");
        root.printTree();
        root.breadthFirstTraversal();

        root.remove();

        root = new BinaryNode(5);
        root.add(3);
        root.add(7);
        root.add(1);
        root.add(9);

    }


}
