package com.hx.config;

/**
 * @program: eqds-ms
 * @description:
 * @author: yangyue
 * @create: 2019/12/30 08:56
 */
public class Constants {
    //烟煤
    public static int BITUMINOUS = 0;

    //无烟煤
    public static int ANTHRACITE = 1;

    //褐煤
    public static int LIGNITE = 2;

    public static Integer getCoalType(String str){
        if(str == null || "".equals(str.trim())){
            return null;
        }
        if("烟煤".equals(str)){
            return BITUMINOUS;
        }else if("无烟煤".equals(str)){
            return ANTHRACITE;
        }else if("褐煤".equals(str)){
            return LIGNITE;
        }else{
            return BITUMINOUS;
        }
    }
}
