import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

/**
 * @author LiGuanglong
 * @date 2018/4/27
 */
public class JavaIO {
    public static void main(String[] args){
        getResult();
        getResultAndNum();
    }


    public static void getResult(){
        try {
            // 读取原始json文件
            BufferedReader br = new BufferedReader(new FileReader(
                    "src/json/material.bin"));

            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "src/json/result.txt"));// 输出新的文件
            String s = null;
            String res = "";
            while ((s = br.readLine()) != null) {
                try {
                    // 创建一个包含原始json串的json对象
                    JSONObject json = JSONObject.fromObject(s);
                    String emil = json.getJSONObject("_source").get("email").toString();
                    String date = json.getJSONObject("_source").get("messageTime").toString();
                    String parentId = "";
                    String iaName = "";
                    String iaType = "";
                    String parentName = "";
                    String heat = "";
                    if (json.getJSONObject("_source").getJSONObject("param").get("parentId") != null) {
                        parentId = json.getJSONObject("_source").getJSONObject("param").get("parentId").toString();
                        parentId = parentId.substring(2,parentId.length()-2);
                    }

                    BufferedReader iaBr = new BufferedReader(new FileReader(
                            "src/json/ia_info1.txt"));
                    String ia = "";
                    while ((ia = iaBr.readLine()) != null) {
                        ArrayList<String> arrayList = new ArrayList<String>();
                        for (String str : ia.split("\t")) {
                            arrayList.add(str);
                        }
                        if(arrayList.get(0).equals(emil)){
                            iaName = arrayList.get(1);
                            if(arrayList.get(2).equals("1")){
                                iaType = "前端投顾";

                            }else if(arrayList.get(2).equals("2")){
                                iaType = "后端投顾";
                            }else if(arrayList.get(2).equals("3")){
                                iaType = "超管";
                            }
                        }

                    }

                    String dir = "";
                    BufferedReader dirBr = new BufferedReader(new FileReader(
                            "src/json/directoryInfo.txt"));
                    while ((dir = dirBr.readLine()) != null) {
                        ArrayList<String> arrayList = new ArrayList<String>();
                        for (String str : dir.split("\t")) {
                            arrayList.add(str);
                        }
                        if(arrayList.get(0).equals(parentId)){
                            parentName = arrayList.get(1);
                            if(arrayList.get(2).equals("0")){
                                heat = "非热门";

                            }else if(arrayList.get(2).equals("1")){
                                heat = "热门";
                            }
                        }
                    }
                    res = iaName+","+emil+","+iaType+","+date+","+parentId+","+parentName+","+heat;
                    if(!("".equals(parentId))){
                        System.out.println(emil);
                        System.out.println(parentId);
                    }
                } catch (JSONException e) {

                    e.printStackTrace();
                }
                bw.write(res);
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getResultAndNum(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "src/json/result.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "src/json/resultNum.txt"));
            String s = "";

            ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
            while ((s = br.readLine()) != null) {
                ArrayList<String> arrayList = new ArrayList<String>();
                for(String str : s.split(",",-1)){
                    arrayList.add(str);
                }
                a.add(arrayList);
            }

            int count = 0;
            for(ArrayList<String> aS: a){
                count = 0;
                String iaName = aS.get(0);
                String emil  = aS.get(1);
                String iaType = aS.get(2);
                String parentId = "";
                if(aS.get(5)!=null){
                    parentId = aS.get(5);
                }

                String parentName = aS.get(6);
                String heat = aS.get(7);
                for(ArrayList<String> aSNew : a){
                    if(aSNew.get(5)!=null){
                        if(aSNew.get(1).equals(emil) && aSNew.get(5).equals(parentId)){
                            count++;
                        }
                    }
                }

                String res = "";
                res = iaName+","+emil+","+iaType+","+parentId+","+parentName+","+heat+","+count;



                bw.write(res);
                bw.write("\n");
            }

            bw.flush();
            bw.close();

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**过滤重复*/
        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "src/json/resultNum.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "src/json/output.txt"));

            String s = "";
            String prompt = "投顾姓名"+","+"email"+","+"前/后端/超管"+","+"目录id"+","+"目录名称"+","+"热度"+","+"次数";
            bw.write(prompt);
            bw.write("\n");
            ArrayList<String> arrayList = new ArrayList<String>();
            ArrayList<String> filterList = new ArrayList<String>();
            while ((s = br.readLine()) !=null){
                arrayList.add(s);
            }

            for(int i = 0;i<arrayList.size();i++){
                if(!filterList.contains(arrayList.get(i))){
                    filterList.add(arrayList.get(i));
                }
            }

            for(String ss : filterList){
                bw.write(ss);
                bw.write("\n");
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
