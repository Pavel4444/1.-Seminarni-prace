package com.github.Pavel4444.adventura2;
/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.Pavel4444.adventura2.logika.Batoh;
import com.github.Pavel4444.adventura2.logika.Vec;

import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída BatohTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class BatohTest
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
    public void testkapacita()
    {
        Batoh batoh1 = new Batoh();
        Vec vec1 = new Vec("test1");
        Vec vec2 = new Vec("test2");
        Vec vec3 = new Vec("test3");
        Vec vec4 = new Vec("test4");
        batoh1.vlozVec(vec1);
        batoh1.vlozVec(vec2);
        batoh1.vlozVec(vec3);
        assertEquals(3, batoh1.getKapacita());
        assertEquals(3, batoh1.jeMistoVBatohu());
        assertEquals(null, batoh1.vlozVec(vec4));
    }
}


