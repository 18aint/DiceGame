// Superbowl.java
public class Superbowl {
    private String date;
    private String number;
    private String winningTeam;
    private int winningScore;
    private String losingTeam;
    private int losingScore;
    private String mvp;
    private String stadium;
    private String city;
    private String state;
    private int year;

    public Superbowl(String date, String number, String winningTeam, int winningScore,
                     String losingTeam, int losingScore, String mvp, String stadium,
                     String city, String state) {
        this.date = date;
        this.number = number;
        this.winningTeam = winningTeam;
        this.winningScore = winningScore;
        this.losingTeam = losingTeam;
        this.losingScore = losingScore;
        this.mvp = mvp;
        this.stadium = stadium;
        this.city = city;
        this.state = state;
        this.year = Integer.parseInt(date.substring(0, 4));
    }

    // Getters
    public int getYear() { return year; }
    public String getWinningTeam() { return winningTeam; }
    public String getLosingTeam() { return losingTeam; }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Super Bowl %s (%s)%n", number, date));
        sb.append(String.format("Winner: %s (%d points)%n", winningTeam, winningScore));
        sb.append(String.format("Loser: %s (%d points)%n", losingTeam, losingScore));
        sb.append(String.format("MVP: %s%n", mvp));
        sb.append(String.format("Location: %s, %s, %s", stadium, city, state));
        return sb.toString();
    }
}

// SuperbowlManager.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperbowlManager {
    private List<Superbowl> superbowls;
    private Scanner scanner;

    public SuperbowlManager() {
        superbowls = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadData();
    }

    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("superbowls.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                superbowls.add(new Superbowl(
                    parts[0],            // date
                    parts[1],            // number
                    parts[2],            // winning team
                    Integer.parseInt(parts[3]), // winning score
                    parts[4],            // losing team
                    Integer.parseInt(parts[5]), // losing score
                    parts[6],            // MVP
                    parts[7],            // stadium
                    parts[8],            // city
                    parts[9]             // state
                ));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
    }

    public void displayMenu() {
        while (true) {
            System.out.println("-----------------------");
            System.out.println("NFL Superbowls menu");
            System.out.println("-----------------------");
            System.out.println("List .................1");
            System.out.println("Select ...............2");
            System.out.println("Search................3");
            System.out.println("Exit..................0");
            System.out.println("-----------------------");
            System.out.print("Enter choice:> ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 0:
                    System.out.println("Goodbye!");
                    return;
                case 1:
                    listSuperbowls();
                    break;
                case 2:
                    selectSuperbowl();
                    break;
                case 3:
                    searchSuperbowls();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listSuperbowls() {
        for (Superbowl sb : superbowls) {
            System.out.printf("%d: %s vs %s%n", 
                sb.getYear(), sb.getWinningTeam(), sb.getLosingTeam());
        }
    }

    private void selectSuperbowl() {
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Superbowl sb : superbowls) {
            if (sb.getYear() == year) {
                System.out.println(sb.toString());
                return;
            }
        }
        System.out.println("No Super Bowl found for year " + year);
    }

    private void searchSuperbowls() {
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Superbowl sb : superbowls) {
            if (sb.toString().toLowerCase().contains(searchTerm)) {
                System.out.println(sb.toString());
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matches found for: " + searchTerm);
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        SuperbowlManager manager = new SuperbowlManager();
        manager.displayMenu();
    }
}