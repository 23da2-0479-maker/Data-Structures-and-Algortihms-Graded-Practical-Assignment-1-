public class ServiceQueue {
    private static class Node {
        String studentId;
        String request;
        Node next;
        Node(String studentId, String request) {
            this.studentId = studentId;
            this.request = request;
        }
    }

    private Node front, rear;
    private int size;

    public void enqueue(String studentId, String request) {
        Node node = new Node(studentId, request);
        if (rear == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) return null;
        String result = "Student " + front.studentId + ": " + front.request;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return result;
    }

    public boolean isEmpty() { return front == null; }

    public void display() {
        if (isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        System.out.println("--- Pending Service Requests (first in line first) ---");
        Node current = front;
        int i = 1;
        while (current != null) {
            System.out.println(i++ + ". Student " + current.studentId + ": " + current.request);
            current = current.next;
        }
    }
}