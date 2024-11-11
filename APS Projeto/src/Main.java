himport Creation.Pokemon;
import Creation.Tipo;
import Interface.StartPage;
import SQL.DAO.SQLCreate;
import SQL.DAO.SQLSelect;

import javax.swing.*;
import java.util.ArrayList;

public class  Main {
    //INICIO DO PROGRAMA
    public static void main(String[] args) {

        //lista os tipos cadastrados na base de dados
        ArrayList<Tipo> tipos = SQLSelect.getTipos();    //lista os tipos cadastrados na base de dados
        if(tipos.size()==0){    //verifica se existealgum tipo cadastrado na base de dados.
            //Caso não existam, vamos cadastrar um novo tipo.
            SQLCreate.createTipo(new Tipo("Fogo","Grama","Água"));
        }
        //lista os pokemons cadastrados na base de dados
        ArrayList<Pokemon> pokemons = SQLSelect.getPokemons();
        if(pokemons.size()==0){ //verifica se existe algum pokemon cadastrado na base de dados
            //Caso não existam, cadastramos um novo Pokemon
            SQLCreate.createPokemon(new Pokemon("Charmander","","Fogo","Fogo"));
        }

        //Inicia a tela inicial do programa, que contém as opções de visualizar, adicionar, editar, e excluir pokemons.  //Página inicial do programa.  //Como o JFrame é um componente gráfico, ele não pode ser criado diretamente no Main, mas sim na thread principal do Java.  //A chamada abaixo é feita na thread principal, para que possamos inicializar o J
        JFrame page = new StartPage();
    }
}