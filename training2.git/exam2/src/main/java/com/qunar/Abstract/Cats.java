package com.qunar.Abstract;

import com.qunar.common.CommonFeature;

/**
 * Created by gongxijun on 16-3-17.
 */
public abstract class Cats implements CommonFeature {


    public abstract void show();

    /**
     * 解析命令
     *
     * @param order 命令
     * @return 解析是否成功
     */
    public abstract boolean doParsing(String[] order);

    /**
     * 在这到题目中啥也不做
     */
    public void copy() {

    }

    /**
     * do nothing in this class
     */
    public void showSpecial() {

    }
}
