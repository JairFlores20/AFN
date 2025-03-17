import java.util.HashSet;
import java.util.Set;

public class Estado {
    static int ContadorIdEstado;

    static {
        ContadorIdEstado = 0;
    }

    private int idEstado1;
    private boolean edoAcept1;
    private int token1;
    private Set<Transicion> trans1 = new HashSet<>();

    public Estado(int idEstado, boolean edoAcept, int token, Set<Transicion> trans1) {
        this.idEstado1 = ContadorIdEstado++;
        this.edoAcept1 = false;
        this.token1 = -1;
    }

    public Set<Transicion> getTrans1() {
        return trans1;
    }

    public void setTrans1(Set<Transicion> trans1) {
        this.trans1 = trans1;
    }

    public int getToken() {
        return token1;
    }

    public void setToken(int token1) {
        this.token1 = token1;
    }

    public boolean getEdoAcept() {
        return edoAcept1;
    }

    public void setEdoAcept(boolean edoAcept1) {
        this.edoAcept1 = edoAcept1;
    }

    public int getIdEstado() {
        return idEstado1;
    }

    public void setIdEstado(int idEstado1) {
        this.idEstado1 = idEstado1;
    }
}

