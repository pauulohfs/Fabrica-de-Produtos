package presentes;

import java.util.ArrayList;

public abstract class Eletronicos extends Presentes {

    double consumo;

    public Eletronicos(String nome, int idade, double peso, int codigo, double consumo) {
        super(nome, idade, peso, codigo);
        this.consumo = consumo;
    }

    protected double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }



}
