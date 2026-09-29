import java.util.LinkedList;

public class StudentHashTable {
    private static class HashNode {
        String key;
        Student value;

        HashNode(String key, Student value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<HashNode>[] table;
    private int capacity = 20;

    @SuppressWarnings("unchecked")
    public StudentHashTable() {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int getHash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(String key, Student student) {
        int index = getHash(key);
        for (HashNode node : table[index]) {
            if (node.key.equals(key)) {
                node.value = student; // Update existing
                return;
            }
        }
        table[index].add(new HashNode(key, student)); // Add new
    }

    public Student get(String key) {
        int index = getHash(key);
        for (HashNode node : table[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null; // Not found
    }

    public void remove(String key) {
        int index = getHash(key);
        table[index].removeIf(node -> node.key.equals(key));
    }
}
