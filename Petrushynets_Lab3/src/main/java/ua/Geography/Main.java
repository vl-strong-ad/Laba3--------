package ua.Geography;

public class Main {
    private int cityId;       // Унікальний ідентифікатор міста
    private String cityName;  // Назва міста

    // Конструктори
    public Main() {
    }

    public Main(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    // Геттери та сеттери
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    // Метод для зручного виводу об'єкта
    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Робота з CityDAO
        CityDAO cityDAO = new CityDAO();

        System.out.println("=== Робота з містами ===");
        // Додавання міста
        cityDAO.insertCity(1, "Kyiv");

        // Виведення всіх міст
        System.out.println("Список міст:");
        cityDAO.getAllCities();

        // Оновлення назви міста
        cityDAO.updateCity(1, "Lviv");
        System.out.println("Назву міста оновлено.");

        // Видалення міста
        cityDAO.deleteCity(1);
        System.out.println("Місто видалено.");

        // Робота з CountryDAO
        CountryDAO countryDAO = new CountryDAO();

        System.out.println("\n=== Робота з країнами ===");
        // Додавання країни
        countryDAO.insertCountry(1, "Ukraine", 41000000);

        // Виведення всіх країн
        System.out.println("Список країн:");
        countryDAO.getAllCountries();

        // Оновлення даних про країну
        countryDAO.updateCountry(1, "Ukraine", 42000000);
        System.out.println("Дані країни оновлено.");

        // Видалення країни
        countryDAO.deleteCountry(1);
        System.out.println("Країну видалено.");

        // Робота з MainlandDAO
        MainlandDAO mainlandDAO = new MainlandDAO();

        System.out.println("\n=== Робота з материками ===");
        // Додавання материка
        mainlandDAO.insertMainland(1, 'A'); // Наприклад, материк "Азія"
        mainlandDAO.insertMainland(2, 'E'); // Наприклад, материк "Європа"

        // Виведення всіх материків
        System.out.println("Список материків:");
        mainlandDAO.getAllMainlands();

        // Оновлення даних про материк
        mainlandDAO.updateMainland(1, 'B'); // Наприклад, оновлення до "Балкан"
        System.out.println("Дані материка оновлено.");

        // Видалення материка
        mainlandDAO.deleteMainland(2);
        System.out.println("Материк видалено.");
    }
}
