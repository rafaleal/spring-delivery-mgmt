package app.details;

import javax.persistence.Embeddable;

/**
 * Created by Rafael Leal on 13/10/2018.
 */
@Embeddable
public class GPS implements Coordinates {

    private double latitude;

    private double longitude;

    private GPS() {
    }

    public GPS(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public double x() {
        return latitude;
    }

    @Override
    public double y() {
        return longitude;
    }
}