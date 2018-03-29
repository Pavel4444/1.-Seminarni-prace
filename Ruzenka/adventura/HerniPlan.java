
/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     PavelPivovarčík
 */
public class HerniPlan {
    private Prostor aktualniProstor;
    private Prostor viteznyProstor;
    private Prostor prohravaciProstor;
    private Batoh batoh;    
    private boolean jedl; // zda princ neco jedl
    private boolean sebralchleba;
    private boolean sebralmec;
    private boolean sebrallektvar;
    private boolean odpovedel;
    
    /**
     *  Konstruktor, který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví les.
     */
    public HerniPlan() {
        zalozProstoryHry();
        batoh = new Batoh();                
    }
    
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví les.
     */
    public void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
     
        Prostor les = new Prostor("les","Mas dve moznosti, kam se vydat");
        
        Prostor reka = new Prostor("reka", "Usel si pekny kus cesty k rece. Muzes se prebrodit k chatrci\n"
            + ", anebo se vratit zpet do lesa");
            
        Prostor hlubokyLes = new Prostor("hlubokyLes","Vydal jsi se jeste dale do hlubokeho lesa.\n"
            + "a potkas trpaslika, ktery ti da radu a povida: \"Az dojdes k zamku, vydej se po zebriku a \n"
            + "nebudes bojovat s carodejnici.\"\n"
            + " muzes se vydat smerem k chatrci, anebo se vratit na zacatek lesa");
            
        Prostor chatrc = new Prostor("chatrc","Dosel jsi do chatrce\n"
            + "nachazi se zde mec,chleba a lektvar\n"
            + "jestlize si vsechno sebral, muzes se vydat smerem k zamku");
            
        Prostor zamek = new Prostor("zamek","Cesta te vycerpala a musis se posilnit chlebem,\n"
            +"pote se musis rozhodnout jestli se vydas po zebriku nebo zarostlym vchodem");
        
        Prostor zebrik = new Prostor ("zebrik", "Zvolil jsi lepsi cestu\n"
            +  "vyhnes se tak souboji s carodejnici\n"
            +  "dale muzes vstoupit do pokoje s ruzenkou");
            
        Prostor vchod = new Prostor ("vchod", "Vybral jsi si slozitejsi cestu.\n"
            + "Musel jsi se prosekat hustou krovinou a pote se objevila carodejnice, ktera ti polozi otazku: \n"
            + "Otazka zni: 'Kolik je 5+5'\n"
            + "Pokud uhadnes muzes vejit do pokoje, pokud ne hra konci"); 
            
        Prostor pokoj = new Prostor("pokoj", "Konecne jsi se dostal k ruzence, \n"
            + "staci ji uz jen polit lektvarem a vysvobodis ji.");
             
        prohravaciProstor = vchod;
        viteznyProstor = pokoj;
        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        les.setVychod(reka);
        les.setVychod(hlubokyLes);
        reka.setVychod(chatrc);
        reka.setVychod(les);
        hlubokyLes.setVychod(les);
        hlubokyLes.setVychod(chatrc);
        chatrc.setVychod(zamek);
        zamek.setVychod(vchod);
        zamek.setVychod(zebrik);        
        zebrik.setVychod(pokoj);
        vchod.setVychod(pokoj);
        
        
        
        //věci, které lze vložit do batohu        
        
        chatrc.vlozVec(new Vec("mec"));
        chatrc.vlozVec(new Vec("chleba"));
        chatrc.vlozVec(new Vec("lektvar"));
        
        
        
        aktualniProstor = les;  // hra začíná v lese   
    }

 
    
   
    
    /**
     * Metoda rozhodne, zda princ jedl
     */
    public boolean jedlJidlo(){
        return jedl;
    }

    /**
     * Metoda nastavuje, že princ jedl
     */
    public void setJedl(boolean j){
        jedl = j;
    }
    
    /**
     * Metoda rozhodne, zda princ sebral chleba
     */
    public boolean sebralChleba(){
        return sebralchleba;
    }

    /**
     * Metoda nastavuje, že princ sebral chleba
     */
    public void setSebralChleba(boolean j){
        sebralchleba = j;
    }
    
    public boolean odpovedelSpravne(){
        return odpovedel;
    }
    
    public void setodpovedelSpravne(boolean j){
        odpovedel = j;
    }
    /**
     * Metoda rozhodne, zda princ sebral lektvar
     */
    public boolean sebralLektvar(){
        return sebrallektvar;
    }

    /**
     * Metoda nastavuje, že princ sebral lektvar
     */
    public void setSebralLektvar(boolean j){
        sebrallektvar = j;
    }
    /**
     * Metoda rozhodne, zda princ sebral mec
     */
    public boolean sebralMec(){
        return sebralmec;
    }

    /**
     * Metoda nastavuje, že princ sebral mec
     */
    public void setSebralMec(boolean j){
        sebralmec = j;
    }
  
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }
   
       
    /**
     * Metoda vrací vítězný prostor.
     */
    public Prostor getViteznyProstor() {
        return viteznyProstor;
    }
    
    /**
     * Metoda vrací prohrávací prostor.
     */
    public Prostor getProhravaciProstor() {
        return prohravaciProstor;
    }

    /**
     * Metoda vrací obsah kabelky.
     */
    public Batoh getBatoh() {
        return batoh;
    }
    
}
