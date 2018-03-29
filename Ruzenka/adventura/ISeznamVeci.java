/**
 *  Třída implementující toto rozhraní ve hře implementuje jednotlivé metody.
 *  Toto rozhraní je součástí jednoduché textové hry.
 *  
 * @author    Pavel Pivovarčík
 * @version   2017
 */
public interface ISeznamVeci
{
    public boolean obsahujeVec(String nazev);
    
    public Vec vlozVec(Vec vec);
    
    public Vec odeberVec(String nazev);
    
    public Vec odeberVec(Vec vec);
    
    public Vec odebranaVec(Vec vec);
    
    public Vec snezVec(Vec vec);
}
