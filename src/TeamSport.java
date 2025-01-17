public class TeamSport extends Sport {
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
