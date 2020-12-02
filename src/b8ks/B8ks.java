/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b8ks;

import Entity.Cart;
import com.B8ks.utils.DataSource;
import com.mysql.jdbc.Connection;
import com.B8ks.service.ServiceOrder;
import Entity.Order;
import com.B8ks.service.CartService;


/**
 *
 * @author sinda
 */
public class B8ks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //DataSource ds = DataSource.getInstance();
        //Connection cnx=DataSource.getInstance().getCnx();
        Order o = new Order(202,2,"ennnn cours",33f);
        Order o1 = new Order(21,3,"en cours",30f);        
        Order o4 = new Order(7,50,4,"en cours",30f); 
        Cart c = new Cart(2,20,3);
        ServiceOrder so=new ServiceOrder();
        CartService sc=new CartService();
        //System.out.println(so.afficherO());
        //so.modifierO(o4);
        //sc.ajouterC(c);
        //sc.supprimerC(c);
        //System.out.println(sc.afficherC());
        sc.modifierC(c);
        

        
        

        
       
        



    }

}
