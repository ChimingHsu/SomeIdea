package garyhsu.springboot.reposotory.mesdb;

import org.springframework.data.jpa.repository.JpaRepository;

import garyhsu.springboot.entity.mesdb.AdmGroupEntity;

public interface AdmGroupDao extends JpaRepository<AdmGroupEntity, String> {

}
