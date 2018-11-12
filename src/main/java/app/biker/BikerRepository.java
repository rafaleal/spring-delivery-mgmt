package app.biker;

import app.biker.dto.BikerSummaryDTO;
import app.enums.StatusCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rafael Leal on 27/10/2018.
 */
@Repository
public interface BikerRepository extends JpaRepository<Biker, Long> {

    List<Biker> findByStatusCode(StatusCode statusCode);

    @Query("SELECT new app.biker.dto.BikerSummaryDTO(" +
            "b.id, " +
            "b.fullName, " +
            "b.cpf, " +
            "b.address," +
            "b.phone," +
            "b.email, " +
            "b.createdAt, " +
            "COUNT(d), " +
            "SUM(r.totalDistance), " +
            "SUM(r.totalDue)" +
            ")" +
            " FROM Delivery AS d" +
            " LEFT JOIN d.route r" +
            " LEFT JOIN d.biker b" +
            " WHERE b.statusCode = 'A'" +
            " GROUP BY b.id")
    List<BikerSummaryDTO> getAllActiveBikersSummary();

}
