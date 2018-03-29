package com.github.Pavel4444.adventura2.logika;
/**
 *  Třída PrikazPolit implementuje pro hru příkaz polit.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author    Pavel Pivovarčík
 * @version   2017
 */
public class PrikazPolit implements IPrikaz
{
    private static final String NAZEV = "polit";
    private HerniPlan plan;   
    private Hra hra;
    /**
     *  Konstruktor třídy
     *  
     * @param plan herní plán, ve kterém se bude ve hře "polívat" 
     */    
    public PrikazPolit(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     * Provádí příkaz polít. 
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Cim mam polit?";
        }

        if(parametry.length == 1) {
            switch (parametry[0]) {
                //vyhodnocuje se, zda napsaná hodnota (parametr) odpovídá jedné z těchto
                case "lektvar":  return lektvar();
                case "mec":  return mec();
                case "chleba":  return chleba();
               
                
                default: return "Tento predmet jsi jeste nesebral."; //pokud se nenašla žádná z výše uvedených věcí
            }
        }
        return "Nic neprobehlo v polit.";
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }

    /**
     * Pokud je v batohu lektvar a nachazime se v pokoji a v prikazu polit pouzijeme lektvar ukonci se hra a vyhrajeme.
     */
    private String lektvar(){
        if(plan.getBatoh().obsahujeVec("lektvar") && plan.getAktualniProstor().getNazev().equals("pokoj") ){
            plan.getBatoh().odeberVec("lektvar");
            hra.setKonecHry(true);
            return "Vysvobodil jsi ruzenku.";
        }
        return "Tady nemas koho polit.";
    }
    
    private String mec(){
        if(plan.getBatoh().obsahujeVec("mec")){
            
            return "Polit muzes pouze s lektvarem.";
        }
        return "Tady nemas koho polit.";
    }
    
    private String chleba(){
        if(plan.getBatoh().obsahujeVec("chleba")){
            
            return "Polit muzes pouze s lektvarem.";
        }
        return "Tady nemas koho polit.";
    }
 

  
}