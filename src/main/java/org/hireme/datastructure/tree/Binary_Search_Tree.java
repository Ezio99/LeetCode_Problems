package org.hireme.datastructure.tree;

public class Binary_Search_Tree<T extends Comparable<T>> {

    private class Node {
        private T value;
        private Node leftChild;
        private Node rightChild;

        public Node(T value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    Node root;

    public Binary_Search_Tree(Node root) {
        this.root = root;
    }

    public void insertNode(T data) {
        if(root==null){
            root=new Node(data, null, null);
            return;
        }
        addToTree(root, data);
    }

    private Node addToTree(Node current, T data) {
        if (current == null) {
            current = new Node(data, null, null);

        } else {
            //If current is greater than data go to left subtree
            if (current.getValue().compareTo(data) > 0) {
                current.leftChild = addToTree(current.leftChild, data);
            } else {
                //Putting duplicate values in the right subtree
                current.rightChild = addToTree(current.rightChild, data);
            }
        }

        return current;

    }

    public boolean containsData(T data) {
        return findDataIter(root, data) != null;
    }

    private Node findData(Node node, T data) {
        if (node == null)
            return null;

        int cmp = node.getValue().compareTo(data);

        if (cmp < 0) {
            return findData(node.getRightChild(), data);
        } else if (cmp > 0) {
            return findData(node.getLeftChild(), data);
        } else {
            return node;
        }
    }

    private Node findDataIter(Node node, T data) {
        Node currentNode = node;
        while (currentNode != null) {

            //Negative if current is less than data
            int cmp = currentNode.getValue().compareTo(data);

            if (cmp < 0) {
                currentNode = currentNode.getRightChild();
            } else if (cmp > 0) {
                currentNode = currentNode.getLeftChild();
            } else {
                break;
            }

        }
        return currentNode;
    }

    private Node findMin(Node node) {
        Node minNode = node;
        while (minNode.getLeftChild() != null) {
            minNode = minNode.getLeftChild();
        }

        return minNode;
    }

    private Node findMax(Node node) {
        Node maxNode = node;
        while (maxNode.getRightChild() != null) {
            maxNode = maxNode.getRightChild();
        }

        return maxNode;
    }

    private void printTree(Node node, int level) {
        if (node == null) return;

        printTree(node.getRightChild(), level + 1);
        System.out.println("  ".repeat(level) + node.getValue());
        printTree(node.getLeftChild(), level + 1);
    }

    public boolean remove(T data) {

        if (!containsData(data))
            return false;


        boolean res = removeFromTree(root, data) != null;
        printTree(root,4);
        return res;
    }

    private Node removeFromTree(Node node, T data) {
        if (node == null) {
            return null;
        }

        int cmp = node.getValue().compareTo(data);

        if (cmp < 0) {
            node.rightChild = removeFromTree(node.getRightChild(), data);
        } else if (cmp > 0) {
            node.leftChild = removeFromTree(node.getLeftChild(), data);
        } else {
            //If removal node's left child is null set the removal node as what is in right child
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            }

            if (node.getRightChild() == null) {
                return node.getLeftChild();
            }

            //Has both children
            Node minNodeInRight = findMin(node.getRightChild());
            node.setValue(minNodeInRight.getValue());
            //This is only required for the case where the immediate child is being removed because we need its parent
            //(current node) to set the reference to null. In other cases the earlier 2 ifs are fine
            node.rightChild = removeFromTree(node.getRightChild(),node.getValue());
        }

        return node;

    }

}
