import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class DistributeurTest{
	
	// Passed
	@Test
	void testFailedCheckPayement() {
		Distributeur d = new Distributeur();
		assertEquals(-1, d.checkPayement(Boisson.Breuvage.ERROR));
	}
	
	// Passed
	@Test
	void testTheCheckPayement() {
		Distributeur d = new Distributeur();
		d.ajouterPiece(5.0);
		assertEquals(0, d.checkPayement(Boisson.Breuvage.THE));
	}
	
	// Passed
	@Test
	void testCafeCheckPayement() {
		Distributeur d = new Distributeur();
		d.ajouterPiece(5.0);
		assertEquals(0, d.checkPayement(Boisson.Breuvage.CAFE));
	}

	// Non faisable sans Mockito (car menu) nous n'avons pas réussi à installer Mockito 
	// donc nous ne pouvions pas mocker les fonctions appelés
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

	// Passed
	@Test
	void testCafeChoisirBoisson() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(Boisson.Breuvage.CAFE, d.choisirBoisson());
        System.setIn(sysInBackup);
	}
	
	// Passed
	@Test
	void testTheChoisirBoisson() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        assertEquals(Boisson.Breuvage.THE, d.choisirBoisson());
        System.setIn(sysInBackup);
	}
	
	// Passed
	@Test
	void testRetourChoisirBoisson() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("aa".getBytes());
        System.setIn(in);
        assertEquals(Boisson.Breuvage.ERROR, d.choisirBoisson());
        System.setIn(sysInBackup);
	}

	// Passed
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
	
	// Passed
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
	
	// Passed
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

	// Passed
	@Test
	void testZeroRendreMonnaie() {
		Distributeur d = new Distributeur();
		assertEquals(0, d.rendreMonnaie(), 0.001);
	}
	
	// Passed
	@Test
	void testRendreMonnaie() {
		Distributeur d = new Distributeur();
		d.ajouterPiece(7.0);
		assertEquals(7.0, d.rendreMonnaie(), 0.001);
	}
	
	// Passed
	@Test
	void testAllInOnePath() {
		Distributeur d = new Distributeur();
		InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        d.introductionPiece();
        sysInBackup = System.in;
        in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        d.checkPayement(d.choisirBoisson());
        System.setIn(sysInBackup);
        assertEquals(0, d.rendreMonnaie(), 0.001);
        
        sysInBackup = System.in;
        in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        d.introductionPiece();
        System.setIn(sysInBackup);
        sysInBackup = System.in;
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        d.introductionPiece();
        System.setIn(sysInBackup);
        sysInBackup = System.in;
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        d.introductionPiece();
        System.setIn(sysInBackup);
        sysInBackup = System.in;
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        d.checkPayement(d.choisirBoisson());
        System.setIn(sysInBackup);
        assertEquals(0.5, d.rendreMonnaie(), 0.001);
        
        sysInBackup = System.in;
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        d.introductionPiece();
        sysInBackup = System.in;
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        d.checkPayement(d.choisirBoisson());
        System.setIn(sysInBackup);
        assertEquals(0.5, d.rendreMonnaie(), 0.001);
	}

}
