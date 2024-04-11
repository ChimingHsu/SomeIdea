package someidea.xepdb.reposotory;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import someidea.xepdb.entity.AuthUserEntity;

public interface AuthUserRep extends JpaRepository<AuthUserEntity, BigDecimal> {
	Optional<AuthUserEntity> findByUserName(String userName);
}
