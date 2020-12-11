package Entity;

import Services.CrudUsedBooks;

import Services.crudcategory;

public class mainprog {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
       usedbook b1 = new usedbook("ayem1", 12500, "taha hssin", "tahfouna", "2020");
       b1.setId(7);
       usedbook b2 = new usedbook("ayem2", 14000, "taha hssin", "behya", "2020");
       b2.setId(19);
        usedbook b3 = new usedbook("zaytoun", 13700, "khaled imem", "desc", "2020");
  Category c1 = new Category(11);  
  Category c2 = new Category("aventure");   
     
 crudcategory ct = new crudcategory();
  CrudUsedBooks sb = new CrudUsedBooks();
  //sb.modifier(19,"kouissi24",24500.0,"malek24","waw","2021");
  //sb.modifier(14,"aymen2",15000,"kouissi malek","waw","2021");
 // sb.supprimer(b1);
 /* ct.supprimer(c1);*/
  /*sb.ajouter(b1);
  sb.ajouter(b2);
  
    ct.supprimer(c1)
   
     ct.ajouter(c1); 
     ct.modifier(c2);
  ct.supprimer(c1);
  System.out.println(ct.afficher());*/
 
        
        
    }
}

    
    

 

        
    
    
    
    
    
    
