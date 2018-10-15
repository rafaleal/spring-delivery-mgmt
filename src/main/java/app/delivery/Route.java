package app.delivery;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Rafael Leal on 12/10/2018.
 */
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long totalDistance;

    private Long sumTotal;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Point> points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Long totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Long getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(Long sumTotal) {
        this.sumTotal = sumTotal;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
