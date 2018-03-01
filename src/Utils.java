/**
 * @author Oskar
 * @version 1.0
 * created on: 01/03/2018.
 */
public class Utils {

    public static int distance(Coord c1, Coord c2){
        System.out.println("HERE");
        System.out.println(Math.abs(c2.y - c1.y) + Math.abs(c2.x - c1.x));
        return Math.abs(c2.y - c1.y) + Math.abs(c2.x - c1.x);
    }
}
