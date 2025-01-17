import java.util.ArrayList;
import java.util.List;

public class SportsClub {
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
