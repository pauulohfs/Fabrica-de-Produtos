package presentes.carregarArq;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import presentes.BolinhaPuff;
import presentes.DroneCop;
import presentes.EspadaPau;
import presentes.Presentes;
import presentes.LanitaControladora;
import presentes.LaraLarinha;
import presentes.LiliAlegre;
import presentes.MegaCao;
import presentes.MiniGame;
import presentes.PedraVoadora;
import presentes.Produtor;
import presentes.RoboX;
import presentes.insumos.Estoque;
import presentes.insumos.ItensEstoque;

public class PegarTXT {

    public static void carregarEstoque(Estoque estoque) {
        try {
            String nomeInsumo;
            int qtdInsumo;
            System.out.println("==============================================");
            System.out.println("Estoque:");
            FileInputStream arquivoEstoque = new FileInputStream("estoque.txt");
            Scanner leitor = new Scanner(arquivoEstoque);
            while (leitor.hasNext()) {
                nomeInsumo = leitor.next();
                qtdInsumo = leitor.nextInt();
                System.out.println(nomeInsumo + "\t\t" + qtdInsumo);
                ItensEstoque novoItem = new ItensEstoque(nomeInsumo, qtdInsumo);
                estoque.adicionarItem(novoItem);
            }
            leitor.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
        }
    }

    public static void carregarPresentesProdutores(List<Presentes> listapresentes, List<Produtor> listaprodutores) throws IOException {
        try {
            String nomeProdutor, nomePresente;
            int codigoPresente, pesoPresente, prodDiaria, idadeMinima = 0;
            double consumoKW = 0;
            System.out.println("==============================================");
            System.out.println("Presentes a serem produzidos:");
            FileInputStream arquivoPresentes = new FileInputStream("presentes.txt");
            Scanner leitor = new Scanner(arquivoPresentes);
            if (leitor.hasNext()) {
                prodDiaria = leitor.nextInt();
                System.out.println(prodDiaria);
                for (int i = 0; i < prodDiaria; i++) {
                    if (leitor.hasNextInt()) {
                        codigoPresente = leitor.nextInt();
                        if (codigoPresente >= 1 && codigoPresente <= 5) {
                            pesoPresente = leitor.nextInt();
                            switch (codigoPresente) {
                                case 1 -> {
                                    nomePresente = "MiniGame";
                                    idadeMinima = 10;
                                    consumoKW = 25;
                                    System.out.println(codigoPresente + "\t" + pesoPresente);
                                    Presentes minigame = new MiniGame(nomePresente, idadeMinima, pesoPresente, codigoPresente, consumoKW);
                                    listapresentes.add(minigame);
                                }
                                case 2 -> {
                                    nomePresente = "DroneCop";
                                    idadeMinima = 18;
                                    consumoKW = 100;
                                    System.out.println(codigoPresente + "\t" + pesoPresente);
                                    Presentes dronecop = new DroneCop(nomePresente, idadeMinima, pesoPresente, codigoPresente, consumoKW);
                                    listapresentes.add(dronecop);
                                }
                                case 3 -> {
                                    nomePresente = "RoboX";
                                    idadeMinima = 14;
                                    consumoKW = 50;
                                    System.out.println(codigoPresente + "\t" + pesoPresente);
                                    Presentes robox = new RoboX(nomePresente, idadeMinima, pesoPresente, codigoPresente, consumoKW);
                                    listapresentes.add(robox);
                                }
                                case 4 -> {
                                    nomePresente = "PedraVoadora";
                                    idadeMinima = 15;
                                    consumoKW = 40;
                                    System.out.println(codigoPresente + "\t" + pesoPresente);
                                    Presentes pedravoadora = new PedraVoadora(nomePresente, idadeMinima, pesoPresente, codigoPresente, consumoKW);
                                    listapresentes.add(pedravoadora);
                                }
                                case 5 -> {
                                    nomePresente = "LanitaControladora";
                                    idadeMinima = 16;
                                    consumoKW = 10;
                                    System.out.println(codigoPresente + "\t" + pesoPresente);
                                    Presentes lanitacontroladora = new LanitaControladora(nomePresente, idadeMinima, pesoPresente, codigoPresente, consumoKW);
                                    listapresentes.add(lanitacontroladora);
                                }
                                default -> {
                                }
                            }
                        } else {
                            pesoPresente = leitor.nextInt();
                            nomeProdutor = leitor.next();
                            System.out.println(codigoPresente + "\t" + pesoPresente + "\t" + nomeProdutor);
                            switch (codigoPresente) {
                                case 6 -> {
                                    nomePresente = "BolinhaPuff";
                                    Produtor produtor1 = new Produtor(nomeProdutor);
                                    produtor1.AdicionarProdutor(produtor1, listaprodutores);
                                    Presentes bolinhapuff = new BolinhaPuff(nomePresente, idadeMinima, pesoPresente, codigoPresente, produtor1);
                                    listapresentes.add(bolinhapuff);
                                }
                                case 7 -> {
                                    nomePresente = "EspadaPau";
                                    Produtor produtor2 = new Produtor(nomeProdutor);
                                    produtor2.AdicionarProdutor(produtor2, listaprodutores);
                                    Presentes espadapau = new EspadaPau(nomePresente, idadeMinima, pesoPresente, codigoPresente, produtor2);
                                    listapresentes.add(espadapau);
                                }
                                case 8 -> {
                                    nomePresente = "LaraLarinha";
                                    Produtor produtor3 = new Produtor(nomeProdutor);
                                    produtor3.AdicionarProdutor(produtor3, listaprodutores);
                                    Presentes laralarinha = new LaraLarinha(nomePresente, idadeMinima, pesoPresente, codigoPresente, produtor3);
                                    listapresentes.add(laralarinha);
                                }
                                case 9 -> {
                                    nomePresente = "MegaCao";
                                    Produtor produtor4 = new Produtor(nomeProdutor);
                                    produtor4.AdicionarProdutor(produtor4, listaprodutores);
                                    Presentes megacao = new MegaCao(nomePresente, idadeMinima, pesoPresente, codigoPresente, produtor4);
                                    listapresentes.add(megacao);
                                }
                                case 10 -> {
                                    nomePresente = "LiliAlegre";
                                    Produtor produtor5 = new Produtor(nomeProdutor);
                                    produtor5.AdicionarProdutor( produtor5, listaprodutores);
                                    Presentes lilialegre = new LiliAlegre(nomePresente, idadeMinima, pesoPresente, codigoPresente, produtor5);
                                    listapresentes.add(lilialegre);
                                }
                                default -> {
                                }
                            }
                        }
                    }
                }
            }
            arquivoPresentes.close();
            System.out.println("==============================================");
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo nao encontrado");
        }
    }
}
