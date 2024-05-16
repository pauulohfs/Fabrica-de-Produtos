package presentes;

import java.util.List;
import presentes.insumos.Estoque;
import presentes.insumos.InsumoInsuficienteException;
import presentes.insumos.ItensEstoque;

public class LanitaControladora extends Eletronicos {

    public LanitaControladora(String nome, int idade, double peso, int codigo, double consumo) {
        super(nome, idade, peso, codigo, consumo);
    }

    @Override
    public Presentes Produzir(Estoque estoque, List<Produtor> listaProdutores) {
        Estoque insumosUsados = new Estoque();
        ItensEstoque madeira = new ItensEstoque("Madeira", 50);
        ItensEstoque aco = new ItensEstoque("Aco", 50);
        ItensEstoque ferro = new ItensEstoque("Ferro", 50);
        ItensEstoque aluminio = new ItensEstoque("Aluminio", 50);
        ItensEstoque chumbo = new ItensEstoque("Chumbo", 50);
        ItensEstoque cobre = new ItensEstoque("Cobre", 50);
        ItensEstoque ouro = new ItensEstoque("Ouro", 5);
        ItensEstoque prata = new ItensEstoque("Prata", 5);
        ItensEstoque couro = new ItensEstoque("Couro", 5);
        ItensEstoque pedra = new ItensEstoque("Pedra", 5);
        insumosUsados.adicionarItem(madeira);
        insumosUsados.adicionarItem(aco);
        insumosUsados.adicionarItem(ferro);
        insumosUsados.adicionarItem(aluminio);
        insumosUsados.adicionarItem(chumbo);
        insumosUsados.adicionarItem(cobre);
        insumosUsados.adicionarItem(ouro);
        insumosUsados.adicionarItem(prata);
        insumosUsados.adicionarItem(couro);
        insumosUsados.adicionarItem(pedra);
        try {
            boolean validador = estoque.decrementar(insumosUsados);
            if (validador == true) {
                Presentes novoPresente = new LanitaControladora(this.getNome(), this.getIdade(), this.getPeso(), this.getCodigo(), this.getConsumo());
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
