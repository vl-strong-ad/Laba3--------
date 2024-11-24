package ua.Geography;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandParser commandParser = new CommandParser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter command:");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            commandParser.executeCommand(command);
            System.out.println("Enter next command:");
        }
        scanner.close();
    }
}
