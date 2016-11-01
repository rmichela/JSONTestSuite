import org.apache.juneau.ObjectMap;
import org.apache.juneau.json.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by rmichela on 10/31/16.
 */
public class TestJsonParsing {
    public static boolean isValidJSON(String s) {
        try {
            JsonParser parser = JsonParser.DEFAULT;
            ObjectMap o = parser.parse(s, ObjectMap.class);
            return o != null;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Usage: java TestJSONParsing file.json");
            System.exit(2);
        }

        try {
            String s = new String(Files.readAllBytes(Paths.get(args[0])));
            if(isValidJSON(s)) {
                System.out.println("valid");
                System.exit(0);
            }
            System.out.println("invalid");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("not found");
            System.exit(2);
        }
    }
}
