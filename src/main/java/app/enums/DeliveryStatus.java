package app.enums;

/**
 * Created by Rafael Leal on 13/10/2018.
 */
public enum DeliveryStatus {
    REGISTERED("REGISTERED"),
    ONGOING("ONGOING"),
    COMPLETED("COMPLETED")
    ;

    private final String text;

    DeliveryStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
