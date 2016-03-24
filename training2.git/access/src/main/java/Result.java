import com.google.common.collect.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by gongXijun on 16-3-12.
 */
public class Result {

    static final Logger LOG = LoggerFactory.getLogger(Result.class);

    private Integer totalNumber;   //请求总量
    private Integer getNumber;   //get 请求总量
    private Integer postNumber;   //post 请求总量



    private Multimap<String, String> urlClassify; //分类信息

    private List<Map.Entry<String, Integer>> NTopRequesting;  //排序好的

    private Map<String, Integer> maxInf;  //出现频率最高的几条

    public List<Map.Entry<String, Integer>> getNTopRequesting() {
        return NTopRequesting;
    }

    public void setNTopRequesting(List<Map.Entry<String, Integer>> NTopRequesting) {
        this.NTopRequesting = NTopRequesting;
    }

    public Result() {

        urlClassify = HashMultimap.create();
        maxInf = Maps.newHashMap();
        totalNumber = 0;
        getNumber = 0;
        postNumber = 0;

    }

    public  void addTotalNumber(){
        ++totalNumber;
    }

    public void addGetNumber(){
        ++getNumber;
    }

    public void addPostNumber(){
        ++postNumber;
    }


    public Multimap<String, String> getUrlClassify() {
        return urlClassify;
    }

    public void setUrlClassify(Multimap<String, String> urlClassify) {
        this.urlClassify = urlClassify;
    }




    public static Logger getLog() {
        return LOG;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getGetNumber() {
        return getNumber;
    }

    public void setGetNumber(Integer getNumber) {
        this.getNumber = getNumber;
    }

    public Integer getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }



    public Map<String, Integer> getMaxInf() {
        return maxInf;
    }

    public void setMaxInf(Map<String, Integer> maxInf) {
        this.maxInf = maxInf;
    }


    public void show() {

        Map.Entry<String, Integer> tar;
        Set<String> Keys = urlClassify.keySet();
        for (String key : Keys) {
            LOG.info(key + "类型有：");

            Set<String> values = (Set<String>) urlClassify.get(key);
            for (String value : values)
                LOG.info(value);

        }

        LOG.info("请求总量：　" + totalNumber);

        LOG.info("请求最频繁的十个接口：　");
        for (int i = 0; i < 10 && i < NTopRequesting.size(); i++) {

            tar = NTopRequesting.get(i);
            LOG.info("第" + (i + 1) + "接口为:  " + tar.getKey() + "     请求数量为：" + tar.getValue());
        }
        LOG.info("Post请求数量为：" + postNumber);
        LOG.info("get请求数量为：" + getNumber);
    }

}
