package com.xinpi.util;

import java.util.Random;

/**
 * 类 名 称：FourRandom
 * 类 描 述：生成四位数的随机数
 * 创建时间：2019-08-16 10:26
 * 创 建 人：renhao
 */
public class FourRandom {

    public static String getFourRandom (){
        Random random = new Random();

        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 0; i < 4 - randLength; i++) {
                fourRandom = "0" + fourRandom;
            }

        }
        return fourRandom;

    }
}
