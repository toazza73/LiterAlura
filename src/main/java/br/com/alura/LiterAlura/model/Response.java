package br.com.alura.LiterAlura.model;

import java.util.List;

public class Response {
    private int count;
    private List<Result> results;

    // Getters and Setters
    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public List<Result> getResults() { return results; }
    public void setResults(List<Result> results) { this.results = results; }
}
