import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;

import java.util.*;

/**
 * Created by gongxijun on 16-3-14.
 */
public class AccessSolution implements Solution {

    private Result result = null;     //结果

    private Multimap<String , String> classify;

    public AccessSolution() {

        classify = HashMultimap.create();
        result = new Result();
    }


    public Result getResult() {
        return result;
    }


    /**
     * 统计全部请求
     */
    public void countByRequest() {
       result.addTotalNumber();
    }

    /**
     * 最频繁的十个http接口
     *
     * @param uri 链接URL的子项
     */
    public void countMaxHttp(String uri) {

        if (null == result.getMaxInf().get(uri)) {

            result.getMaxInf().put(uri, 1);
        } else {
            result.getMaxInf().put(uri, result.getMaxInf().get(uri) + 1);
        }
    }

    /**
     *
     * @param N 提取数据的个数
     */
    public void NOfTopHttp( Integer N ) {


        result.setNTopRequesting(
                new ArrayList<Map.Entry<String, Integer>>(
                        result.getMaxInf().entrySet()
                ));


      /*  Collections.sort(result.getNTopRequesting(), new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> out1, Map.Entry<String, Integer> out2) {
                return (out2.getValue() - out1.getValue());
            }
        });*/

        Ordering<Map.Entry<String, Integer>> NOrder = Ordering.from(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> out1, Map.Entry<String, Integer> out2) {
                return (out1.getValue() - out2.getValue());
            }
        });

        result.setNTopRequesting(NOrder.greatestOf(result.getNTopRequesting(), N));

    }

    /**
     * 统计POST　和　get 数量
     *
     * @param type 请求的类型
     */
    public void countPostGetNumber(String type ) {

        if (type.trim().equalsIgnoreCase("get"))
             result.addGetNumber();
        else
        if (type.trim().equalsIgnoreCase("post"))
             result.addPostNumber();
    }

    /**
     *
     * @return 返回不同类型的个数
     */
    public Integer countClassify( ){

        result.setUrlClassify(classify);

        return  classify.keySet().size() ;
    }

    /**
     * uri分类
     *
     * @param subUri   URI的前缀
     * @param uri      URI
     */

    public  void  countClassifyData(String subUri, String uri) {

        classify.put(subUri, uri);
    }

}
