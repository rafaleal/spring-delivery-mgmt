package app.biker.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BikerSummaryDTO {

    private Long id;

    private String name;

    private String cpf;

    private String address;

    private String phone;

    private String email;

    private LocalDateTime createdAt;

    private Long totalDeliveries;

    private BigDecimal totalDistance;

    private BigDecimal totalDue;

    public BikerSummaryDTO(Long id, String name, String cpf, String address, String phone, String email, LocalDateTime createdAt, Long totalDeliveries, BigDecimal totalDistance, BigDecimal totalDue) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.createdAt = createdAt;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
