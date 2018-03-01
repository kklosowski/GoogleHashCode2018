/**
 * @author Oskar
 * @version 1.0
 * created on: 01/03/2018.
 */
public class Ride {
    public int rideId;
    public Coord startIntersection;
    public Coord finishIntersection;
    public int earliestStart;
    public int latestFinish;

    public Ride(int rideId, Coord startIntersection, Coord finishIntersection, int earliestStart, int latestFinish) {
        this.rideId = rideId;
        this.startIntersection = startIntersection;
        this.finishIntersection = finishIntersection;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }
}
