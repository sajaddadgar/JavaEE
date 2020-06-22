import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        Main main = new Main();
        main.getRoot();
    }

    public String getRoot() throws IOException, URISyntaxException {
        URL u = getClass().getProtectionDomain().getCodeSource().getLocation();
        File f = new File(u.toURI());
        String s = f.getParentFile().getParentFile().getParentFile().getPath();
        System.out.println(s + "\\web\\assets\\image");
        return s + "\\web\\assets\\image";

    }
}
