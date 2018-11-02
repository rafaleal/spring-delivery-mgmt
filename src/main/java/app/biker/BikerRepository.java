package app.biker;

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

    @Query("SELECT b FROM Biker b WHERE b.statusCode= :statCd")
    List<Biker> findAllActive(@Param("statCd") String statCd);
}
