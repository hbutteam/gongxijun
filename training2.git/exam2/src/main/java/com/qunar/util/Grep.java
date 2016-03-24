package com.qunar.util;

import com.qunar.Abstract.AbstractFiles;
import com.qunar.Abstract.Greps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by gongxijun on 16-3-17.
 */
public class Grep extends Greps {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private Collection<Object> include_Key;
    private Collection<Object> inData;

    public Collection<Object> getInData() {
        return inData;
    }

    public void SetResult(Collection<Object> result)
    {
        this.inData = result;
    }

    public Grep(){}

    public Grep(Collection<Object> resource) {

        inData = resource;
    }

    public void setInclude_Key(Collection<Object> include_Key) {

        this.include_Key = include_Key;
    }

    public void push(String key) {

        include_Key.add(key);
    }

    @Override
    public void show() {

        if (include_Key.isEmpty()) {
            return;
        }

        for (Object ans : include_Key) {
            String str = (String) ans;
            logger.info(str);
        }
    }

    @Override
    public boolean doParsing(String[] order) {

        if (order.length > 2) {
            //说明有自己的数据源，忽略输入的源
            AbstractFiles fRead = new Files(order[2]);

            try {
                inData = fRead.ReadFile();
            } catch (IOException e) {
                //e.printStackTrace();
                logger.error("前方高能预警！", e);
            }
        }

        if (order.length <= 1 || null == inData || inData.isEmpty()) {
            logger.error("输入格式有误.....!");
            return false;
        }

        include_Key = new ArrayList<Object>();
        for (Object sub : inData) {
            String line = (String) sub;
            int pos;
            int posPre = 0;  //段落前缀
            StringBuffer str;
            String newLine = "";

            while (-1 != (pos = line.indexOf(order[1]))) {

                str = new StringBuffer(line);
                str.insert(pos, COLOR_[0] + "");
                pos += COLOR_[0].length() + order[1].length();
                str.insert(pos, COLOR_[1] + "");
                pos += COLOR_[1].length();
                line = String.valueOf(str);
                newLine += line.substring(0, pos);
                line = line.substring(pos);
                posPre = pos;
            }
            if (posPre > 0) {
                include_Key.add(newLine + line);
            }
        }

        return true;
    }

    @Override
    public Collection<Object> getResult() {
        return include_Key;
    }
}
