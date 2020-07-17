package com.aaa.utils;

import java.util.Random;

public class FileNameUtils {
    private FileNameUtils(){

    }/**
     * 功能描述: <br>
     * 〈〉文件名的生成
     * @Param: []
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/10 17:36
     */
    public static String getFileName(){
//        1.获取当前系统信息
        long currentTimeMillis = System.currentTimeMillis();
//        2 创建随机对象
        Random random = new Random();
//        随机从0-999中抽
        int number = random.nextInt(999);
//        生成文件名
        /**
        * * format():
         *          *      格式化方法
         *          *      %:占位符
         *          *      03:三位，如果不够三位则向前补0
         *          *      0-999随机---->11--->011
         *          *      --->9--->009
         *          *      d:数字
        *
        * */
        return currentTimeMillis + String.format("%03d",number);
    }
}
