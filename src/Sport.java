import java.util.Objects;

public abstract class Sport {
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
