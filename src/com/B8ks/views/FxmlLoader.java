/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.B8ks.views;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author sinda
 */
public class FxmlLoader {
    private Pane view;
    
    public Pane getPage(String fileName){
        try{
            URL fileUrl=B8ks_Main.class.getResource(fileName+".fxml");
            if(fileUrl==null){
                throw new java.io.FileNotFoundException("FXML file can't be found");
            }
            view =new FXMLLoader().load(fileUrl);
        }
        catch(Exception e){
            System.out.println("No Page"+fileName+"please check FxmlLoader.");
        }  return view;
        
    }
}
