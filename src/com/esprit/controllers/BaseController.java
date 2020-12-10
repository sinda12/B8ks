/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controllers;

import com.esprit.views.ViewFactory;



public abstract class BaseController {
    
    protected ViewFactory v ;
    private String fxmlName ;

    public BaseController(ViewFactory v, String fxmlName) {
        this.v = v;
        this.fxmlName = fxmlName;
    }
    
    public String getFxmlName(){
        return fxmlName;
    }
    
}
