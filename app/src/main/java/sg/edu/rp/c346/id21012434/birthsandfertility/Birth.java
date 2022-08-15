package sg.edu.rp.c346.id21012434.birthsandfertility;

public class Birth {
    private String level_1;
    private String value;
    private String year;

    public Birth( String level_1, String value, String year) {
        this.level_1 = level_1;
        this.value = value;
        this.year = year;
    }

    public String getLevel_1() {
        return level_1;
    }

    public void setLevel_1(String level_1) {
        this.level_1 = level_1;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Title: Birth{" + '\n' +
                " level_1='" + level_1 + '\n' +
                ", value='" + value + '\n' +
                ", year='" + year + '}';

    }
}
