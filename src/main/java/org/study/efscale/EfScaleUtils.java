package org.study.efscale;

import java.math.BigDecimal;

final class EfScaleUtils {

    private EfScaleUtils() {
    }

    private static final BigDecimal WG_65 = new BigDecimal(65);
    private static final BigDecimal WG_85 = new BigDecimal(85);
    private static final BigDecimal WG_86 = new BigDecimal(86);
    private static final BigDecimal WG_110 = new BigDecimal(110);
    private static final BigDecimal WG_200 = new BigDecimal(200);
    private static final BigDecimal WG_111 = new BigDecimal(111);
    private static final BigDecimal WG_135 = new BigDecimal(135);
    private static final BigDecimal WG_136 = new BigDecimal(136);
    private static final BigDecimal WG_165 = new BigDecimal(165);
    private static final BigDecimal WG_166 = new BigDecimal(166);
    private static final BigDecimal WG_199 = new BigDecimal(199);

    private static final int ZERO = 0;

    static double getEfRating(String windGust) {
        BigDecimal windGustValue = new BigDecimal(windGust);

        if (isValidRange(windGustValue, WG_65, WG_85)) {
            return 6;
        }
        if (isValidRange(windGustValue, WG_86, WG_110)) {
            return 4.5;
        }
        if (isValidRange(windGustValue, WG_111, WG_135)) {
            return 3.5;
        }
        if (isValidRange(windGustValue, WG_136, WG_165)) {
            return 2.5;
        }
        if (isValidRange(windGustValue, WG_166, WG_199)) {
            return 1.0;
        }

        if (windGustValue.compareTo(WG_200) >= ZERO) {
            return 0;
        }
        return Double.MAX_VALUE;
    }

    private static boolean isValidRange(BigDecimal windGustValue, BigDecimal minVal, BigDecimal maxVal) {
        return windGustValue.compareTo(minVal) >= ZERO && windGustValue.compareTo(maxVal) <= ZERO;
    }
}
