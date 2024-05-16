package presentes;

import java.util.ArrayList;
import java.util.List;

public class Produtor {

    private String nomeprodutor;
    private int qtPresentes;

    public Produtor(String nomeprodutor) {
        this.nomeprodutor = nomeprodutor;

    }

    public String getNomeprodutor() {
        return nomeprodutor;
    }

    public void setNomeprodutor(String nomeprodutor) {
        this.nomeprodutor = nomeprodutor;
    }

    public int getQtPresentes() {
        return qtPresentes;
    }

    public void setQtPresentes(int qtPresentes) {
        this.qtPresentes = qtPresentes;
    }

    public static void printMaiorProdutor(List<Produtor> listaProdutores) {
        int nProdutores = 0, maiorQtd = 0, i = 0;
        List<Produtor> produtores = new ArrayList<>();
        String nomeProdutor = null;
        for (Produtor produtor : listaProdutores) {
            if ((produtor.getQtPresentes() >= maiorQtd) && produtor.getQtPresentes() > 0) {
                nProdutores++;
                nomeProdutor = produtor.getNomeprodutor();
                maiorQtd = produtor.getQtPresentes();
            }
        }
        switch (nProdutores) {
            case 0 ->
                System.out.println("Os produtores nao produziram Manofaturas.");
            case 1 -> {
                System.out.print(nomeProdutor);
                System.out.println(" eh o maior produtor de Manofaturas.");
            }
            default -> {
                for (Produtor produtor : listaProdutores) {
                    if (produtor.getQtPresentes() == maiorQtd) {
                        produtores.add(produtor);
                    }
                }
                int tamList = (produtores.size() - 1);
                for (Produtor produtor : produtores) {
                    System.out.print(produtor.getNomeprodutor());
                    if (i < tamList) {
                        System.out.print(" e ");
                    }
                    i++;
                }
                System.out.println(" sao os maiores produtores de Manofaturas.");
                System.out.println("==================================================================");
            }
        }
    }
    
    public void AdicionarProdutor(Produtor produtor, List<Produtor> listaProdutores) {
        if (listaProdutores.isEmpty()) {       // se nao tiver produtor na lista ja adiciona o primeiro
            listaProdutores.add(produtor);
        } else {             // se tiver ele vai percorrer a lista 
            int tamList = listaProdutores.size(), i = 0;
            for (Produtor prod : listaProdutores) {
                if (prod.getNomeprodutor().equals(produtor.getNomeprodutor())) {  // esta procurando se ja existe o produtor para sair do loop
                    break;
                } else if ((tamList - 1) == i) {   //esta no ultimo elemento da lista e nao achou, entao vai adicionar a lista
                    listaProdutores.add(produtor);
                    break;
                }
                i++;              // indice da lista dos produtores
            }
        }
    }

    @Override
    public String toString() {
        return nomeprodutor;
    }
}
