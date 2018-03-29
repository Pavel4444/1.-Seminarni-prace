package com.github.Pavel4444.adventura2.logika;
/**
 *  Třída PrikazSnez implementuje pro hru příkaz snez.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author    Pavel Pivovarčík
 * @version   2017
 */
public class PrikazSnez implements IPrikaz
{
    private static final String NAZEV = "snez";
    private HerniPlan plan;   
    
    /**
     *  Konstruktor třídy
     *  
     * @param plan herní plán, ve kterém se bude ve hře "jíst" 
     */    
    public PrikazSnez(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Provádí příkaz sněz. Zkouší sníst věci, které jsou už vložené v batohu.
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Co mam snist?";
        }

        if(parametry.length == 1) {
            switch (parametry[0]) {
                //vyhodnocuje se, zda napsaná hodnota (parametr) odpovídá jedné z těchto
                case "chleba":  return chleba();
                case "mec":  return mec();
                case "lektvar":  return lektvar();
                
                default: return "Tento predmet jsi jeste nesebral."; //pokud se nenašla žádná z výše uvedených věcí
            }
        }
        return "Nic neprobehlo v snez.";
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
     * Metoda zajišťuje, že věc lze sníst pouze pokud je již v batohu; "nastaví", že princ se už najedl.
     */
    private String chleba(){
        if(plan.getBatoh().obsahujeVec("chleba")){
            plan.getBatoh().odeberVec("chleba");
            HerniPlan.setJedl(true); 
            return "Posilnil ses chlebem.";
        }
        return "Tenhle predmet u sebe nemas.";
    }
    
    private String mec(){
        if(plan.getBatoh().obsahujeVec("mec")){
         return "Mec neni k jidlu.";
        }
        return "Tenhle predmet u sebe nemas.";
    }
    
    private String lektvar(){
        if(plan.getBatoh().obsahujeVec("lektvar")){
         return "Lektvar neslouzi k jidlu.";
        }
        return "Tenhle predmet u sebe nemas.";
    }

  
}