package someidea.test.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import someidea.db.mes.entity.AdmGroupEntity;
import someidea.db.mes.entity.EmsCrEqpEntity;
import someidea.db.mes.reposotory.AdmGroupDao;
import someidea.db.mes.reposotory.EmsCrEqpDao;

@Service

public class TestService {
	@Autowired
	private EmsCrEqpDao dao;
	@Autowired
	private AdmGroupDao groupDao;
	
//	@Autowired
//	@Qualifier("msdbTM")
//	private PlatformTransactionManager tm;
//	
//	public String doTest() {
//        TransactionStatus transactionStatus = tm.getTransaction(new DefaultTransactionDefinition());
//        
//		try {
//			EmsCrEqpEntity entity = new EmsCrEqpEntity();
//			entity.setApplyNo("CRH240101-06");
//			entity.setEqptId("08-01-032-00047");
//			entity.setTransUser("23014021");
//			entity.setTransDate(new Date());
////			dao.save(entity);
////			dao.flush();
//			
//			dao.insertData("CRH240101-06", "08-01-032-00047", "23014021");
//			dao.flush();
//			
//			
//			if(entity.getTransUser().equals("23014021")) {
//				throw new RuntimeException("test roll back");
//			}
//			
//		}catch(Exception e) {
//			tm.rollback(transactionStatus);
//			return e.getMessage();
//		}
//		return "Insert Success";
//	}
	
	@Transactional
	public String doTest() {
		try {
			AdmGroupEntity userGroup = new AdmGroupEntity();
			userGroup.setCdate(new Date());
			userGroup.setCuser("23014021");
			userGroup.setGroupId("TEST_ADM");
			userGroup.setGroupName("TEST_ADM");
			userGroup.setSite("GMH");
			userGroup.setWebGroup("TEST");
			groupDao.save(userGroup);
			groupDao.flush();
			
			EmsCrEqpEntity entity = new EmsCrEqpEntity();
			entity.setApplyNo("CRH240101-06");
			entity.setEqptId("08-01-032-00047");
			entity.setTransUser("23014021");
			entity.setTransDate(new Date());
//			dao.save(entity);
//			dao.flush();
			
			dao.insertData("CRH240101-06", "08-01-032-00047", "23014021");
			dao.flush();
			
			
			if(entity.getTransUser().equals("23014021")) {
				throw new Exception("test roll back");
			}
			
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return e.getMessage();
		}
		return "Insert Success";
	}
	
}
