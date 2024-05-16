package presentes;

import java.util.List;
import presentes.insumos.Estoque;
import presentes.insumos.InsumoInsuficienteException;
import presentes.insumos.ItensEstoque;

public class MiniGame extends Eletronicos {

    public MiniGame(String nome, int idade, double peso, int codigo, double consumo) {
        super(nome, idade, peso, codigo, consumo);
    }

    @Override
    public Presentes Produzir(Estoque estoque, List<Produtor> listaProdutores) {
        Estoque insumosUsados = new Estoque();
        ItensEstoque madeira = new ItensEstoque("Madeira", 20);
        ItensEstoque aco = new ItensEstoque("Aco", 20);
        ItensEstoque ferro = new ItensEstoque("Ferro", 5);
        ItensEstoque aluminio = new ItensEstoque("Aluminio", 5);
        ItensEstoque chumbo = new ItensEstoque("Chumbo", 5);
        insumosUsados.adicionarItem(madeira);
        insumosUsados.adicionarItem(aco);
        insumosUsados.adicionarItem(ferro);
        insumosUsados.adicionarItem(aluminio);
        insumosUsados.adicionarItem(chumbo);
        try {
            boolean validador = estoque.decrementar(insumosUsados);
            if (validador == true) {
                Presentes novoPresente = new MiniGame(this.getNome(), this.getIdade(), this.getPeso(), this.getCodigo(), this.getConsumo());
                Presentes.totalpresentes++;
                novoPresente.setSerial(Presentes.totalpresentes);
                return novoPresente;
            } else {
                return null;
            }
        } catch (InsumoInsuficienteException erro) {
            System.out.print("O presente de serial " + (Presentes.totalpresentes + 1) + " nao pode ser produzido.");
            System.out.println(" Esse presente eh uma " + this.getNome() + " com " + this.getPeso() + " gramas, idade minina " + this.getIdade() + " e consumo " + this.getConsumo());
            System.out.println(erro.getMessage() + " para produzir a " + this.getNome() + " de serial " + (Presentes.totalpresentes + 1) + ".");
            return null;
        }
    }
}
