package presentes;

import java.util.ArrayList;

public abstract class Manofatura extends Presentes {

    private Produtor produtor;

    public Manofatura(String nome, int idade, double peso, int codigo, Produtor produtor) {
        super(nome, idade, peso, codigo);
        this.produtor = produtor;
    }


    protected Produtor getProdutor() {
        return produtor;
    }

}
