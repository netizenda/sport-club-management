public class Athlete {
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
                ", " + coach + ", training Schedule=" + trainingSchedule + " ";
    }
}
