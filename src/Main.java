import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();
        CampusGraph campusGraph = new CampusGraph();
        boolean running = true;

        while (running) {
            System.out.println("\n===== University Student Record System =====");
            System.out.println("1. Add Student Record");
            System.out.println("2. Update Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Display All Records (Linked List)");
            System.out.println("5. Add Campus Location");
            System.out.println("6. Remove Campus Location");
            System.out.println("7. Add Campus Connection");
            System.out.println("8. Remove Campus Connection");
            System.out.println("9. Display Campus Connections");
            System.out.println("10. BFS Campus Traversal");
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
                case 5:
                    System.out.print("Enter campus location: ");
                    String location = sc.nextLine().trim();

                    if (campusGraph.addLocation(location)) {
                        System.out.println("Campus location added successfully.");
                    } else {
                        System.out.println("Unable to add campus location.");
                    }
                    break;
                
                case 6:
                    System.out.print("Enter campus location to remove: ");
                    String removeLocation = sc.nextLine().trim();

                    if (campusGraph.removeLocation(removeLocation)) {
                        System.out.println("Campus location removed successfully.");
                    } else {
                         System.out.println("Campus location not found.");
                    }
                    break;
                
                case 7:
                    System.out.print("Enter first campus location: ");
                    String locationA = sc.nextLine().trim();

                    System.out.print("Enter second campus location: ");
                    String locationB = sc.nextLine().trim();

                    if (campusGraph.addConnection(locationA, locationB)) {
                        System.out.println("Campus connection added successfully.");
                    } else {
                        System.out.println("Unable to add campus connection.");
                    }
                    break;

                case 8:
                    System.out.print("Enter first campus location: ");
                    String removeA = sc.nextLine().trim();

                    System.out.print("Enter second campus location: ");
                    String removeB = sc.nextLine().trim();

                    if (campusGraph.removeConnection(removeA, removeB)) {
                        System.out.println("Campus connection removed successfully.");
                    } else {
                        System.out.println("Campus connection not found.");
                    }
                    break;

                case 9:
                    
                    System.out.println("\n===== Campus Connections =====");
                    campusGraph.displayConnections();
                    break;

                case 10:
                    System.out.print("Enter starting campus location for BFS: ");
                    String startLocation = sc.nextLine().trim();

                    campusGraph.bfs(startLocation);
                    break;

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
                    break;

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = sc.nextLine().trim();
                    studentList.deleteStudent(deleteId);
                    break;

                case 4:
                    studentList.displayAll();
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