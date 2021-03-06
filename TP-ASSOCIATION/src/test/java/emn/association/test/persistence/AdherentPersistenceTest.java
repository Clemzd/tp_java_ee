/*
 * Created on 8 oct. 2013 ( Time 22:11:33 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package emn.association.test.persistence;


import emn.association.bean.Adherent ;
import emn.association.mock.AdherentMock;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.AdherentPersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Adherent persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdherentPersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test Adherent persistence : delete + load ..." );
		
		AdherentPersistence service = PersistenceServiceProvider.getService(AdherentPersistence.class);
		AdherentMock mock = new AdherentMock();
		
		// TODO : set primary key values here 
		process( service, mock, "A"  );
		// process( service, mock, ... );
	}

	private void process(AdherentPersistence service, AdherentMock mock, String identifiant ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		Adherent entity = service.load( identifiant );
		if ( entity != null ) {
			// Found 
			System.out.println("   FOUND : " + entity );
			
			// Save (update) with the same values to avoid database integrity errors  
			System.out.println(" . save : " + entity );
			service.save(entity);
			System.out.println("   saved : " + entity );
		}
		else {
			// Not found 
			System.out.println("   NOT FOUND" );
			// Create a new instance 
			entity = mock.createInstance( identifiant ) ;
			Assert.assertNotNull(entity);

			// No reference : insert is possible 
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );

			System.out.println(" . delete : " );
			boolean deleted = service.delete( identifiant );
			System.out.println("   deleted = " + deleted);
			Assert.assertTrue(deleted) ;
		}		
	}
}
