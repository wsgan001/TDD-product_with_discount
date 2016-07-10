package com.thoughtworks.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PriceFormatUtil {

    private static String pattern = "0.00";

    public static String formatPrice(Double price){
        DecimalFormat df = new DecimalFormat(pattern);
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(price);
    }
}
