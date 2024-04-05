package someidea.db.xep.reposotory;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import someidea.db.xep.entity.AuthUserEntity;

public interface AuthUserRep extends JpaRepository<AuthUserEntity, BigDecimal> {

}
