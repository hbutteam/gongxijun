package com.qunar.Abstract;

import com.qunar.common.CommonFeature;

/**
 * Created by gongxijun on 16-3-17.
 */
public abstract class Greps implements CommonFeature {

    /**
     * 直接打印到控制台
     */
    public abstract void show();

    /**
     * 解析命令
     *
     * @param order 命令
     * @return 解析是否成功
     */
    public abstract boolean doParsing(String[] order);


    /**
     * 复制到相应文本
     */
    public void copy() {

    }

    /**
     * 按照某种格式输出
     */
    public void showSpecial() {

    }

}
