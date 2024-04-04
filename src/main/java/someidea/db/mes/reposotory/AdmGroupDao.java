package someidea.db.mes.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import someidea.db.mes.entity.AdmGroupEntity;

public interface AdmGroupDao extends JpaRepository<AdmGroupEntity, String> {

}
