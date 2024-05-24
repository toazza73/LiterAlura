package br.com.alura.LiterAlura.model;
public class Author {
    private String name;
    private int birth_year;
    private int death_year;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getBirth_year() { return birth_year; }
    public void setBirth_year(int birth_year) { this.birth_year = birth_year; }

    public int getDeath_year() { return death_year; }
    public void setDeath_year(int death_year) { this.death_year = death_year; }

    @Override
    public String toString() {
        return  name + '\n' +
                "Ano Nasc. = " + birth_year + '\n' +
                "Ano Fal. = " + death_year;
    }
}
