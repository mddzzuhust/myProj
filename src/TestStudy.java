import java.util.ArrayList;
import java.util.List;

public class TestStudy {

    static class OOMClass { }

    public static void main(String[] args) {
        List<OOMClass> list = new ArrayList<OOMClass>();
        while(true) {
            list.add(new OOMClass());
        }
    }

}