package com.qunar.Abstract;

/**
 * Created by gongxijun on 16-3-17.
 */
public interface AbstractParsing {

    /**
     * 读取Command
     */
    public void readCommand();

    /**
     * 解析字符串
     */
    public boolean ParseCommand(String order);

}
