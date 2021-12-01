package com.ulasalle.lp3.evaluationfinal.constant;

public final class ControllerConstant {
    public static final String SUCCESS_MESSAGE = "success";
    public static final String ERROR_MESSAGE = "An error occurred while processing the information.";

    private ControllerConstant() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNull(String str) {
        return str == null ? true : false;
    }

}
