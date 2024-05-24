package br.com.alura.LiterAlura.model;
import java.util.List;
import java.util.Map;

public class Result {
    private int id;
    private String title;
    private List<Author> authors;
    private List<Object> translators;
    private List<String> subjects;
    private List<Object> bookshelves;
    private List<String> languages;
    private boolean copyright;
    private String media_type;
    private Map<String, String> formats;
    private int download_count;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<Author> getAuthors() { return authors; }
    public void setAuthors(List<Author> authors) { this.authors = authors; }

    public List<Object> getTranslators() { return translators; }
    public void setTranslators(List<Object> translators) { this.translators = translators; }

    public List<String> getSubjects() { return subjects; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }

    public List<Object> getBookshelves() { return bookshelves; }
    public void setBookshelves(List<Object> bookshelves) { this.bookshelves = bookshelves; }

    public List<String> getLanguages() { return languages; }
    public void setLanguages(List<String> languages) { this.languages = languages; }

    public boolean isCopyright() { return copyright; }
    public void setCopyright(boolean copyright) { this.copyright = copyright; }

    public String getMedia_type() { return media_type; }
    public void setMedia_type(String media_type) { this.media_type = media_type; }

    public Map<String, String> getFormats() { return formats; }
    public void setFormats(Map<String, String> formats) { this.formats = formats; }

    public int getDownload_count() { return download_count; }
    public void setDownload_count(int download_count) { this.download_count = download_count; }

    @Override
    public String toString() {
        return  "Título = " + title + '\n' +
                "Autor = " + authors + '\n' +
                "Idioma = " + languages;
    }
}
