/**
 * Instance třídy věc představují jednotlivé předměty.
 * 
 * Tato třída je součástí jednoduché textové hry.
 *  
 * 
 * @author    Pavel Pivovarčík
 * @version   2017
 */
public class Vec
{
    private String nazev;
    
    /***************************************************************************
     * Konstuktor třídy
     */
    public Vec(String nazev)
    {
        this.nazev = nazev;
    }

    /**
     * Metoda vrací název věci
     */ 
    public String getNazev() {
        return nazev;
    }
    
    public String odebranaVec(){
        return null;
    }
}
