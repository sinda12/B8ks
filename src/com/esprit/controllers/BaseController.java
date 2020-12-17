package com.esprit.controllers;


import javax.swing.text.ViewFactory;

public abstract class BaseController {
    protected ViewFactory v ;
    private String fxmlName ;

    public BaseController(ViewFactory v, String fxmlName) {
        this.v = v;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
