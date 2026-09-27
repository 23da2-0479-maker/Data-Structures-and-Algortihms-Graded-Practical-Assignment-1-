public class StudentLinkedList {
    private Node head;
    private int size;

    public StudentLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean addStudent(String studentId, String name, String programme, double marks) {
        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Error: Student ID cannot be empty.");
            return false;
        }
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return false;
        }
        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks must be between 0 and 100.");
            return false;
        }
        if (searchById(studentId) != null) {
            System.out.println("Error: A student with ID " + studentId + " already exists.");
            return false;
        }

        Node newNode = new Node(new Student(studentId, name, programme, marks));

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Student added successfully: " + studentId);
        return true;
    }

    public boolean updateStudent(String studentId, String newName, String newProgramme, Double newMarks) {
        Student student = searchById(studentId);
        if (student == null) {
            System.out.println("Error: No student found with ID " + studentId);
            return false;
        }
        if (newMarks != null && (newMarks < 0 || newMarks > 100)) {
            System.out.println("Error: Marks must be between 0 and 100.");
            return false;
        }

        if (newName != null && !newName.trim().isEmpty()) {
            student.setName(newName);
        }
        if (newProgramme != null && !newProgramme.trim().isEmpty()) {
            student.setProgramme(newProgramme);
        }
        if (newMarks != null) {
            student.setMarks(newMarks);
        }
        System.out.println("Student updated successfully: " + studentId);
        return true;
    }

    public Student deleteStudent(String studentId) {
        if (head == null) {
            System.out.println("Error: No records to delete.");
            return null;
        }

        if (head.data.getStudentId().equals(studentId)) {
            Student removed = head.data;
            head = head.next;
            size--;
            System.out.println("Student deleted: " + studentId);
            return removed;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getStudentId().equals(studentId)) {
                Student removed = current.next.data;
                current.next = current.next.next;
                size--;
                System.out.println("Student deleted: " + studentId);
                return removed;
            }
            current = current.next;
        }

        System.out.println("Error: No student found with ID " + studentId);
        return null;
    }

    public Student searchById(String studentId) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentId().equals(studentId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public int searchByName(String name) {
        Node current = head;
        int matches = 0;
        while (current != null) {
            if (current.data.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(current.data);
                matches++;
            }
            current = current.next;
        }
        if (matches == 0) {
            System.out.println("No students found matching: " + name);
        }
        return matches;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }
        System.out.println("---- All Student Records (" + size + ") ----");
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}