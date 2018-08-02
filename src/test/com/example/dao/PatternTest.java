package com.example.dao;

import java.util.*;

/**
 * @author LiGuanglong
 * @date 2018/7/20
 */
public class PatternTest {

    public static void main(String[] args) {
        List<Map<String, String>> data = new ArrayList<>();
        Map<String, String> temp = new HashMap<>();
        temp.put("url", "http://pimg1.126.net/nfop/image-maker/o9k6svvyflmcxr.png");
        temp.put("netAssets1", "1300");
        temp.put("profitAndLoss1", "2000");

        String nosUrl = "http://baidu.png";
        String url;

        String str = "净资产[$netAssets1]总盈亏[$profitAndLoss1]\n<img src=\"[$url]\">\n";
        StringBuilder stringBuilder = new StringBuilder("净资产[$netAssets1]总盈亏[$profitAndLoss1][$url]");

        Set<String> keys = temp.keySet();

        for (String key : keys) {
            String keyTemp = "[$" + key + "]";

            if (temp.get(key).contains(".png") && temp.get(key).contains("http")) {
                url = temp.get(key);
                //将参数中的url替换为nos上的url
                if (nosUrl != null) {
                    temp.put(key, nosUrl);
                }
            }
            if (stringBuilder.indexOf(keyTemp) != -1) {
                stringBuilder.replace(stringBuilder.indexOf(keyTemp), stringBuilder.indexOf(keyTemp) + keyTemp.length(), temp.get(key).toString());
            }


        }





        System.out.println(stringBuilder);
    }
}
