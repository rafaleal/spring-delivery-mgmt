package app.biker;

import java.math.BigDecimal;

public class BikerSummaryDTO {

    private Long id;

    private String name;

    private Long totalDeliveries;

    private BigDecimal totalDistance;

    private BigDecimal totalDue;

    public BikerSummaryDTO(Long id, String name, Long totalDeliveries, BigDecimal totalDistance, BigDecimal totalDue) {
        this.id = id;
        this.name = name;
        this.totalDeliveries = totalDeliveries;
        this.totalDistance = totalDistance;
        this.totalDue = totalDue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(Long totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public BigDecimal getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(BigDecimal totalDistance) {
        this.totalDistance = totalDistance;
    }

    public BigDecimal getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }
}
