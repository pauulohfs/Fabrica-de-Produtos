package presentes;

import java.util.List;
import presentes.insumos.Estoque;
import presentes.insumos.InsumoInsuficienteException;
import presentes.insumos.ItensEstoque;

public class PedraVoadora extends Eletronicos {

    public PedraVoadora(String nome, int idade, double peso, int codigo, double consumo) {
        super(nome, idade, peso, codigo, consumo);
    }

    @Override
    public Presentes Produzir(Estoque estoque, List<Produtor> listaProdutores) {
        Estoque insumosUsados = new Estoque();
        ItensEstoque aco = new ItensEstoque("Aco", 100);
        ItensEstoque ferro = new ItensEstoque("Ferro", 100);
        ItensEstoque aluminio = new ItensEstoque("Aluminio", 100);
        ItensEstoque chumbo = new ItensEstoque("Chumbo", 70);
        ItensEstoque cobre = new ItensEstoque("Cobre", 10);
        ItensEstoque ouro = new ItensEstoque("Ouro", 8);
        ItensEstoque prata = new ItensEstoque("Prata", 12);
        ItensEstoque couro = new ItensEstoque("Couro", 50);
        ItensEstoque pedra = new ItensEstoque("Pedra", 50);
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
                Presentes novoPresente = new PedraVoadora(this.getNome(), this.getIdade(), this.getPeso(), this.getCodigo(), this.getConsumo());
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
