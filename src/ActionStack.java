public class ActionStack {
    private static class Node {
        String action;
        Node next;
        Node(String action) { this.action = action; }
    }

    private Node top;
    private int size;

    public void push(String action) {
        Node node = new Node(action);
        node.next = top;
        top = node;
        size++;
    }

    public String pop() {
        if (isEmpty()) return null;
        String action = top.action;
        top = top.next;
        size--;
        return action;
    }

    public String peek() {
        return isEmpty() ? null : top.action;
    }

    public boolean isEmpty() { return top == null; }

    public void display() {
        if (isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }
        System.out.println("--- Recent Actions (latest first) ---");
        Node current = top;
        int i = 1;
        while (current != null) {
            System.out.println(i++ + ". " + current.action);
            current = current.next;
        }
    }
}