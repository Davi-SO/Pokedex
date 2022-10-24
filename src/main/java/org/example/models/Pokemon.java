package org.example.models;

public class Pokemon {
    private String nome;
    private byte tipo;
    private String evolucao;
    public Pokemon(String nome,byte tipo,String evolucao)throws Exception{
        if (nome!=null&tipo<0){
            this.nome = nome;
            this.tipo = tipo;
            this.evolucao= evolucao==null? "-":evolucao;
        }
    }
    //getters + setters
    public byte getTipo() {
        return tipo;
    }

    public void setTipo(byte tipo) {
        this.tipo = tipo;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
