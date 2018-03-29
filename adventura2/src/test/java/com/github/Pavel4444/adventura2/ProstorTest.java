package com.github.Pavel4444.adventura2;
/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.Pavel4444.adventura2.logika.Prostor;


/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class ProstorTest
{
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
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
    public void Testprostor()
    {
        Prostor prostor2 = new Prostor("les", " ", 0, 0);
        Prostor prostor3 = new Prostor("reka", "  ", 0, 0);
        prostor2.setVychod(prostor3);
        prostor3.setVychod(prostor2);
        prostor2.getVychody();
        prostor3.vratSousedniProstor("les");
    }
}

