/**
 * @author Oskar
 * @version 1.0
 * created on: 01/03/2018.
 */
public class Utils {

    public static int distance(Coord c1, Coord c2){
        return Math.abs(c2.y - c1.y) + Math.abs(c2.x - c1.x);
    }

    public static int getArrivalTimeFor(Car car, Ride ride){
        return distance(car.position, ride.startIntersection) + car.time;
    }

    public static int score(Car car, Ride ride, int bonus){
        int result = 0;
        if(car.canMakeOnTime(ride)) {
            result = distance(ride.startIntersection, ride.finishIntersection);
            if(ride.earliestStart == Utils.getArrivalTimeFor(car, ride)){
                result += bonus;
            }
        }
        return result;
    }
}
