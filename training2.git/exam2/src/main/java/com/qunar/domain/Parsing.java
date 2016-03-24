package com.qunar.domain;


import com.google.common.base.Preconditions;
import com.qunar.common.CommonFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by gongxijun on 16-3-17.
 */
public class Parsing extends ParsingS {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String command;    //输入的指令

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * 解析语句
     *
     * @param orders 输入的指令
     * @return 如果解析成功返回true，否返回false
     */
    @Override
    public boolean ParseCommand(String orders) {

        Preconditions.checkNotNull(orders);

        //优先级依据index
        String[] listOrder;
        listOrder = orders.trim().split("[|]");
        List<Object> result = new ArrayList<Object>();
        CommonFeature orderSolve = orderConfig.get("cat");
        for (String order : listOrder) {
            String[] orderType = order.trim().split("\\s+");
            Preconditions.checkNotNull(orderType[0]);
            orderSolve = orderConfig.get(orderType[0]);
            if (null == orderSolve) {
                logger.error("doParsing failure!");
                return false;
            }
            orderSolve.SetResult(result);
            if (!orderSolve.doParsing(orderType)) {
                logger.error("doParsing failure!");
                return false;
            }
            result = (List<Object>) orderSolve.getResult();
        }
        orderSolve.show();
        return true;
    }

    /**
     * 从控制台输入数据
     */
    @Override
    public void readCommand() {

        logger.info(_CONTEXT);
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()) {
            String commands = reader.nextLine();
            if (commands.trim().equalsIgnoreCase("exit")) {
                logger.info("程序已经退出！");
                return;
            }

            //如果执行不成功，这条语句不成立
            if (!ParseCommand(commands.trim())) {
                logger.info("搜噶，原来这条语句超过了题目范围！！");
            }
        }
        reader.close();
    }
}
