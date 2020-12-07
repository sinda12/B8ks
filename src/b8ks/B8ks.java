/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b8ks;

import com.B8ks.entities.Order;
import com.B8ks.entities.User;
import com.B8ks.utils.DataSource;
import com.mysql.jdbc.Connection;
import com.B8ks.service.ServiceOrder;

import com.B8ks.service.CartService;
import com.B8ks.service.ServiceUser;


/**
 *
 * @author sinda
 */
public class B8ks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource ds = DataSource.getInstance();
        Connection cnx=DataSource.getInstance().getCnx();
        Order o = new Order(202,2,"ennnn cours",33f);
        Order o1 = new Order(21,3,"en cours",30f);        
        //Order o4 = new Order(7,50,4,"en cours",30f); 
        //Cart c = new Cart(2,20,3);
        User u =new User(22222,22,"sin","sg","home","kk@","1235",false);
        ServiceUser su=new ServiceUser();
        ServiceOrder so=new ServiceOrder();
        //so.ajouterO(o);
        //so.ajouterO(o1);
        System.out.println(so.afficherO());
        
        //su.add(u);
        
        //CartService sc=new CartService();
        //System.out.println(so.afficherO());
        //so.modifierO(o4);
        //sc.ajouterC(c);
        //sc.supprimerC(c);
        //System.out.println(sc.afficherC());
        //sc.modifierC(c);
        /*User user1 = new User(2,00000000,10,"feres","alaaa",
                "ariena","alaa@","0101010101",true);
        ServiceUser serviceUser = new ServiceUser();
        serviceUser.add(user1);*/
        
        
        

        
        

        
       
        



    }

}
