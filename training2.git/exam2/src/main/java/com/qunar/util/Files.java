package com.qunar.util;

import com.qunar.Abstract.AbstractFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongxijun on 16-3-17.
 */
public class Files implements AbstractFiles {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String pathFileName;

    public Files(String pathFile) {
        if (pathFile.isEmpty())
            logger.error("文件名不正确！");
        this.pathFileName = pathFile;
    }

    public String getPathFileName() {
        return pathFileName;
    }

    public void setPathFileName(String pathFile) {
        this.pathFileName = pathFile;
    }

    /**
     * 读取文件
     *
     * @return 返回读取内容
     */
    @Override
    public List<Object> ReadFile() {

        BufferedReader bufRead;
        List<Object> tmpData = new ArrayList<Object>();
        String data;

        try {
            File file = new File(pathFileName);
            if (!file.exists()) {
                logger.error("读取文件不存在,文件路径为:", pathFileName);
                return tmpData;
            }
            FileInputStream fileinputStream = new FileInputStream(pathFileName);
            bufRead = new BufferedReader(new InputStreamReader(fileinputStream));
            while (null != (data = bufRead.readLine())) {
                tmpData.add(data);
            }
            bufRead.close();
        } catch (IOException e) {
            logger.error(" exception File ", e);
        }

        return tmpData;
    }
}
