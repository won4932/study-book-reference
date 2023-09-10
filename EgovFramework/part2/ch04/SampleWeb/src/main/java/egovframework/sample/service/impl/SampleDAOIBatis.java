package egovframework.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.sample.service.SampleDAO;
import egovframework.sample.service.SampleVO;

@Repository("daoIBatis")
public class SampleDAOIBatis extends EgovAbstractDAO implements SampleDAO {

	public SampleDAOIBatis() {
		System.out.println("===> SampleDAOIBatis 생성");
	}
	
	public void insertSample(SampleVO vo) throws Exception {
		System.out.println("===> iBATIS로 insertSample() 기능 처리");
		insert("SampleDAO.insertSample", vo);
	}
	
	public void updateSample(SampleVO vo) throws Exception {
		System.out.println("===> iBATIS로 updateSample() 기능 처리");
		update("SampleDAO.updateSample", vo);
	}
	
	public void deleteSample(SampleVO vo) throws Exception {
		System.out.println("===> iBATIS로 deleteSample() 기능 처리");
		delete("SampleDAO.deleteSample", vo);
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception {
		System.out.println("===> iBATIS로 selectSample() 기능 처리");
		return (SampleVO) select("SampleDAO.selectSample", vo);
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) 
								throws Exception {
	      System.out.println("===> iBATIS로 selectSampleList() 기능 처리");
	      return (List<SampleVO>) list("SampleDAO.selectSampleList", vo);
	}
}
