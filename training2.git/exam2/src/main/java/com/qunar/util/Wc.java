package com.qunar.util;

import com.qunar.Abstract.AbstractFiles;
import com.qunar.Abstract.Wcs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by gongxijun on 16-3-17.
 */
public class Wc extends Wcs {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Collection<Object> orders;
    private Integer numBytes;  //字节数
    private Integer numChars;  //字数
    private Integer numLiens;  //行数
    private int formatType; //输出那种格式  -1： 不打印 0： 全部打印 1： 行数部分

    public Wc() {

        numBytes = 0;
        numChars = 0;
        numLiens = 0;
        formatType = 1;
    }

    public Wc(Collection<Object> order) {

        this.orders = order;
        numBytes = 0;
        numChars = 0;
        numLiens = 0;
        formatType = 1;
    }

    public Integer getNumBytes() {
        return numBytes;
    }

    public void setNumBytes(Integer numBytes) {
        this.numBytes = numBytes;
    }

    public Integer getNumChars() {
        return numChars;
    }

    public void setNumChars(Integer numChars) {
        this.numChars = numChars;
    }

    public void setNumLiens(Integer numLiens) {
        this.numLiens = numLiens;
    }

    public Integer getNumLiens() {
        return numLiens;
    }


    /**
     * 加减字节
     *
     * @param numBytes 带正负的字节
     * @return 当前字节
     */
    public Integer operatorNumberBytes(Integer numBytes) {

        this.numBytes += numBytes;

        return this.numBytes;
    }

    /**
     * 加减字数
     *
     * @param numChars 带正负的字数
     * @return 当前字数
     */
    public Integer operatorNumberChars(Integer numChars) {

        this.numChars += numChars;

        return this.numChars;
    }

    /**
     * 加减行数
     *
     * @param numLiens 带正负的整数
     * @return 当前行数
     */
    public Integer operatorNumberLines(Integer numLiens) {

        this.numLiens += numLiens;

        return this.numLiens;
    }

    @Override
    public void countByBytes(String text_inf) {

        numBytes += text_inf.getBytes().length;
    }

    /**
     * 按字数统计
     *
     * @param text_inf 一行文本
     */
    @Override
    public void countByWords(String text_inf) {

        numChars += text_inf.length();
    }

    /**
     * 按统计行数
     *
     * @param text_inf 一行文本
     */
    @Override
    public void countByLines(String text_inf) {

        ++numLiens;
    }

    /**
     * 解析
     *
     * @param order 解析语言
     * @return 判断是否解析成功
     */
    @Override
    public boolean doParsing(String[] order) {

        AbstractFiles fRead;
        if (orders.isEmpty() && order.length < 2) {
            formatType = -1;
        }
        if (order.length > 1) {

            if (order.length > 2 || !order[1].trim().equalsIgnoreCase("-l")) {
                //说明有自己的数据源
                if (order.length > 2) {
                    formatType = 0;
                    fRead = new Files(order[2]);
                } else
                    fRead = new Files(order[1]);

                try {
                    orders = fRead.ReadFile();
                } catch (IOException e) {
                    logger.error("前方高能预警！", e);
                }

            } else
                formatType = 0;
            //单纯的统计的行数
            setNumLiens(orders.size());
        }
        if (formatType > -1) {
            //单纯的统计的行数
            setNumLiens(orders.size());
            //统计字数和字节数
            for (Object ans : orders) {
                String orderAns = (String) ans;
                operatorNumberChars(orderAns.length());
                operatorNumberBytes(orderAns.getBytes().length);
            }
        }
        orders.clear();
        return true;
    }

    @Override
    public Collection<Object> getResult() {
        return orders;
    }

    @Override
    public void SetResult(Collection<Object> result) {
        orders = result;
    }

    @Override
    public void show() {

        if (formatType > -1) {
            logger.info(formatType > 0 ? "  " + numBytes +
                    "     " + numChars + "     " + numLiens : "  " + numLiens);
        }
    }
}
