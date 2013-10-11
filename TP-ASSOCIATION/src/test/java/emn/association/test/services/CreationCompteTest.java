package emn.association.test.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import emn.association.services.impl.CreationCompteService;
import emn.association.services.interfaces.ICreationCompteService;

public class CreationCompteTest {
	
	private ICreationCompteService creationCompteService;
	
	@Before
    public void setUp() throws Exception {
       this.creationCompteService = new CreationCompteService();
    }
	
	@Test
	public void testVerifierChampNonRempli() {
		assertFalse(this.creationCompteService.verifierChampRempli("", "", "", "", ""));
	}
	
	@Test
	public void testVerifierChampRempli() {
		assertTrue(this.creationCompteService.verifierChampRempli("x", "x", "x", "x", "x"));
	}
	
	@Test
	public void verifierMotDePasseIdentique() {
		assertTrue(this.creationCompteService.verifierMotDePasseIdentique("pass", "pass"));
	}
	
	@Test
	public void verifierMotDePasseDifferent() {
		assertFalse(this.creationCompteService.verifierMotDePasseIdentique("pass", "passDifferent"));
	}
}
