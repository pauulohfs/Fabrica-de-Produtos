package presentes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import presentes.insumos.Estoque;
import presentes.carregarArq.PegarTXT;

public class LinhaDeProducao {

    public static void main(String[] args) throws IOException {
        Estoque estoque = new Estoque();

        List<Presentes> linhaDeProducao = new ArrayList<>();
        List<Presentes> presentesProduzidos = new ArrayList<>();
        List<Produtor> listaProdutores = new ArrayList<>();

        PegarTXT.carregarEstoque(estoque);
        PegarTXT.carregarPresentesProdutores(linhaDeProducao, listaProdutores);
        int dias = LinhaDeProducao.producaoPresentes(estoque, linhaDeProducao, presentesProduzidos, listaProdutores);
        System.out.println("==================================================================");
        if(dias == 1){
            System.out.println("Estoque dura " + dias + " dia.");    
        }else{
            System.out.println("Estoque dura " + dias + " dias.");
        }
        System.out.println("==================================================================");
        Produtor.printMaiorProdutor(listaProdutores);
        Presentes.TipoPresentes(linhaDeProducao);
    }

    public static int producaoPresentes(Estoque estoque, List<Presentes> listapresentes, List<Presentes> presentesProduzidos, List<Produtor> listaProdutores) {
        boolean insumos = true;
        int dia = 1, producaoDiaria = 0;
        double totalPeso = 0;   
        while (insumos != false) {
            for (Presentes presente : listapresentes) {
                Presentes novoPresente = presente.Produzir(estoque, listaProdutores); // vou ter q passar a lista de produtores aqui 
                if (novoPresente != null) {
                    presentesProduzidos.add(novoPresente);
                    totalPeso = totalPeso + novoPresente.getPeso();
                    producaoDiaria++;
                } else {                   //quando retornar novoPresente null foi porque falta insumo no estoque
                    insumos = false;
                    if(dia==1){      // printa totalpesos if producaodiaria < 11 e estoque acabar
                        System.out.println("==================================================================");
                        System.out.println("O total de pesos eh " + totalPeso + " gramas.");  
                    }
                    break;
                }
                if (producaoDiaria == 11) {
                    producaoDiaria = 0;
                    if(dia==1){
                        System.out.println("O total de pesos eh " + totalPeso + " gramas.");  // printa totalpesos de 1 dia de producao
                        System.out.println("==================================================================");
                    }
                    dia++;
                }
            }
        } 
        return dia;
    }
}
