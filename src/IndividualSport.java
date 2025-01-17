public class IndividualSport extends Sport {
    public IndividualSport(String name, String type, int numberOfPlayers) {
        super(name, type, numberOfPlayers);
    }

    @Override
    public void displaySportDetails() {
        System.out.println(toString() + ", This is an individual sport.");
    }
}
