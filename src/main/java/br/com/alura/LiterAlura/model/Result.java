package br.com.alura.LiterAlura.model;
import java.util.List;
import java.util.Map;

public class Result {
    private int id;
    private String title;
    private List<DadosAuthor> dadosAuthors;
    private List<Object> translators;
    private List<String> subjects;
    private List<Object> bookshelves;
    private List<String> languages;
    private boolean copyright;
    private String media_type;
    private Map<String, String> formats;
    private int download_count;

    public Result(DadosResult dadosResult) {
        this.id = dadosResult.id();
        this.title = dadosResult.titulo();
        this.dadosAuthors = dadosResult.autor();
        this.languages = dadosResult.linguas();
        this.download_count = dadosResult.download();
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<DadosAuthor> getAuthors() { return dadosAuthors; }
    public void setAuthors(List<DadosAuthor> authors) { this.dadosAuthors = authors; }

    public List<String> getLanguages() { return languages; }
    public void setLanguages(List<String> languages) { this.languages = languages; }

    public int getDownload_count() { return download_count; }
    public void setDownload_count(int download_count) { this.download_count = download_count; }
}
