package com.example.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author LiGuanglong
 * @date 2018/7/23
 */
public class PatternDemo {

    public static void main(String[] args) {
        String str = "净资产[$netAssets]总盈亏[$profitAndLoss]";
//        StringBuilder s = new StringBuilder("净资产[$netAssets]总盈亏[$profitAndLoss]");
        StringBuilder s = new StringBuilder("净资产aa总盈亏[$profitAndLoss");

//        String regStr = "(.*)(\\[\\$.*\\])(.*)";
        String regStr = "\\[\\$\\w*\\]";


        Pattern pattern = Pattern.compile(regStr);

        Matcher matcher = pattern.matcher(str);

//        System.out.println(matcher.matches());

        System.out.println(s.toString().replaceAll(regStr, ""));


//        System.out.println(str.replaceAll(regStr, ""));
//        System.out.println(matcher.group(1));








    }
}
