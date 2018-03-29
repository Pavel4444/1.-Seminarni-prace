/*******************************************************************************
 * Třída Start složí ke spouštění aplikace.
 *
 * @author   Pavel Pivovarčík
 * @version   2017
 */ 
package com.github.Pavel4444.adventura2.main;

import com.github.Pavel4444.adventura2.ui.*;



/*******************************************************************************
 * Třída {@code Start} je hlavní třídou projektu,
 * který ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Start
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        
        TextoveRozhrani tr = new TextoveRozhrani();
        tr.hraj();
    }
}
