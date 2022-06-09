import java.util.Date;

public class electronicCard {

    public String series_reference;
    public Date period;
    public float data_value;
    public boolean supressed;
    public char status;
    public String units;
    public String subject;
    public String group;
    public String series_title1;
    public String series_title2;
    public String series_title3;
    public String series_title4;
    public String series_title5;

    public electronicCard(String series_reference, Date period, float data_value, boolean supressed, char status, String units, String subject, String group, String series_title1, String series_title2, String series_title3, String series_title4, String series_title5) {
        this.series_reference = series_reference;
        this.period = period;
        this.data_value = data_value;
        this.supressed = supressed;
        this.status = status;
        this.units = units;
        this.subject = subject;
        this.group = group;
        this.series_title1 = series_title1;
        this.series_title2 = series_title2;
        this.series_title3 = series_title3;
        this.series_title4 = series_title4;
        this.series_title5 = series_title5;
    }

    public electronicCard(){
        // Es recomendable que se cree un constructor vacio.
    }

    public String getSeries_reference() {
        return series_reference;
    }

    public void setSeries_reference(String series_reference) {
        this.series_reference = series_reference;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public float getData_value() {
        return data_value;
    }

    public void setData_value(float data_value) {
        this.data_value = data_value;
    }

    public boolean isSupressed() {
        return supressed;
    }

    public void setSupressed(boolean supressed) {
        this.supressed = supressed;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSeries_title1() {
        return series_title1;
    }

    public void setSeries_title1(String series_title1) {
        this.series_title1 = series_title1;
    }

    public String getSeries_title2() {
        return series_title2;
    }

    public void setSeries_title2(String series_title2) {
        this.series_title2 = series_title2;
    }

    public String getSeries_title3() {
        return series_title3;
    }

    public void setSeries_title3(String series_title3) {
        this.series_title3 = series_title3;
    }

    public String getSeries_title4() {
        return series_title4;
    }

    public void setSeries_title4(String series_title4) {
        this.series_title4 = series_title4;
    }

    public String getSeries_title5() {
        return series_title5;
    }

    public void setSeries_title5(String series_title5) {
        this.series_title5 = series_title5;
    }
}
