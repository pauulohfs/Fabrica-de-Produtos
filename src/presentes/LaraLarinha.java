package presentes;

import java.util.List;
import presentes.insumos.Estoque;
import presentes.insumos.InsumoInsuficienteException;
import presentes.insumos.ItensEstoque;

public class LaraLarinha extends Manofatura {

    public LaraLarinha(String nome, int idade, double peso, int codigo, Produtor produtor) {
        super(nome, idade, peso, codigo, produtor);
    }

    @Override
    public Presentes Produzir(Estoque estoque, List<Produtor> listaProdutores) {
        Estoque insumosUsados = new Estoque();
        ItensEstoque madeira = new ItensEstoque("Madeira", 10);
        ItensEstoque aco = new ItensEstoque("Aco", 10);
        ItensEstoque aluminio = new ItensEstoque("Aluminio", 20);
        ItensEstoque ouro = new ItensEstoque("Ouro", 5);
        ItensEstoque prata = new ItensEstoque("Prata", 5);
        ItensEstoque couro = new ItensEstoque("Couro", 30);
        ItensEstoque pedra = new ItensEstoque("Pedra", 30);
        insumosUsados.adicionarItem(madeira);
        insumosUsados.adicionarItem(aco);
        insumosUsados.adicionarItem(aluminio);
        insumosUsados.adicionarItem(ouro);
        insumosUsados.adicionarItem(prata);
        insumosUsados.adicionarItem(couro);
        insumosUsados.adicionarItem(pedra);
        try {
            boolean validador = estoque.decrementar(insumosUsados);
            if (validador == true) {
                Presentes novoPresente = new LaraLarinha(this.getNome(), this.getIdade(), this.getPeso(), this.getCodigo(), this.getProdutor());
                for (Produtor produtor : listaProdutores) {
                    if (produtor.getNomeprodutor().equals(this.getProdutor().getNomeprodutor())) {
                        produtor.setQtPresentes(produtor.getQtPresentes()+1);
                        break;
                    }
                }
                Presentes.totalpresentes++;
                novoPresente.setSerial(Presentes.totalpresentes);
                return novoPresente;
            } else {
                return null;
            }
        } catch (InsumoInsuficienteException erro) {
            System.out.print("O presente de serial " + (Presentes.totalpresentes + 1) + " nao pode ser produzido.");
            System.out.println(" Esse presente eh uma " + this.getNome() + " com " + this.getPeso() + " gramas, idade minina " + this.getIdade() + " e produtor " + this.getProdutor());
            System.out.println(erro.getMessage() + " para produzir a " + this.getNome() + " de serial " + (Presentes.totalpresentes + 1) + ".");
            return null;
        }
    }
}
