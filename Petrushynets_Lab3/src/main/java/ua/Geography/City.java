package ua.Geography;

public class City {
    private int city_id; // Унікальний ідентифікатор міста
    private String city_name; // Назва міста

    // Конструктори
    public City() {
    }

    public City(int city_id, String city_name) {
        this.city_id = city_id;
        this.city_name = city_name;
    }

    // Геттери та сеттери
    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    // Метод для зручного відображення міста
    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
