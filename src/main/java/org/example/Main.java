package org.example;

import org.example.models.Pokemon;
import org.example.services.PokemonServices;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PokemonServices pokemons = new PokemonServices("root","MysqlloginPWD123@");
        for (Pokemon p : pokemons.pokemon){
            System.out.println("Nome: "+p.getNome());
            System.out.println("Evolução:"+p.getEvolucao());
        }


    }
}