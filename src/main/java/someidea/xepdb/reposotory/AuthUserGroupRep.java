package someidea.xepdb.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import someidea.xepdb.entity.AuthUserGroupEntity;
import someidea.xepdb.entity.id.AuthUserGroupId;

public interface AuthUserGroupRep extends JpaRepository<AuthUserGroupEntity, AuthUserGroupId> {
}
