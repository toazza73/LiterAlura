package br.com.alura.LiterAlura.model;

import java.util.List;

public class Response {
   // private int count;
    private List<DadosResult> dadosResults;

    public Response(DadosResponse dadosResponse) {
        //this.count = dadosResponse.contador();
        this.dadosResults = dadosResponse.resultado();
    }

}
