package ua.Geography;

public class CommandParser {
    private final CityDAO cityDAO = new CityDAO();
    private final CountryDAO countryDAO = new CountryDAO();
    private final MainlandDAO mainlandDAO = new MainlandDAO();

    public void executeCommand(String command) {
        try {
            // Работа с городами (City)
            if (command.startsWith("insert city")) {
                String[] parts = command.split(", ");
                int city_id = Integer.parseInt(parts[0].split("=")[1]);
                String city_name = parts[1].split("=")[1].replace("'", "");
                cityDAO.insertCity(city_id, city_name);
            } else if (command.startsWith("update city")) {
                String[] parts = command.split(", ");
                int city_id = Integer.parseInt(parts[0].split("=")[1]);
                String city_name = parts[1].split("=")[1].replace("'", "");
                cityDAO.updateCity(city_id, city_name);
            } else if (command.startsWith("delete city")) {
                int city_id = Integer.parseInt(command.split("=")[1]);
                cityDAO.deleteCity(city_id);
            } else if (command.equalsIgnoreCase("read city")) {
                cityDAO.getAllCities();
            }

            // Работа со странами (Country)
            else if (command.startsWith("insert country")) {
                String[] parts = command.split(", ");
                int country_id = Integer.parseInt(parts[0].split("=")[1]);
                char country_name = parts[1].split("=")[1].replace("'", "").charAt(0);
                int population = Integer.parseInt(parts[2].split("=")[1]);
                countryDAO.insertCountry(country_id, country_name, population);
            } else if (command.startsWith("update country")) {
                String[] parts = command.split(", ");
                int country_id = Integer.parseInt(parts[0].split("=")[1]);
                char country_name = parts[1].split("=")[1].replace("'", "").charAt(0);
                int population = Integer.parseInt(parts[2].split("=")[1]);
                countryDAO.updateCountry(country_id, country_name, population);
            } else if (command.startsWith("delete country")) {
                int country_id = Integer.parseInt(command.split("=")[1]);
                countryDAO.deleteCountry(country_id);
            } else if (command.equalsIgnoreCase("read country")) {
                countryDAO.getAllCountries();
            }

            // Работа с материками (Mainland)
            else if (command.startsWith("insert mainland")) {
                String[] parts = command.split(", ");
                int mainland_id = Integer.parseInt(parts[0].split("=")[1]);
                char mainland_name = parts[1].split("=")[1].replace("'", "").charAt(0);
                mainlandDAO.insertMainland(mainland_id, mainland_name);
            } else if (command.startsWith("update mainland")) {
                String[] parts = command.split(", ");
                int mainland_id = Integer.parseInt(parts[0].split("=")[1]);
                char mainland_name = parts[1].split("=")[1].replace("'", "").charAt(0);
                mainlandDAO.updateMainland(mainland_id, mainland_name);
            } else if (command.startsWith("delete mainland")) {
                int mainland_id = Integer.parseInt(command.split("=")[1]);
                mainlandDAO.deleteMainland(mainland_id);
            } else if (command.equalsIgnoreCase("read mainland")) {
                mainlandDAO.getAllMainlands();
            } else {
                System.out.println("Unknown command: " + command);
            }
        } catch (Exception e) {
            System.err.println("Error processing command: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
