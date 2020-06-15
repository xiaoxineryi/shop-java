package com.xiaoxin.ac.Utils;

import java.io.*;

public class JsonUtils {
    public static String readJsonFile(String fileName){
        String jsonStr = "";
        try {
            String root = "E:\\Grade_2\\WEB\\ac\\src\\main\\resources\\static\\";

            File jsonFile = new File(root +fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
