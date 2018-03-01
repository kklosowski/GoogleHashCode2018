import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public final String FILE_NAME;
    private final List<String> raw;

    public int rows;
    public int columns;
    public int vehicles;
    public int bonus;
    public int steps;

    public List<Ride> rides = new ArrayList<>();
    public List<Car> cars = new ArrayList<>();

    public int[] params;

    public Solution(List<String> raw, String filename) {
        this.FILE_NAME = filename;
        this.raw = raw;
        params = Arrays.stream(raw.get(0).split(" ")).mapToInt(Integer::valueOf).toArray();

        rows = params[0];
        columns = params[1];
        vehicles = params[2];
        bonus = params[4];
        steps = params[5];

        for (int j = 0; j < vehicles; j++) {
            cars.add(j, new Car(j, new Coord(0, 0)));
        }

        for (int i = 0; i < params[3]; i++) {
            int[] rideData = Arrays.stream(raw.get(0).split(" ")).mapToInt(Integer::valueOf).toArray();
            rides.add(i, new Ride(i, new Coord(rideData[0], rideData[1]), new Coord(rideData[2], rideData[3]), rideData[4], rideData[5]));
        }
    }

    public List<Car> getCarsByDistance(Coord c) {
        return cars.stream()
                .sorted(Comparator.comparing(x -> Utils.distance(x.position, c)))
                .collect(Collectors.toList());
    }

    public Car getBestCarForARide(Ride ride) {
        return getCarsByDistance(ride.startIntersection).stream()
                .filter(x -> x.canMakeOnTime(ride))
                .findFirst()
                .orElse(null);
    }

    public void distributeRides() {
        List<Ride> copy = new ArrayList<>(rides);
        copy.stream()
                .sorted(Comparator.comparing(x -> x.earliestStart))
                .forEach(x -> {
                    Car car = getBestCarForARide(x);
                    if (car != null) {
                        car.move(x);
                        rides.remove(x);
                    }
                });
    }

    public void solve(){
        distributeRides();
        printToFile(cars);
    }

    public void printToFile(List<Car> cars) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("./src/" + FILE_NAME + ".out");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            cars.stream().forEach(c -> {
                List<Ride> history = c.history;
                printWriter.print(c.history.size());
                history.stream().forEach(y -> {
                    printWriter.print(" " + y.rideId);
                });
                printWriter.print("\n");
            });

            printWriter.close(); //Saving the data
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
