package app.details;

import javax.persistence.Embeddable;

/**
 * Created by Rafael Leal on 13/10/2018.
 */
@Embeddable
public class GPS implements Coordinates {

    private Double latitude;

    private Double longitude;

    private GPS() {
    }

    public GPS(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public Double x() {
        return latitude;
    }

    @Override
    public Double y() {
        return longitude;
    }
}