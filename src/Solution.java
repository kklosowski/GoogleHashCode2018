import java.util.*;

public class Solution {
    public final String FILE_NAME;
    private final List<String> raw;

    public int rows;
    public int columns;
    public int vehicles;
    public int ridesNo;
    public int bonus;
    public int steps;

    public Map<Integer, Ride> rides;

    public int[] params;

    public Solution(List<String> raw, String filename) {
        this.FILE_NAME = filename;
        this.raw = raw;
        params = Arrays.stream(raw.get(0).split(" ")).mapToInt(Integer::valueOf).toArray();

        rows = params[0];
        columns = params[1];
        vehicles = params[2];
        ridesNo = params[3];
        bonus = params[4];
        steps = params[5];

        for (int i = 0; i < ridesNo; i++) {
            int[] rideData = Arrays.stream(raw.get(0).split(" ")).mapToInt(Integer::valueOf).toArray();

            Coord c1  = new Coord(rideData[0], rideData[1]);
            Coord c2 = new Coord(rideData[2], rideData[3]);

            rides.put(i, new Ride(c1,c2,rideData[4],rideData[5]));
        }
    }

    public Car getClosestCar(Coord c){
        return cars.stream().sorted(Comparator.comparing(x -> Utils.distance(x.position, c))).findFirst().orElseGet(null);
    }
}
