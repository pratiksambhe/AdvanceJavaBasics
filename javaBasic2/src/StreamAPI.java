import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {

List<Integer> l= Arrays.asList(12,3,34,3,2,1);
        Map<Boolean, List<Integer>> map = l.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(map.get(false));
    }

}
