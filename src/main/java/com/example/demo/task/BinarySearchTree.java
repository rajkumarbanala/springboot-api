package com.example.demo.task;

public class BinarySearchTree {
    public static void main(String[] args) {
        Node node1 = new Node(40);
        node1.setRight(new Node(60));

        Node rootLeft = new Node(30);
        rootLeft.setLeft(new Node(20));
        rootLeft.setRight(node1);

        Node rootRight = new Node(70);
        rootRight.setRight(new Node(80));

        Node root = new Node(50);
        root.setLeft(rootLeft);
        root.setRight(rootRight);

        display(root);

        int result = binarySearchTree(root, 80);
        if (result != -1) {
            System.out.println("Value Found:" + result);
        } else {
            System.out.println("Value Not Found:" + result);
        }
    }

    public static int binarySearchTree(Node root, int target) {
        if (root == null) {
            return -1;
        }

        if (root.getValue() == target) {
            return target;
        }

        // for sorted tree
        if (target < root.getValue()) {
            // left search
            if (root.getLeft() != null) {
                return binarySearchTree(root.getLeft(), target);
            }
        } else if (target > root.getValue()) {
            // right search
            if (root.getRight() != null) {
                return binarySearchTree(root.getRight(), target);
            }
        }

        // ========================== OR ===========================
        // for unsorted tree
        if (root.getLeft() != null) {
            int result = binarySearchTree(root.getLeft(), target);
            if (result == target) {
                return result;
            }
        }
        if (root.getRight() != null) {
            int result = binarySearchTree(root.getRight(), target);
            if (result == target) {
                return result;
            }
        }
        return -1;
    }

    public static void display(Node root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return;
        }
        int left = 0;
        int right = 0;
        if (root.getLeft() != null) {
            left = root.getLeft().getValue();
        }
        if (root.getRight() != null) {
            right = root.getRight().getValue();
        }
        StringBuffer sb = new StringBuffer();
        sb.append("node=" + root.getValue());
        if (left != 0 && right != 0) {
            sb.append(" ,left=" + left);
            sb.append(" ,right=" + right);
        } else if (left != 0 && right == 0) {
            sb.append(" ,left=" + left);
        } else if (right != 0 && left == 0) {
            sb.append(" ,right=" + right);
        }
        System.out.println(sb);
        display(root.getLeft());
        display(root.getRight());
    }
}

