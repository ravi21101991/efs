package org.study.efscale;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

class EfScaleValidator {

    private static final String MIN_WIND_SPEED = "65";
    private static final BigDecimal MIN_WIND_GUST = new BigDecimal(MIN_WIND_SPEED);

    void validateEfWindGust(String windGust) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(windGust)) {
            throw new EfScaleException(EfScaleValidationConstants.INVALID_WIND_SPEED);
        }

        if (!NumberUtils.isNumber(windGust)) {
            throw new EfScaleException(EfScaleValidationConstants.INVALID_NON_NUMERIC_WIND_SPEED);
        }

        BigDecimal requestedWindGust = new BigDecimal(windGust);
        if (requestedWindGust.compareTo(BigDecimal.ZERO) < 0) {
            throw new EfScaleException(EfScaleValidationConstants.INVALID_NEGATIVE_WIND_SPEED);
        }

        if (requestedWindGust.compareTo(MIN_WIND_GUST) < 0) {
            throw new EfScaleException(EfScaleValidationConstants.INVALID_LESS_THAN_MIN_SPEED);
        }
    }
}
