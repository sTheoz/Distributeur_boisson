import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class DistributeurTest{

	@Test
	void testFailedCheckPayement() {
		Distributeur d = new Distributeur();
		assertEquals(-1, d.checkPayement(Boisson.Breuvage.ERROR));
	}
	
	@Test
	void testTheCheckPayement() {
		Distributeur d = new Distributeur();
		d.ajouterPiece(5.0);
		assertEquals(0, d.checkPayement(Boisson.Breuvage.THE));
	}
	
	@Test
	void testCafeCheckPayement() {
		Distributeur d = new Distributeur();
		d.ajouterPiece(5.0);
		assertEquals(0, d.checkPayement(Boisson.Breuvage.CAFE));
	}

	@Test
	void testChoisirAction() {
		fail("Pas bon");
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(0, d.choisirAction());
        System.setIn(sysInBackup);
	}

	@Test
	void testCafeChoisirBoisson() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(Boisson.Breuvage.CAFE, d.choisirBoisson());
        System.setIn(sysInBackup);
	}
	
	@Test
	void testTheChoisirBoisson() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        assertEquals(Boisson.Breuvage.THE, d.choisirBoisson());
        System.setIn(sysInBackup);
	}
	
	@Test
	void testRetourChoisirBoisson() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("aa".getBytes());
        System.setIn(in);
        assertEquals(Boisson.Breuvage.ERROR, d.choisirBoisson());
        System.setIn(sysInBackup);
	}

	@Test
	void testCinquanteIntroductionPiece() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        d.introductionPiece();
        assertEquals(0.50 , d.rendreMonnaie(), 0.001);
        System.setIn(sysInBackup);
	}
	
	@Test
	void testUnIntroductionPiece() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        d.introductionPiece();
        assertEquals(1.00, d.rendreMonnaie(), 0.001);
        System.setIn(sysInBackup);
	}
	
	@Test
	void testRetourIntroductionPiece() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("aa".getBytes());
        System.setIn(in);
        d.introductionPiece();
        assertEquals(0.00, d.rendreMonnaie(), 0.001);
        System.setIn(sysInBackup);
	}

	@Test
	void testZeroRendreMonnaie() {
		Distributeur d = new Distributeur();
		assertEquals(0, d.rendreMonnaie(), 0.001);
	}
	
	@Test
	void testRendreMonnaie() {
		Distributeur d = new Distributeur();
		d.ajouterPiece(7.0);
		assertEquals(7.0, d.rendreMonnaie(), 0.001);
	}

}
