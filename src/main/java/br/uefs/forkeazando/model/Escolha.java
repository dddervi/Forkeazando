public class Escolha {
    private String textoAlternativa;      
    private int idCenaDestino;            
    
 
    private int alteracaoEnergia;
    private double alteracaoScore;
    private double alteracaoVidaSocial;
    
 
    private String flagParaAtivar;         
    private String flagExigida;           
    
    
    private double scoreMinimoExigido;

    public Escolha(String texto, int destino, int energia, double score, double social, String flagAtivar) {
        this.textoAlternativa = texto;
        this.idCenaDestino = destino;
        this.alteracaoEnergia = energia;
        this.alteracaoScore = score;
        this.alteracaoVidaSocial = social;
        this.flagParaAtivar = flagAtivar;
        this.scoreMinimoExigido = 0.0; 
    }

   
    public boolean jogadorPreencheRequisitos(Protagonista p, List<String> historicoFlags) {
        if (p.getScore() < scoreMinimoExigido) return false;
        if (flagExigida != null && !historicoFlags.contains(flagExigida)) return false;
        return true;
    }

    
    public String getTextoAlternativa() { return textoAlternativa; }
    public int getIdCenaDestino() { return idCenaDestino; }
    public int getAlteracaoEnergia() { return alteracaoEnergia; }
    public double getAlteracaoScore() { return alteracaoScore; }
    public double getAlteracaoVidaSocial() { return alteracaoVidaSocial; }
    public String getFlagParaAtivar() { return flagParaAtivar; }
    public void setScoreMinimoExigido(double min) { this.scoreMinimoExigido = min; }
    public void setFlagExigida(String flag) { this.flagExigida = flag; }
}
