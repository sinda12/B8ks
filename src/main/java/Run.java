import entities.User;
import service.ServiceUser;

public class Run {
    public static void main (String[] args)
    {
            User user1 = new User(2,00000000,10,"feres","alaaa",
                "ariena","alaa@","0101010101",true);
        User user2 = new User(21258495,25,"bourguiba","ferid",
                "soukra","aziz@live","87z8z4s",false);
        User user3 = new User(21258495,25,"bourguiba","alya",
                "soukra","aziz@live","87z8z4s",false);

       ServiceUser serviceUser = new ServiceUser();
     /*  serviceUser.add(user1);
       serviceUser.add(user2);
       serviceUser.add(user3);*/

//serviceUser.delete(user1);
serviceUser.modify(user1);
      //  System.out.println(serviceUser.getList());

    }
}
