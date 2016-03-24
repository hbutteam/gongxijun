package com.qunar.Abstract;

import com.qunar.common.CommonFeature;

/**
 * Created by gongxijun on 16-3-17.
 */
public abstract class Wcs implements CommonFeature {


    /**
     * 统计字节数
     */
    public abstract void countByBytes(String text_inf);

    /**
     * 统计字数
     */
    public abstract void countByWords(String text_inf);

    /**
     * 统计行数
     */
    public abstract void countByLines(String text_inf);


    public abstract boolean doParsing(String[] order);

    @Override
    public abstract void show();


    @Override
    public void copy() {

    }

    @Override
    public void showSpecial() {

    }

}
