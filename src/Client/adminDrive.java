package Client;

import java.util.Scanner;

import Entity.Voter;
import MyADT.*;

public class adminDrive {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MyQueue<Voter> queue = new MyQueue<Voter>(10);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n Please select your choice as bellow: ");
            System.out.println("1. Add new user");
            System.out.println("2. Remove existing user");
            System.out.println("3. Change username");
            System.out.println("4. View all users");
            System.out.println("5. Delete all users");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nEnter user ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter username: ");
                    String username = scanner.nextLine();

                    // Check for duplicate user id
                    boolean idExists = false;
                    for (int i = 0; i < queue.size(); i++) {
                        Voter current = queue.dequeue();
                        if (current.getId() == id) {
                            idExists = true;
                        }
                        queue.enqueue(current);
                    }
                    if (idExists) {
                        System.out.println("\nError: User ID already exists");
                        break;
                    }

                    // Create and add user to queue
                    Voter user = new Voter(id, username);
                    try {
                        queue.enqueue(user);
                        System.out.println("\nUser added successfully");
                    } catch (Exception e) {
                        System.out.println("\nError: " + e.getMessage());
                    }
                    break;


                case 2:
                    try {
                        System.out.println("\nEnter user ID to remove: ");
                        int removeId = scanner.nextInt();
                        scanner.nextLine();

                        boolean found = false;
                        for (int i = 0; i < queue.size(); i++) {
                            Voter current = queue.dequeue();
                            if (current.getId() == removeId) {
                                found = true;
                                System.out.println("\nUser with ID " + current.getId() + " and username " + current.getId() + " removed");
                                break;
                            } else {
                                queue.enqueue(current);
                            }
                        }
                        if (!found) {
                            System.out.println("\nUser not found");
                        }
                    } catch (Exception e) {
                        System.out.println("\nError: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("\nEnter user ID to modify: ");
                        int modifyId = scanner.nextInt();
                        scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i < queue.size(); i++) {
                            Voter current = queue.dequeue();
                            if (current.getId() == modifyId) {
                                found = true;
                                System.out.println("\nEnter new username: ");
                                String newUsername = scanner.nextLine();
                                current.setName(newUsername);
                                queue.enqueue(current);
                                System.out.println("\nUser modified successfully");
                                break;
                            } else {
                                queue.enqueue(current);
                            }
                        }
                        if (!found) {
                            System.out.println("\nUser not found");
                        }
                    } catch (Exception e) {
                        System.out.println("\nError: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\nAll users: ");
                    if (queue.isEmpty()) {
                        System.out.println("No users found");
                    } else {
                        for (int i = 0; i < queue.size(); i++) {
                            Voter current = queue.dequeue();
                            System.out.println("ID: " + current.getId() + ", Username: " + current.getName());
                            queue.enqueue(current);
                        }
                    }
                    break;

                case 5:
                    queue.clear();
                    System.out.println("\nAll users cleared successfully");
                    break;

                case 6:
                    exit = true;
                    System.out.println("\nExiting program...");
                    break;

                default:
                    System.out.println("\nInvalid choice, please try again");
            }
        }
        scanner.close();
    }
}
