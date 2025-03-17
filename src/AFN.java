import java.util.HashSet;
import java.util.Set;

public class AFN {
    public static Set<AFN> ConjDeAFNs =  new HashSet<>();
    Estado EdoIni;
    Set<Estado> EdosAFN = new HashSet<Estado>();
    Set<Estado> EdosAcept =  new HashSet<Estado>();
    Set<Character> Alfabeto = new HashSet<>();
    boolean AgregoAFNUnionLexico;
    public int IdAFN;


}
