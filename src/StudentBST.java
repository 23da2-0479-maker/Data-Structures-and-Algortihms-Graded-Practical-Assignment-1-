public class StudentBST {
    private class Node {
        Student data;
        Node left, right;

        Node(Student data) {
            this.data = data;
        }
    }

    private Node root;

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node root, Student student) {
        if (root == null) {
            return new Node(student);
        }
        if (student.getStudentId().compareTo(root.data.getStudentId()) < 0) {
            root.left = insertRec(root.left, student);
        } else if (student.getStudentId().compareTo(root.data.getStudentId()) > 0) {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    public void delete(String studentId) {
        root = deleteRec(root, studentId);
    }

    private Node deleteRec(Node root, String studentId) {
        if (root == null) {
            return root;
        }

        if (studentId.compareTo(root.data.getStudentId()) < 0) {
            root.left = deleteRec(root.left, studentId);
        } else if (studentId.compareTo(root.data.getStudentId()) > 0) {
            root.right = deleteRec(root.right, studentId);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data.getStudentId());
        }
        return root;
    }

    private Student minValue(Node root) {
        Student minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No students in the BST to display.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data);
            inOrderRec(root.right);
        }
    }
}
