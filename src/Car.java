import java.util.List;

public class Car {
    public int number;
    public Coord position;
    public int time;
    public List<Ride> history;

    public Car(int number, Coord position){
        this.number = number;
        this.position = position;
    }

    public boolean canMakeOnTime(Ride ride){
        int distance = Utils.distance(position, ride.startIntersection);
        int arrival = distance + this.time;
        int tripTime = Utils.distance(ride.startIntersection, ride.finishIntersection);
        if(arrival < arrival + tripTime){
            return true;
        }
        else {
            return false;
        }
    }

    public void move(){

    }
}
