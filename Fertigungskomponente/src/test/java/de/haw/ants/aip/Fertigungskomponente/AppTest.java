package de.haw.ants.aip.Fertigungskomponente;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import de.haw.ants.aip.Fertigungskomponente.entity.Bauteil;
import de.haw.ants.aip.Fertigungskomponente.entity.Fertigungsauftrag;
import de.haw.ants.aip.Fertigungskomponente.entity.Stueckliste;
import de.haw.ants.aip.Fertigungskomponente.entity.StuecklistePosition;
import de.haw.ants.aip.Fertigungskomponente.facade.IFertigungsservice;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    @Autowired
	private IFertigungsservice fertService;
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	assertTrue( true );
    }
}
