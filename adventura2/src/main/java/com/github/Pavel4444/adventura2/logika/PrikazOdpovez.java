package com.github.Pavel4444.adventura2.logika;
/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz odpovez.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author    Pavel Pivovarčík
 * @version   2017
 */
public class PrikazOdpovez implements IPrikaz
{
    private static final String NAZEV = "odpovez";
    private HerniPlan plan;
    private Hra hra;
     
    /**
     *  Konstruktor třídy
     *  
     * @param plan herní plán, ve kterém se bude ve hře "odpovídat" 
     */ 
    public PrikazOdpovez(HerniPlan plan, Hra hra)
    {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     * Metoda, která slouží k vyhodnocení, zda bylo na otázku odpovězeno ve správném prostoru a správně. Spravná odpoveď je pouze 10 nebo deset, jinak 
     * konec hry.
     */
    @Override
    public String proved(String... parametry) {
        
        if (parametry.length == 0) {
            // pokud chybí druhé slovo, tak ....
            return "Musis zadat odpoved.";
        }
        if (parametry.length == 1) {
            
            
            if(plan.getAktualniProstor().getNazev().equals("vchod")) { 
                if((parametry[0].equals("10") || parametry[0].equals("deset")) 
                ){
                    plan.setodpovedelSpravne(true); 
                    return "Spravna odpoved nyni muzes vstoupit do mistnosti s ruzenkou";
                } else { 
                    hra.setKonecHry(true);
                    return "Spatna odpoved, prohrali jste";
                    
                }
            }
            else {
                //pokud se příkaz odpověď zadá v jiném prostoru než pokoj tak...
                return "Tady nemas komu odpovedet."; 
            }
        }
        return "odpoved";
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }
}