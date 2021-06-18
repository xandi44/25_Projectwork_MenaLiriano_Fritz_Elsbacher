package sample.bll;

public class City {
    int id;
    String name;
    Country country;
    int einwohner;
    int flaeche;
    int seehohe;
    String webseite;

    public City(int id, String name, Country country, int einwohner, int flaeche, int seehohe, String webseite) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.einwohner = einwohner;
        this.flaeche = flaeche;
        this.seehohe = seehohe;
        this.webseite = webseite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getEinwohner() {
        return einwohner;
    }

    public void setEinwohner(int einwohner) {
        this.einwohner = einwohner;
    }

    public int getFlaeche() {
        return flaeche;
    }

    public void setFlaeche(int flaeche) {
        this.flaeche = flaeche;
    }

    public int getSeehohe() {
        return seehohe;
    }

    public void setSeehohe(int seehohe) {
        this.seehohe = seehohe;
    }

    public String getWebseite() {
        return webseite;
    }

    public void setWebseite(String webseite) {
        this.webseite = webseite;
    }

    @Override
    public String toString() {
        return name;
    }
}
