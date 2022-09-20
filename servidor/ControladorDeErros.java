package servidor;
public class ControladorDeErros implements Cloneable
{
    private Integer qtdMax, qtdErr = 0;

    
    public ControladorDeErros (int qtdMax) throws Exception
    {
        if (qtdMax < 0) throw new Exception();
        this.qtdMax = qtdMax;
		
    }

    public void registreUmErro () throws Exception
    {
        if(this.qtdErr == this.qtdMax) throw new Exception();
        this.qtdErr++;
        
    }

    public boolean isAtingidoMaximoDeErros()
    {
        if (this.qtdErr == this.qtdMax) return true;
        return false;   

    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;

        if (this.getClass() != obj.getClass()) return false;
        
        ControladorDeErros c = (ControladorDeErros)obj;
        // if (this.qtdMax != c.qtdMax) return true; MÉTODO ORIGINAL
        if (!this.qtdMax.equals(c.qtdMax)) return false; // MÉTODO EQUALS 
        if (!this.qtdErr.equals(c.qtdErr)) return false;
        
        return true;
    }

    public int hashCode()
    {
        int hash = 2;
        hash = 2 * 3 + Integer.valueOf(this.qtdMax).hashCode();        
        hash = 2 * 3 + Integer.valueOf(this.qtdErr).hashCode();   
        if(hash < 0) hash = - hash;
        return hash;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception 
    {
        c.qtdMax = this.qtdMax;
        c.qtdErr = this.qtdErr;
    }

    public Object clone(Object x) 
    {
        try {
            return new ControladorDeErros(this);
        } catch (Exception e) {
            return null;
        }
    }
}
