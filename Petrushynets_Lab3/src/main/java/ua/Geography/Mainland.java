package ua.Geography;

public class Mainland {
    private int mainlandId;
    private String mainlandName;

    public Mainland(int mainlandId, String mainlandName) {
        this.mainlandId = mainlandId;
        this.mainlandName = mainlandName;
    }

    // Геттери та сеттери
    public int getMainlandId() {
        return mainlandId;
    }

    public void setMainlandId(int mainlandId) {
        this.mainlandId = mainlandId;
    }

    public String getMainlandName() {
        return mainlandName;
    }

    public void setMainlandName(String mainlandName) {
        this.mainlandName = mainlandName;
    }

    @Override
    public String toString() {
        return "Mainland{" +
                "mainlandId=" + mainlandId +
                ", mainlandName='" + mainlandName + '\'' +
                '}';
    }
}
