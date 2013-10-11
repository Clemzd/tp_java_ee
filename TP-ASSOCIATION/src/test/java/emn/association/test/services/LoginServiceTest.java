package emn.association.test.services;

import static org.junit.Assert.*;


import org.junit.Test;

import emn.association.bean.Adherent;
import emn.association.mock.AdherentMock;
import emn.association.persistence.PersistenceServiceProvider;
import emn.association.persistence.services.AdherentPersistence;
import emn.association.services.impl.LoginService;
import emn.association.services.interfaces.ILoginService;

public class LoginServiceTest {

	@Test
	public void testUtilisateurExiste() {
		ILoginService login = new LoginService();
		AdherentPersistence service = PersistenceServiceProvider.getService(AdherentPersistence.class);

		// Dans la base il y a :
		// id : Loufoks
		// mdp: benjamin

		AdherentMock mock = new AdherentMock();
		Adherent entity = service.load("Loufoks");
		if (entity != null) {
			// Found
			System.out.println("   FOUND : " + entity);
		} else {
			// Not found
			System.out.println("   NOT FOUND");
			// Create a new instance
			entity = mock.createInstance("Loufoks");
		}
		
		System.out.println("MDP OK ?");
		assertTrue(login.motDePasseOK(entity, "benjamin"));
	}
	
	@Test
	public void testUtilisateurExistePas() {
		ILoginService login = new LoginService();

		// Un user qui existe pas
		AdherentMock mock = new AdherentMock();
		Adherent entity = mock.createInstance("Fake");
		
		// test doit etre False
		System.out.println("MDP KO ?");
		assertFalse(login.motDePasseOK(entity, "fake"));
	}
	
	@Test
	public void testChampsValide() {
		ILoginService login = new LoginService();
		
		// test doit etre True
		System.out.println(" Champs valides ?");
		assertTrue(login.champsValide("contenu", "contenu"));
	}
	
	@Test
	public void testChampsNonValide() {
		ILoginService login = new LoginService();
		
		// test doit etre True
		System.out.println(" Champs non valide ?");
		assertFalse(login.champsValide("", ""));
	}
	
	@Test
	public void testRecupAdherent() {
		ILoginService login = new LoginService();

		// Dans la base il y a :
		// id : Loufoks
		// mdp: benjamin
		System.out.println("Utilisateur Loufoks existe ?");
		assertNotNull(login.getAdherentFromId("Loufoks"));	
	}
	
	@Test
	public void testRecupAdherentInconnu() {
		ILoginService login = new LoginService();

		// Dans la base il y a :
		// id : Loufoks
		// mdp: benjamin
		System.out.println("Utilisateur Fake existe pas ?");
		assertNull(login.getAdherentFromId("Fake"));	
	}
}
