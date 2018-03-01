import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution {
    public final String FILE_NAME;
    private final List<String> raw;

    public int rows;
    public int columns;
    public int vehicles;
    public int rides;
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
        rides = params[3];
        bonus = params[4];
        steps = params[5];
        

        /*
        cacheCapacities = IntStream.generate(() -> params[4]).limit(params[3]).toArray();
        this.cacheVideoAssignments = new HashMap<>();
        */
    }
}
