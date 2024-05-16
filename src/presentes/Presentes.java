
package presentes;


import java.util.List;
import presentes.insumos.Estoque;

public abstract class Presentes {
    private String nome;
    private int idade;
    private double peso;
    private int codigo;
    protected static  int totalpresentes;
    private int serial;

    public Presentes(String nome, int idade, double peso, int codigo) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.codigo = codigo;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    protected String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSerial() {
        return serial;
    }
    
    protected int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    protected double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    protected int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static int getTotalpresentes() {
        return totalpresentes;
    }
    
    public static void TipoPresentes(List<Presentes> listaPresentes) {
        int eletronicos = 0;
        int manofaturas = 0;
        for (Presentes presente : listaPresentes) {    //percorre a listapresentes da producao diaria 
            if (presente instanceof Eletronicos) {     //verifica se o objeto é uma instancia da classe eletronicos
                eletronicos++;
            }else{
                manofaturas++;
            }
        }
        System.out.println("Sao produzidos " + eletronicos + " presentes eletronicos e " + manofaturas + " manofaturas por dia.");
        System.out.println("==================================================================");
    }
    
    abstract public Presentes Produzir(Estoque estoque, List<Produtor> listaProdutores);   
}
