/**
 * @author Oskar
 * @version 1.0
 * created on: 01/03/2018.
 */
public class Utils {
    public static int distance;

    public void distance(Coord c1, Coord c2){
        this.distance = Math.abs(c2.y - c1.y) + Math.abs(c2.x - c1.x);
    }
}
