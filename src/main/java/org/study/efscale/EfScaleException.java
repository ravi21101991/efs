package org.study.efscale;

class EfScaleException extends RuntimeException {

    private final String message;

    EfScaleException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
