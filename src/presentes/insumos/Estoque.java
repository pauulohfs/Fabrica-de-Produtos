package presentes.insumos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<ItensEstoque> insumos;

    public Estoque() {
        this.insumos = new ArrayList<>();
    }

    public void adicionarItem(ItensEstoque item) {
        insumos.add(item);
    }

    public void removerItem(ItensEstoque item) {
        insumos.remove(item);
    }

    public List<ItensEstoque> getItens() {
        return insumos;
    }

    public boolean decrementar(Estoque estoque) {
        for (ItensEstoque insumoUsado : estoque.getItens()) { //percorre a lista dos insumos usados e pega o nome e quantidade
            String nomeInsumo = insumoUsado.getNome();
            int qtdUsada = insumoUsado.getQuantidade();
            for (ItensEstoque insumo : insumos) {
                if (insumo.getNome().equals(nomeInsumo)) {
                    int qtdAtual = insumo.getQuantidade();
                    if (qtdAtual >= qtdUsada) {
                        insumo.setQuantidade(qtdAtual - qtdUsada);
                    } else {
                        throw new InsumoInsuficienteException("Faltou " + nomeInsumo);
                    }
                }
            }
        }
        return true;
    }

}
