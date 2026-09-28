import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();
        ActionStack actions = new ActionStack();          // MEMBER 2
        ServiceQueue requests = new ServiceQueue();       // MEMBER 2
        boolean running = true;

        while (running) {
            System.out.println("\n===== University Student Record System =====");
            System.out.println("1. Add Student Record");
            System.out.println("2. Update Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Display All Records (Linked List)");
            System.out.println("5. Add Service Request to Queue");          // MEMBER 2
            System.out.println("6. Process Next Service Request");          // MEMBER 2
            System.out.println("7. Display Recent Actions using Stack");    // MEMBER 2
            System.out.println("16. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Programme: ");
                    String programme = sc.nextLine().trim();
                    System.out.print("Enter Marks: ");
                    double marks;
                    try {
                        marks = Double.parseDouble(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks. Must be a number.");
                        break;
                    }
                    studentList.addStudent(id, name, programme, marks);
                    actions.push("Added student " + id);                   // MEMBER 2
                    break;

                case 2:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = sc.nextLine().trim();
                    System.out.print("New Name (leave blank to skip): ");
                    String newName = sc.nextLine().trim();
                    System.out.print("New Programme (leave blank to skip): ");
                    String newProgramme = sc.nextLine().trim();
                    System.out.print("New Marks (leave blank to skip): ");
                    String marksInput = sc.nextLine().trim();

                    Double newMarks = null;
                    if (!marksInput.isEmpty()) {
                        try {
                            newMarks = Double.parseDouble(marksInput);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid marks. Update skipped for marks.");
                        }
                    }
                    studentList.updateStudent(updateId,
                            newName.isEmpty() ? null : newName,
                            newProgramme.isEmpty() ? null : newProgramme,
                            newMarks);
                    actions.push("Updated student " + updateId);           // MEMBER 2
                    break;

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = sc.nextLine().trim();
                    studentList.deleteStudent(deleteId);
                    actions.push("Deleted student " + deleteId);           // MEMBER 2
                    break;

                case 4:
                    studentList.displayAll();
                    break;

                case 5:                                                    // MEMBER 2
                    System.out.print("Enter Student ID: ");
                    String reqStudentId = sc.nextLine().trim();
                    System.out.print("Enter Request: ");
                    String reqText = sc.nextLine().trim();
                    if (reqStudentId.isEmpty() || reqText.isEmpty()) {
                        System.out.println("Invalid input. Fields cannot be empty.");
                    } else {
                        requests.enqueue(reqStudentId, reqText);
                        actions.push("Added service request for " + reqStudentId);
                        System.out.println("Request added to queue.");
                    }
                    break;

                case 6:                                                    // MEMBER 2
                    String processed = requests.dequeue();
                    if (processed == null) {
                        System.out.println("No requests to process.");
                    } else {
                        System.out.println("Processing: " + processed);
                        actions.push("Processed request - " + processed);
                    }
                    break;

                case 7:                                                    // MEMBER 2
                    actions.display();
                    break;

                case 16:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}