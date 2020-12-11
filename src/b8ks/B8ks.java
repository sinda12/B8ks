/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b8ks;

import com.B8ks.entities.CartTable;
import com.B8ks.entities.Cart;
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
        int user_id=1;
        DataSource ds = DataSource.getInstance();
        Connection cnx=DataSource.getInstance().getCnx();
        //Order o = new Order(202,2,"ennnn cours",33f);
        //Order o1 = new Order(21,3,"en cours",30f);        
        //Order o4 = new Order(7,50,4,"en cours",30f); 
        //Cart c = new Cart(2,20,3);
        //User u =new User(22222,22,"sin","sg","home","kk@","1235",false);
        ServiceUser su=new ServiceUser();
        User u =new User(55881153,23,"sinda","sghaier","home 21","kk@","1235");
        //su.adduser(u);
        //su.addCart_ToUser(user_id);
        ServiceOrder so=new ServiceOrder();
        Order o=new Order();
        //so.addO(o,user_id);
        so.getOrdersClient(user_id);
        
        
        
        //so.ajouterO(o);
        //so.ajouterO(o1);
        //System.out.println(so.afficherO());
        
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
        
        
        
        CartTable ct=new CartTable();
        CartService cs=new CartService();
        CartTable c1=new CartTable(7,3,2,1);
        cs.afficherCController(user_id);
        //cs.addToArchive(4);
        //cs.deleteCartOrdred(4);
        //cs.supprimerCController(c1);
        //System.out.println(cs.prixTotale(3));
        //System.out.println(cs.UserDetails(3));
        
                
        //System.out.println(cs.afficherCController(2));
        
        
        
        
        

        
        

        
       
        



    }

}
