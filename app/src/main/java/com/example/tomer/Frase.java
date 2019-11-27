package com.example.tomer;

public class Frase {

    private int id;
    private String conteudo;
    private int pontos;

    public Frase(int id, String conteudo, int pontos) {
        this.id = id;
        this.conteudo = conteudo;
        this.pontos = pontos;
    }

    public Frase() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }


}
