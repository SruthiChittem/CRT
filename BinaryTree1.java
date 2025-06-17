class Node {
    int val;
    Node left, right;

    public Node(int item) {
        val = item;
        left = right = null;
    }
}

public class BinaryTree1 {
    Node root;

    // Inorder traversal: left -> root -> right
    void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    // Postorder traversal: left -> right -> root
    void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    // Method to count total number of nodes in the tree
    int countNodes(Node node) {
        if (node == null) {
            return 0; // Base case: If the node is null, there are no nodes
        }
        // Count this node + count nodes in the left subtree + count nodes in the right subtree
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
       
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder(tree.root);
        System.out.println();

        // Counting nodes in the tree
        int totalNodes = tree.countNodes(tree.root);
        System.out.println("Total number of nodes in the tree: " + totalNodes);
    }
}
