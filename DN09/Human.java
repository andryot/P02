package P02.DN09;

public class Human {
    boolean isInfected, hasSymptoms;
    Position position;
    Behavior behavior;
    Human(int x, int y, boolean isInfected, boolean hasSymptoms, Behavior behavior){
        this.position = new Position(x, y);
        this.isInfected = isInfected;
        this.hasSymptoms = hasSymptoms;
        this.behavior = behavior;
    }
}
