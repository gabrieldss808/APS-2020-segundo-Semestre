package com.aps.cc.unip.exception;

import org.hibernate.HibernateException;

public class ReadValuesFailException extends HibernateException {
    private String msg;

    public ReadValuesFailException(String message) {
        super(message);
        this.msg = message;
    }

    public String getMsg() { return msg; }
}
