/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class HraTest
{
    private Hra hra1;
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }

    //== VLASTNÍ TESTY =========================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }

   

   
    @Test
    public void TestVyhra()
    {
        
        hra1.zpracujPrikaz("jdi reka");
        hra1.zpracujPrikaz("jdi chatrc");
        hra1.zpracujPrikaz("seber chleba");
        hra1.zpracujPrikaz("seber mec");
        hra1.zpracujPrikaz("seber lektvar");
        hra1.zpracujPrikaz("jdi zamek");
        hra1.zpracujPrikaz("snez chleba");
        hra1.zpracujPrikaz("jdi vchod");
        hra1.zpracujPrikaz("odpovez 10");
        hra1.zpracujPrikaz("jdi pokoj");
        hra1.zpracujPrikaz("polit lektvar");
        assertEquals(true, hra1.konecHry());
    }

    
}








