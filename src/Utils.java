/**
 * @author Oskar
 * @version 1.0
 * created on: 01/03/2018.
 */
public class Utils {
    public static int distance;

    public void distance(Coord c1, Coord c2){
        this.distance = (c2.y - c1.y) + (c2.x - c1.x);
    }
}
