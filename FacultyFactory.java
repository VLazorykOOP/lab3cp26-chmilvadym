import java.util.HashMap;
import java.util.Map;

public class FacultyFactory {

    private static Map<String, Faculty> faculties = new HashMap<>();


    public static Faculty getFaculty(String name) {
        if (!faculties.containsKey(name)) {
            faculties.put(name, new Faculty(name));
        }
        return faculties.get(name);
    }
}
