import java.util.LinkedList;
import java.util.Queue;



public class BinaryNode {
    private int data;
    private BinaryNode left;
    private BinaryNode right;

    private BinaryNode root;

// Конструктор за замовчуванням для класу Binary node
    Tree::Binary_node::Binary_node() {
        data = 0; // Ініціалізуємо дані як 0
        left = nullptr; // Ініціалізуємо лівого нащадка як nullptr
        right = nullptr; // Ініціалізуємо правого нащадка як nullptr
    }

    //
    public BinaryNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }


//Додавання елементу//

    public void add(int data) {
        if (root == null) {
            root = new BinaryNode(data);
        } else {
            add(data, root);
        }
    }

    private void add(int data, BinaryNode node) {
        if (data < node.getData()) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryNode(data));
            } else {
                add(data, node.getLeft());
            }
        } else if (data > node.getData()) {
            if (node.getRight() == null) {
                node.setRight(new BinaryNode(data));
            } else {
                add(data, node.getRight());
            }
        }
    }

    //Знаходження елементу//

    public void find(int data) {
        BinaryNode current = root;
        while (current != null) {
            if (current.getData() == data) {
                return;
            } else if (data < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
    }


    //Метод для виведення дерева на екран//

    public void printTree() {
        printTree(root);
    }
    private void printTree(BinaryNode node) {
        if (node != null) {
            printTree(node.getLeft());
            System.out.print(node.getData() + " ");
            printTree(node.getRight());
        }
    }


    //Видалення елементів//

    public void remove(int value) {
        root = remove(root, value);
    }

    private BinaryNode remove(BinaryNode node, int value) {
        if (node == null) {
            return null;
        }
        if (value == node.getData()) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            int smallestValue = findSmallestValue(node.getRight());
            node.setData(smallestValue);
            node.setRight(remove(node.getRight(), smallestValue));
            return node;
        }
        if (value < node.getData()) {
            node.setLeft(remove(node.getLeft(), value));
            return node;
        }
        node.setRight(remove(node.getRight(), value));
        return node;
    }

    private int findSmallestValue(BinaryNode root) {
        return root.getLeft() == null ? root.getData() : findSmallestValue(root.getLeft());
    }




    //методи для обходу дерева в ширину та глибину//

    public void breadthFirstTraversal() {
        Queue<BinaryNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();
            System.out.print(node.getData() + " ");
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }


    public void depthFirstTraversal() {
        depthFirstTraversal(root);
    }

    private void depthFirstTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        depthFirstTraversal(node.getLeft());
        depthFirstTraversal(node.getRight());
    }
}
