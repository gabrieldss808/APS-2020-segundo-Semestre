package com.aps.cc.unip.exception;

import org.hibernate.HibernateException;

public class DeleteFailException extends HibernateException {
    private String msg;

    public DeleteFailException(String message) {
        super(message);
        this.msg = message;
    }

    public String getMsg() { return msg; }
}
