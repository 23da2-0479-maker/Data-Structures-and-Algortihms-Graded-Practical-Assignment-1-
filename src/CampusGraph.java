import java.util.*;

public class CampusGraph {
    private final Map<String, Set<String>> adjacencyList = new LinkedHashMap<>();

    public boolean addLocation(String location) {
        if (location == null || location.trim().isEmpty()) return false;
        if (adjacencyList.containsKey(location)) return false;
        adjacencyList.put(location, new LinkedHashSet<>());
        return true;
    }

    public boolean removeLocation(String location) {
        if (!adjacencyList.containsKey(location)) return false;
        adjacencyList.remove(location);
        for (Set<String> neighbours : adjacencyList.values()) {
            neighbours.remove(location);
        }
        return true;
    }

    public boolean addConnection(String a, String b) {
        if (a.equals(b)) return false;
        if (!adjacencyList.containsKey(a) || !adjacencyList.containsKey(b)) return false;
        if (adjacencyList.get(a).contains(b)) return false;

        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
        return true;
    }

    public boolean removeConnection(String a, String b) {
        if (!adjacencyList.containsKey(a) || !adjacencyList.containsKey(b)) return false;
        boolean removedA = adjacencyList.get(a).remove(b);
        boolean removedB = adjacencyList.get(b).remove(a);
        return removedA || removedB;
    }

    public void displayConnections() {
        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations.");
            return;
        }
        for (Map.Entry<String, Set<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " +
                    (entry.getValue().isEmpty() ? "No connections" : String.join(", ", entry.getValue())));
        }
    }

    public void bfs(String start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);

        System.out.print("BFS traversal: ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current);
            if (!queue.isEmpty()) System.out.print(" -> ");

            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
        System.out.println();
    }
}
// Campus graph implementation