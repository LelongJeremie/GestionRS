import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.Before;

@TestMethodOrder(OrderAnnotation.class)
class PoupeeRusseTest {
	private static PoupeeRusse p;
	private static PoupeeRusse p2;
	@BeforeAll
	static void initpoupee(){
		p = new PoupeeRusse(3);
		p2 = new PoupeeRusse(5);
		
	}
	
	@Test @Order(1)
	void testOuvert() {	
		assertFalse("Test etat initiale de la poupée", p.isEstOuvert());
		assertEquals("N'est pas dans un poupée",null, p.getPoupeeMere());
		p.ouvrir();
		assertTrue("Test ouverture de la poupée", p.isEstOuvert());
		
	}
	
	@Test @Order(2)
	void testFermeture() {
		assertTrue("Test initiale de la poupée", p.isEstOuvert());
		p.fermer();
		assertFalse("Test fermeture de la poupée", p.isEstOuvert());
	}

	@Test @Order(3)
	void testPlacerDans() {
		assertEquals("Test placement initiale de la poupée",null,p.getPoupeeMere());
		p.placerDans(p);
		
	}
}
