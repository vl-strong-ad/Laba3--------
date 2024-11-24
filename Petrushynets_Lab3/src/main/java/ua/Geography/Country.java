package ua.Geography;

public class Country {
    private int countryId;        // Унікальний ідентифікатор країни
    private String countryName;   // Назва країни
    private int population;       // Населення країни

    // Конструктори
    public Country() {
    }

    public Country(int countryId, String countryName, int population) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.population = population;
    }

    // Геттери та сеттери
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", population=" + population +
                '}';
    }
}
