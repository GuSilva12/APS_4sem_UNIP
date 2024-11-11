package Creation;

import java.util.ArrayList;

public class Tipo {

    //DECLARACAO DE VARIAVEIS
    private String nome;
    private String forc;
    private String fraq;

    //CONSTRUCTORS
    public Tipo(String aNome){
        setNome(aNome);
    };  //inicializa um novo tipo com apenas o nome especificado

    public Tipo(String aNome, String aForc, String aFraq){  //inicializa um novo tipo com nome, forca e fraqueza
        setNome(aNome);
        setForc(aForc);
        setFraq(aFraq);
    };

    //GETTERS E SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }   //define o nome do tipo
    public void setForc(String forc) {
        this.forc = forc;
    }   //define a forca do tipo
    public void setFraq(String fraq) {
        this.fraq = fraq;
    }   //define a fraqueza do tipo
    public String getNome() {
        return nome;
    }   //obtem o nome do tipo
    public String getForc() {
        return forc;
    }   //obtem o forc do tipo
    public String getFraq() {
        return fraq;
    }   //obtem o fraqueza do tipo
}
