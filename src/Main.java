import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    //public static final String FILE_NAME = "videos_worth_spreading";
    public static ArrayList<String> fileNames;

    public static void main(String[] args) {
        fileNames = new ArrayList<>();
        fileNames.add("a_example");
        fileNames.add("b_should_be_easy");
        fileNames.add("c_no_hurry");
        fileNames.add("d_metropolis");
        fileNames.add("e_high_bonus");
        try {
            for (String FILE_NAME: fileNames) {
                System.out.println(FILE_NAME);
                List<String> raw = Files.lines(Paths.get("./inputs/" + FILE_NAME + ".in")).collect(Collectors.toList());
                Solution solution = new Solution(raw,FILE_NAME);
                //solution.solve();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
