package org.sujata.myfirstpackage;

import java.text.DecimalFormat;

public class NumberFormats {
    public static void main(String[] args) {
        float f1 = 121.4567f;

        String strf1 = String.format("%.3f", f1);
        System.out.println("Using String.format %.3f");
        System.out.println(strf1);

        System.out.println("Using DecimalFormat ######.###");
        DecimalFormat threeDecimalPlaces1 = new DecimalFormat("######.###");
        System.out.println(threeDecimalPlaces1.format(f1));

        System.out.println("Using DecimalFormat ####00.00#");
        DecimalFormat threeDecimalPlaces2 = new DecimalFormat("####00.00#");
        System.out.println(threeDecimalPlaces2.format(f1));

        System.out.println("Using DecimalFormat ####00.###");
        DecimalFormat threeDecimalPlaces3 = new DecimalFormat("####00.###");
        System.out.println(threeDecimalPlaces3.format(f1));

        System.out.println("Using DecimalFormat 000000.0000");
        DecimalFormat threeDecimalPlaces4 = new DecimalFormat("000000.0000");
        System.out.println(threeDecimalPlaces4.format(f1));
    }
}
