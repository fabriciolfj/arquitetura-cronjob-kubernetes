package com.github.fabriciolfj.transacaoservice.domain.exceptions.enums;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Errors {

    T_001,
    T_002,
    T_003,
    T_004,
    T_005,
    T_006,
    T_999;

    public String getMessage(final Locale messageLocale) {
        final ResourceBundle resourceBundle = ResourceBundle.getBundle("messages/exceptions", messageLocale);
        return resourceBundle.getString(name() + ".message");
    }
}

