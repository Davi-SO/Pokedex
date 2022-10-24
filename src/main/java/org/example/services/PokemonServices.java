package org.example.services;
import java.util.ArrayList;
import java.util.List;
import org.example.models.Pokemon;

import java.sql.*;
public class PokemonServices extends AbstractDatabaseService{
    public ArrayList<Pokemon> pokemon;

    public PokemonServices(String user, String password) {
        super(user, password);
        pokemon = getAllPokemons();
        for (Pokemon p : pokemon){
            System.out.println("Nome: "+p.getNome());
            System.out.println("Evolução:"+p.getEvolucao());
        }
    }
    private ArrayList<Pokemon> getAllPokemons(){
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Pokemon> pokemons = null;
        try {
            stmt = this.conn.createStatement();

            rs = stmt.executeQuery("SELECT * from pokemons;");
            System.out.println(rs.getFetchSize());
            pokemons = new ArrayList<Pokemon>();
            while(rs.next()){
                try{
                    pokemons.add(new Pokemon(
                            rs.getString("nome"),
                            rs.getByte("tipo"),
                            rs.getString("evolucao")
                    ));

                }
                catch(Exception e){
                    System.err.println(e.getMessage());
                    System.err.println("errou");
                }

            }
        }
        catch (SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
        }
        return pokemons;
    }
    private void loadInitial151(){
        Statement s = null;
        try{
        s = this.conn.createStatement();
        s.addBatch("CREATE DATABASE pokeDB");
        s.addBatch("USE pokeDB");
        s.addBatch("CREATE table Tipos(\n" +
                "\tID_TIPO int(15) primary key,\n" +
                "    TIPO varchar(20)\n" +
                ");");
        s.addBatch("CREATE table Pokemons(\n" +
                "  ID_POKEMON int auto_increment primary key,\n" +
                "  NOME varchar(15) not null,\n" +
                "  TIPO int(15),\n" +
                "  EVOLUCAO varchar(15),\n" +
                "  foreign key (TIPO) references Tipos(ID_TIPO)\n" +
                ")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(01,\"Fogo\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(02,\"Água\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(03,\"Planta\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(04,\"Elétrico\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(05,\"Pedra\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(06,\"Terra\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(07,\"Normal\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(08,\"Gelo\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(09,\"Psíquico\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(10,\"Dragão\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(11,\"Lutador\")");
        s.addBatch("INSERT INTO Tipos(ID_TIPO,TIPO) VALUES(12,\"Voador\")");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        s.addBatch("");
        }catch(Exception e){}
    }
}
