

/**
 * Created by gongxijun on 16-3-12.
 */

public class Main {


    public static void main(String[] args) {

        String filePath = "access/resource/access.log"; //相对路径

        QReadFile qRead = new QReadFile();
        qRead.setPathFile(filePath);
        qRead.setSolution(new AccessSolution());
        qRead.parseFile().show();
    }
}
