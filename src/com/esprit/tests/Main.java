package com.esprit.tests;

import com.esprit.models.Claim;
import com.esprit.models.Newsletter;
import com.esprit.models.Review;
import com.esprit.models.User;
import com.esprit.services.ServiceClaim;
import com.esprit.services.ServiceNewsletter;
import com.esprit.services.ServiceReview;
import com.esprit.utils.DataSource;

public class Main {

	public static void main(String[] args) {
		
		DataSource ds = DataSource.getInstance();
		
		//Claim c =new Claim(1,"Hello");
		Claim c1 =new Claim(2,"Salem");
		User u = new User("Alaa","Galai");
	    Review r =new Review(1,"Ghassen","07-06-1996",15);
	    //Review r1 =new Review(1,"Saaem","19-12-2020",5);
		Newsletter n =new Newsletter(1,"hello");
		//Newsletter n1 =new Newsletter(1,"Some Changes");
		
		ServiceClaim sc = new ServiceClaim();
		ServiceNewsletter sn = new ServiceNewsletter();
		ServiceReview sr = new ServiceReview();
		
		//sc.create(c,u);
		//sc.modify(c1);
		//System.out.println(sc.show());
		sc.delete(c1);
		
		//sn.create(n,u);
		//sn.modify(n1);
		//System.out.println(sn.show());
		//sn.delete(n);
		
		//sr.create(r,u);
		//sr.modify(r1);
		//System.out.println(sr.show());
		//sr.delete(r);
		

	}

}
