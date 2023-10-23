/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;
import util.HibernateUtil;

/**
 *
 * @author HP
 */
public class Test {
    public static void main (String [] args){
    
        try {
            IDao<Machine> dao = new MachineService();
            IDao<Salle> dao2 = new SalleService();
            Salle s1 = new Salle("salle1");
            Salle s2 = new Salle("salle2");
            Salle s3 = new Salle("salle3");
            
            dao2.create(s1);
            dao2.create(s2);
            dao2.create(s3);
//            dao2.create(new Salle("Salle1"));
//            dao2.create(new Salle("Salle2"));
//            dao2.create(new Salle("Salle3"));
             for(Salle s : dao2.findAll())
            System.out.println(s);
            
            
//            dao.create(new Machine("machine1", "HP", 10000));
//            dao.create(new Machine("machine2", "MAC", 20000));
//            dao.create(new Machine("machine3", "DELL", 30000));
             dao.create(new Machine("machine2", "HP", 1000, s1));
             dao.create(new Machine("machine3", "MAC", 1000, s2));
             dao.create(new Machine("machine4", "DELL", 1000, s3));
//            
//            for(Machine m : dao.findAll())
//                System.out.println(m);  
            
            
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     
    }
   
}
