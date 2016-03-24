import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by gongxijun on 16-3-12.
 */
public class QReadFile {


    private static final Logger logger = LoggerFactory.getLogger(QReadFile.class);

    private BufferedReader bufRead = null;
    private Solution solution = null;

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    /**
     * 初始化
     *
     * @param filePath 读取文件路径
     */
    public void setPathFile(String filePath) {

        try {
            bufRead = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
            logger.error(" exception File ", e);
        }
    }


    /**
     * 解析文件
     *
     * @return 返回结果集合
     */
    Result parseFile() {

        String request;

        try {

            while (null != (request = bufRead.readLine())) {
                //对数据解析，过滤掉""
                String[] urlStr = request.split("\\s+");

                String[] uri = urlStr[1].split("\\?");

                if (uri[0].charAt(0) == '/') {
                    uri[0] = uri[0].substring(1);
                }

                String[] subUri = uri[0].split("/");

                solution.countByRequest();
                solution.countMaxHttp(uri[0]);
                solution.countPostGetNumber(urlStr[0]);
                solution.countClassifyData(subUri[0], uri[0]);

            }
            solution.NOfTopHttp(10);
            solution.countClassify();

        } catch (IOException e) {

            logger.error("exception read ", e);
        }

        return solution.getResult();
    }


}
