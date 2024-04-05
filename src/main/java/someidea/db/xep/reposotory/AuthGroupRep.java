package someidea.db.xep.reposotory;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import someidea.db.xep.entity.AuthGroupEntity;

public interface AuthGroupRep extends JpaRepository<AuthGroupEntity, BigDecimal> {

}
