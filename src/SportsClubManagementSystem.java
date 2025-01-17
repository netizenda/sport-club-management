import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SportsClubManagementSystem {
    // Abstract Sport class
    static abstract class Sport {
        private String name;
        private String type;
        private int numberOfPlayers;

        public Sport(String name, String type, int numberOfPlayers) {
            this.name = name;
            this.type = type;
            this.numberOfPlayers = numberOfPlayers;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getNumberOfPlayers() {
            return numberOfPlayers;
        }

        public abstract void displaySportDetails();

        @Override
        public String toString() {
            return "Sport{name='" + name + "', type='" + type + "', numberOfPlayers=" + numberOfPlayers + '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Sport sport = (Sport) obj;
            return numberOfPlayers == sport.numberOfPlayers &&
                    Objects.equals(name, sport.name) &&
                    Objects.equals(type, sport.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, type, numberOfPlayers);
        }
    }

    static class TeamSport extends Sport {
        private int teamSize;

        public TeamSport(String name, String type, int numberOfPlayers, int teamSize) {
            super(name, type, numberOfPlayers);
            this.teamSize = teamSize;
        }

        public int getTeamSize() {
            return teamSize;
        }

        @Override
        public void displaySportDetails() {
            System.out.println(toString() + ", teamSize=" + teamSize);
        }
    }

    static class IndividualSport extends Sport {
        public IndividualSport(String name, String type, int numberOfPlayers) {
            super(name, type, numberOfPlayers);
        }

        @Override
        public void displaySportDetails() {
            System.out.println(toString() + ", This is an individual sport.");
        }
    }

    static class Athlete {
        private String name;
        private int age;
        private Sport sport;
        private String coach;
        private String trainingSchedule;

        public Athlete(String name, int age, Sport sport, String coach, String trainingSchedule) {
            this.name = name;
            this.age = age;
            this.sport = sport;
            this.coach = coach;
            this.trainingSchedule = trainingSchedule;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Athlete " + name + ", age " + age + ", sport " + sport.getName() +
                    ", "+ coach + ", training Schedule=" + trainingSchedule + " ";
        }
    }

    static class SportsClub {
        private String clubName;
        private String location;
        private List<Athlete> athletes = new ArrayList<>();

        public SportsClub(String clubName, String location) {
            this.clubName = clubName;
            this.location = location;
        }

        public void addAthlete(Athlete athlete) {
            athletes.add(athlete);
        }

        public void displayAllAthletes() {
            System.out.println("Athletes in " + clubName + ":");
            athletes.forEach(System.out::println);
        }

        public Athlete findAthleteByName(String name) {
            return athletes.stream()
                    .filter(athlete -> athlete.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);
        }
    }

    public static void main(String[] args) {
        // sample data
        Sport bjj = new TeamSport("Brazilian Jiu-Jitsu", "Team", 5, 12);
        Sport boxing = new IndividualSport("Boxing", "Individual", 1);

        Athlete athlete1 = new Athlete("Danial", 18, bjj, "Coach Khabib", "Mon/Wed/Fri 10-12 AM");
        Athlete athlete2 = new Athlete("Damir", 19, boxing, "Coach Mike", "Tue/Thu 2-4 PM");
        Athlete athlete3 = new Athlete("Diana", 18, bjj, "Coach Khabib", "Mon/Wed/Fri 10-12 AM");

        SportsClub club = new SportsClub("Tiger Sports Club", "Astana");
        club.addAthlete(athlete1);
        club.addAthlete(athlete2);
        club.addAthlete(athlete3);

        // display all athletes
        club.displayAllAthletes();

        // search for an athlete by name
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
