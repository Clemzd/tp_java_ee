/*
 * Created on 7 oct. 2013 ( Time 10:16:40 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */

package persistence.services.jpa;

import persistence.commons.jpa.GenericJpaService;
import persistence.services.AdherentPersistence;
import dao.Adherent;

/**
 * JPA implementation for basic persistence operations ( entity "Adherent" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class AdherentPersistenceJPA extends GenericJpaService<Adherent, String> implements AdherentPersistence {

	/**
	 * Constructor
	 */
	public AdherentPersistenceJPA() {
		super(Adherent.class);
	}

	public Adherent load( String identifiant ) {
		return super.load( identifiant );
	}

	public boolean delete( String identifiant ) {
		return super.delete( identifiant );
	}

	public boolean delete(Adherent entity) {
		if ( entity != null ) {
			return super.delete( entity.getIdentifiant() );
		}
		return false ;
	}

}