package example;

import java.io.Serializable;
import java.util.Date;

public class Measurement implements Serializable {

    private Double temperature;
    private Date measurementTime;

    public Measurement(Double temperature, Date measurementTime) {
        this.temperature = temperature;
        this.measurementTime = measurementTime;
    }

    public Measurement() {
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setMeasurementTime(Date measurementTime) {
        this.measurementTime = measurementTime;
    }

    public Date getTime() {
        return measurementTime;
    }
}
