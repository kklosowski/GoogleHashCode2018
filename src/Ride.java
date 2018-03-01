/**
 * @author Oskar
 * @version 1.0
 * created on: 01/03/2018.
 */
public class Ride {
    public Coord startIntersection;
    public Coord finishIntersection;
    public int earliestStart;
    public int latestFinish;

    public Ride(Coord startIntersection, Coord finishIntersection, int earliestStart, int latestFinish) {
        this.startIntersection = startIntersection;
        this.finishIntersection = finishIntersection;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }
}
