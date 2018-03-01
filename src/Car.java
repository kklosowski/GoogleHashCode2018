import java.util.ArrayList;
import java.util.List;

public class Car {
    public int number;
    public Coord position;
    public int time;
    public List<Ride> history;

    public Car(int number, Coord position){
        this.number = number;
        this.position = position;
        this.history = new ArrayList<>();
    }

    public boolean canMakeOnTime(Ride ride){
        int distance = Utils.distance(position, ride.startIntersection);
        int arrival = distance + this.time;
        int tripTime = Utils.distance(ride.startIntersection, ride.finishIntersection);
        if(arrival < ride.latestFinish - tripTime){
            return true;
        }
        else {
            return false;
        }
    }

    public void move(Ride ride){
        int distanceTo = Utils.distance(position, ride.startIntersection);
        int tripTime = Utils.distance(ride.startIntersection, ride.finishIntersection);

        if(distanceTo+this.time <= ride.earliestStart){
            time = ride.earliestStart + tripTime;
        }
        else {
            this.time = time + distanceTo + tripTime;
            this.position = ride.finishIntersection;
        }
        this.history.add(ride);
    }

    public int distTime(Ride ride){
        return Math.abs(ride.earliestStart - time - Utils.distance(position, ride.startIntersection));
    }
}
