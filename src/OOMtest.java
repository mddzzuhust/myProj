import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMtest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(UUID.randomUUID().toString());
        }
    }
}
