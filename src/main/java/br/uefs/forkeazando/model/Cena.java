import java.util.ArrayList;
import java.util.List;

public class Cena {
    private int id;                       
    private String capitulo;              
    private String personagemFalando;     
    private String textoNarrativo;         
    private List<Escolha> escolhas;       

    public Cena(int id, String capitulo, String personagemFalando, String textoNarrativo) {
        this.id = id;
        this.capitulo = capitulo;
        this.personagemFalando = personagemFalando;
        this.textoNarrativo = textoNarrativo;
        this.escolhas = new ArrayList<>();
    }

    
    public void adicionarEscolha(Escolha e) {
        this.escolhas.add(e);
    }

    
    public void renderizarCena() {
        System.out.println("\n------------------------------------------------------------");
        System.out.toUpperCase();
        System.out.printf("[%s]\n", this.capitulo.toUpperCase());
        System.out.println("------------------------------------------------------------");
        
        if (!this.personagemFalando.equalsIgnoreCase("Narrador")) {
            System.out.printf("🗣️ %s diz:\n", this.personagemFalando);
        }
        System.out.printf("\"%s\"\n", this.textoNarrativo);
        System.out.println("------------------------------------------------------------");
    }

    
    public List<Escolha> obterEscolhasDisponiveis(Protagonista p, List<String> historicoFlags) {
        List<Escolha> disponiveis = new ArrayList<>();
        int indice = 1;
        
        System.out.println("O QUE VOCÊ VAI FAZER?");
        for (Escolha e : this.escolhas) {
            if (e.jogadorPreencheRequisitos(p, historicoFlags)) {
                System.out.printf("%d - %s\n", indice, e.getTextoAlternativa());
                disponiveis.add(e);
                indice++;
            }
        }
        return disponiveis;
    }

   
    public int getId() { return id; }
}
