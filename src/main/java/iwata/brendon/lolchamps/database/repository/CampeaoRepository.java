package iwata.brendon.lolchamps.database.repository;

import iwata.brendon.lolchamps.database.model.Campeao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampeaoRepository extends JpaRepository<Campeao, Long> {
}
