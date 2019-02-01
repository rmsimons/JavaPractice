
import java.io.File;
import java.util.List;
import java.util.function.Function;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alex
 */
public class HTMLUtils {

    public static String managerToString(HTMLManager manager) {
        List<HTMLTag> tags = manager.getTags();
        String result = "";
        for (HTMLTag tag : tags) {
            result += tag.toString().replaceAll("\\s","");
        }
        return result;
    }

    public static HTMLManager pageToManager(String path) {
        HTMLParser parser = new HTMLParser(new File(path));
        return new HTMLManager(parser.parse());
    }

    public static boolean equalsAfterOperation(HTMLManager reference, HTMLManager target, Function<HTMLManager, HTMLManager> operation) {
        return managerToString(reference).equals(managerToString(operation.apply(target)));
    }
}
