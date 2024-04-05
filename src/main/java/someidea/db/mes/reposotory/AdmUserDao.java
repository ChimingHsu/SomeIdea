package someidea.db.mes.reposotory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import someidea.db.mes.entity.AdmUserEntity;

public interface AdmUserDao extends JpaRepository<AdmUserEntity, String> {
	public Optional<AdmUserEntity> findByUserNo(String userNo);
}
