import java.util.ArrayList;

public class Moodle {
    public static void main(String[] args) {
        ArrayList<FromSoftwareGame> games = new ArrayList<>();
        games.add(new Sekiro(45, 130, true, true));
        games.add(new EldenRing(120, 200, false, true));
        games.add(new DemonSouls(30, 90, false, false));
        games.add(new Bloodborne(60, 150, true, true));

        System.out.println("FROM SOFTWARE GAMES SUMMARY:");
        System.out.println(" ");

        for (FromSoftwareGame game : games) {
            game.displayDetails();
            System.out.println("------------------------");
        }
    }
}

//Parent
class FromSoftwareGame {
    String name;
    int hoursPlayed;
    int deaths;
    boolean dlcDone;
    boolean gameDone;

    public FromSoftwareGame(String name, int hoursPlayed, int deaths, boolean dlcDone, boolean gameDone) {
        this.name = name;
        this.hoursPlayed = hoursPlayed;
        this.deaths = deaths;
        this.dlcDone = dlcDone;
        this.gameDone = gameDone;
    }

    public void displayDetails() {
        System.out.println("Game: " + name);
        System.out.println("Hours Played: " + hoursPlayed);
        System.out.println("Deaths: " + deaths);
        System.out.println("DLC Completed: " + dlcDone);
        System.out.println("Game Beaten: " + gameDone);
    }

    public double calculateDeathsPerHour() {
        return (hoursPlayed == 0) ? 0 : (double) deaths / hoursPlayed;
    }
}

//Childeren:
class Sekiro extends FromSoftwareGame {
    public Sekiro(int hoursPlayed, int deaths, boolean dlcDone, boolean gameDone) {
        super("Sekiro", hoursPlayed, deaths, dlcDone, gameDone);
    }

    @Override
    public void displayDetails() {
        System.out.println("Sekiro: Shadows Die Twice");
        super.displayDetails();
    }

    @Override
    public double calculateDeathsPerHour() {
        return (double) deaths / (hoursPlayed + 5);
    }
}

class EldenRing extends FromSoftwareGame {
    public EldenRing(int hoursPlayed, int deaths, boolean dlcDone, boolean gameDone) {
        super("Elden Ring", hoursPlayed, deaths, dlcDone, gameDone);
    }

    @Override
    public void displayDetails() {
        System.out.println("Elden Ring");
        super.displayDetails();
    }

    @Override
    public double calculateDeathsPerHour() {
        return (double) deaths / (hoursPlayed + 10);
    }
}

class DemonSouls extends FromSoftwareGame {
    public DemonSouls(int hoursPlayed, int deaths, boolean dlcDone, boolean gameDone) {
        super("Demon's Souls", hoursPlayed, deaths, dlcDone, gameDone);
    }

    @Override
    public void displayDetails() {
        System.out.println("Demon's Souls");
        super.displayDetails();
    }

    @Override
    public double calculateDeathsPerHour() {
        return (double) deaths / hoursPlayed;
    }
}

class Bloodborne extends FromSoftwareGame {
    public Bloodborne(int hoursPlayed, int deaths, boolean dlcDone, boolean gameDone) {
        super("Bloodborne", hoursPlayed, deaths, dlcDone, gameDone);
    }

    @Override
    public void displayDetails() {
        System.out.println("Bloodborne");
        super.displayDetails();
    }

    @Override
    public double calculateDeathsPerHour() {
        return deaths / (double) (hoursPlayed + 3);
    }
}