package Creation;

public class Pokemon {

    //DECLARACAO DE VARIAVEIS
    String nome;
    String tipo1;
    String tipo2;
    String desc;

    //CONSTRUCTORS
    //constructor padrao
    public Pokemon(String aNome){
        setNome(aNome);
    }

    //constructor com um Nome e uma Descricao
    public Pokemon(String aNome, String aDesc){
        setNome(aNome);
        setDesc(aDesc);
    }

    //constructor com Nome, Tipo 1 e Tipo 2
    public Pokemon(String aNome, String aTp1, String aTp2){
        setNome(aNome);
        setTipo1(aTp1);
        setTipo2(aTp2);
    }

    //constructor com Nome, Descricao, Tipo 1 e Tipo 2
    public Pokemon(String aNome, String aDesc, String aTp1, String aTp2){
        setNome(aNome);
        setDesc(aDesc);
        setTipo1(aTp1);
        setTipo2(aTp2);
    }

    //GETTERS E SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }   //define o nome do objeto
    public String getNome() {
        return nome;
    }   //obtém o nome do objeto

    public void setDesc(String desc) {
        this.desc = desc;
    }   //define o nome do objeto
    public String getDesc() {
        return desc;
    }   //obtém o nome do objeto

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }   //define o nome do objeto
    public String getTipo1() {
        return tipo1;
    }   //obtém o nome do objeto

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }   //define o nome do objeto
    public String getTipo2() {
        return tipo2;
    }   //obtém o nome do objeto

    //OVERRIDE - TO STRING
    //retorna uma String representando o objeto Pokemon com todos os seus dados.
    @Override
    public String toString() {
        String res = "Nome: " + getNome();
        if (this.tipo1 != null){
            res += "\nTipo 1: " + tipo1;
        }
        if (this.tipo2 != null){
            res += "\nTipo 2: " + tipo2;
        }
        res += "\nDescricao: " + this.desc;
        return res;
    }
}
