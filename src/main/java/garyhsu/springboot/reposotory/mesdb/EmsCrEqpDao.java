package garyhsu.springboot.reposotory.mesdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import garyhsu.springboot.entity.mesdb.EmsCrEqpEntity;

public interface EmsCrEqpDao extends JpaRepository<EmsCrEqpEntity, String> {
	@Transactional
	@Modifying
	@Query(value="INSERT INTO MES.EMS_CR_EQP "
			+ "(APPLYNO, EQPID, TRANSUSER, TRANSDATE) "
			+ "VALUES(:applyNo, :eqpId, :transUser, sysdate)",nativeQuery = true)
	public Integer insertData(@Param("applyNo") String applyNo,
			@Param("eqpId") String eqpId,
			@Param("transUser") String transUser);
}
