package app.biker;

import app.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rafael Leal on 27/10/2018.
 */
@Repository
public interface BikerRepository extends JpaRepository<Biker, Long> {

    List<Biker> findByStatusCode(StatusCode statusCode);

    @Query("SELECT new app.biker.BikerSummaryDTO(" +
            "b.id, " +
            "b.fullName, " +
            "COUNT(d)," +
            "SUM(r.totalDistance)," +
            "SUM(r.totalDue)" +
            ")" +
            " FROM Delivery AS d" +
            " JOIN d.route r" +
            " JOIN d.biker b" +
            " WHERE b.id = :bikerId")
    BikerSummaryDTO getBikerSummary(@Param("bikerId") Long bikerId);

}
