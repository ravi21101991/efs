package org.study.efscale;

final class EfScaleValidationConstants {

    private EfScaleValidationConstants() {
    }

    static final String INVALID_WIND_SPEED = "** please enter valid wind speed";
    static final String INVALID_NON_NUMERIC_WIND_SPEED = "** please enter numeric value";
    static final String INVALID_NEGATIVE_WIND_SPEED = "** please enter non negative numeric value";
    static final String INVALID_LESS_THAN_MIN_SPEED = "** please enter value greater than 65";
}
