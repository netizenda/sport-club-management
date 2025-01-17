import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sample data
        Sport bjj = new TeamSport("Brazilian Jiu-Jitsu", "Team", 5, 12);
        Sport boxing = new IndividualSport("Boxing", "Individual", 1);

        Athlete athlete1 = new Athlete("Danial", 18, bjj, "Coach Khabib", "Mon/Wed/Fri 10-12 AM");
        Athlete athlete2 = new Athlete("Damir", 19, boxing, "Coach Mike", "Tue/Thu 2-4 PM");
        Athlete athlete3 = new Athlete("Diana", 18, bjj, "Coach Khabib", "Mon/Wed/Fri 10-12 AM");

        SportsClub club = new SportsClub("Tiger Sports Club", "Astana");
        club.addAthlete(athlete1);
        club.addAthlete(athlete2);
        club.addAthlete(athlete3);

        // Display all athletes
        club.displayAllAthletes();

        // Search for an athlete by name
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the name of the athlete you want to search for: ");
        String searchName = scanner.nextLine();
        Athlete foundAthlete = club.findAthleteByName(searchName);

        if (foundAthlete != null) {
            System.out.println("\nAthlete Details:");
            System.out.println(foundAthlete);
        } else {
            System.out.println("\nAthlete with name '" + searchName + "' not found.");
        }

        scanner.close();
    }
}
