package someidea.xepdb.reposotory;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import someidea.xepdb.entity.AuthGroupEntity;

public interface AuthGroupRep extends JpaRepository<AuthGroupEntity, BigDecimal> {
	@Query(value="select * from auth_group where group_name in (select group_name from auth_user_group where user_name =:userName)"
			,nativeQuery = true)
	public List<AuthGroupEntity> findAllByUserName(@Param("userName")String userName);
}	
