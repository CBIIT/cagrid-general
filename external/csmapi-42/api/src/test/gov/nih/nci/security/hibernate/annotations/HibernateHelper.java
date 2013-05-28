/**
*============================================================================
*  Copyright The Ohio State University Research Foundation, The University of Chicago - 
*	Argonne National Laboratory, Emory University, SemanticBits LLC, and 
*	Ekagra Software Technologies Ltd.
*
*  Distributed under the OSI-approved BSD 3-Clause License.
*  See http://ncip.github.com/cagrid-core/LICENSE.txt for details.
*============================================================================
**/
package test.gov.nih.nci.security.hibernate.annotations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {

   private HibernateHelper() {
   }

   public static Session getSession() {
      Session session = (Session)HibernateHelper.session.get();
      if( session == null ) {
         session = sessionFactory.openSession();
         HibernateHelper.session.set(session);
      }
      return session;
   }
   
   private static final ThreadLocal session = new ThreadLocal();
   private static final ThreadLocal transaction = new ThreadLocal();   
   private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();   
}
