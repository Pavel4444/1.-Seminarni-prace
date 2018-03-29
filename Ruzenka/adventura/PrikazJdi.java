/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Pavel Pivovarčík
 *@version    2017
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private Hra hra;

    /**
     *  Konstruktor třídy
     *  
     *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
     */    
    public PrikazJdi(Hra hra) {
        this.plan = hra.getHerniPlan();
        this.hra = hra;
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mam jit? Musis zadat jmeno vychodu.";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);
       

        if (sousedniProstor == null) {
            return "Tam se odsud jit neda!";
        }
        else {
            if(plan.getBatoh().obsahujeVec("chleba")){ // pokud princ nesebere vsechny veci v chatrci tak nemuze postoupit
            
            plan.setSebralChleba(true);   
            }
            if(plan.getBatoh().obsahujeVec("mec")){ // pokud princ nesebere vsechny veci v chatrci tak nemuze postoupit
            
            plan.setSebralMec(true);   
            }
            if(plan.getBatoh().obsahujeVec("lektvar")){ // pokud princ nesebere vsechny veci v chatrci tak nemuze postoupit
            
            plan.setSebralLektvar(true);   
            }
            if(sousedniProstor.getNazev().equals("zamek") && !plan.sebralChleba()){ // pokud princ nesebere vsechny veci v chatrci tak nemuze postoupit
                
                return "Pred pokracovanim musis sebrat chleba,mec,lektvar.";
            }
            if(sousedniProstor.getNazev().equals("zamek") && !plan.sebralMec()){ // pokud princ nesebere vsechny veci v chatrci tak nemuze postoupit
                
                return "Pred pokracovanim musis sebrat chleba,mec,lektvar.";
            }
            if(sousedniProstor.getNazev().equals("zamek") && !plan.sebralLektvar()){ // pokud princ nesebere vsechny veci v chatrci tak nemuze postoupit
                
                return "Pred pokracovanim musis sebrat chleba,mec,lektvar.";
            }
           
            if(sousedniProstor.getNazev().equals("zebrik") && !plan.jedlJidlo()){ // pokud princ nesni chelba nemuze odejit z mistnosti zamek 
                
                return "Pred pokracovanim se musis posilnit chlebem.";
            }
            if(sousedniProstor.getNazev().equals("vchod") && !plan.jedlJidlo()){ // pokud princ nesni chelba nemuze odejit z mistnosti zamek 
                
                return "Pred pokracovanim se musis posilnit chlebem.";
            }
            if(sousedniProstor.getNazev().equals("pokoj") && !plan.odpovedelSpravne()){ // pokud princ neodpovedel na otazku nemuze odejit z mistnosti vchod 
                
                return "Pred pokracovanim musis odpovedet na otazku.";
            }
            
             
            
            
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis();
        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
