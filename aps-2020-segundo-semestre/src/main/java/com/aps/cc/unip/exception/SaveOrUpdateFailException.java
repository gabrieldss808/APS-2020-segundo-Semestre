package com.aps.cc.unip.exception;

import org.hibernate.HibernateException;

public class SaveOrUpdateFailException extends HibernateException {
    private String msg;

    public SaveOrUpdateFailException(String message) {
        super(message);
        this.msg = message;
    }

    public String getMsg() { return msg; }
}
