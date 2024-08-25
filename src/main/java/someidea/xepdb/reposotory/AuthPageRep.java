package someidea.xepdb.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import someidea.xepdb.entity.AuthPageEntity;

public interface AuthPageRep extends JpaRepository<AuthPageEntity, String> {

}
