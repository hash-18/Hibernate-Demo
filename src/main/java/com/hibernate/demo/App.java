package com.hibernate.demo;

import org.hibernate.cfg.Configuration;

import com.mysql.cj.x.protobuf.MysqlxCursor.Open;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    
    Configuration cfg=new Configuration();
    cfg.configure("hibernate.cfg.xml");
    SessionFactory factory=cfg.buildSessionFactory(); 
    
    Student s=new Student();
    s.setId(3);
    s.setName("iiMac");
    s.setCity("iiCalcutta");
 
    Session session=factory.openSession();
    Transaction tx=session.beginTransaction();
    session.save(s);
    tx.commit();
    
    //to fetch data from the table
   Student stud= (Student)session.get(Student.class, 1);
   //get returns the object after taking entity(that we marked as @Entity) and id as input.
   //We convert onject class to Student class
   System.out.println(stud);//fetching row matching id=1
    
    
    
    
}
}