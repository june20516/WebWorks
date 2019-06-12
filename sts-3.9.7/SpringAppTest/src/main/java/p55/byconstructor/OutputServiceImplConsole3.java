package p55.byconstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputServiceImplConsole3 extends OutputServiceImpl3 {
	
	public OutputServiceImplConsole3() {
		// TODO Auto-generated method stub
		Logger logger = LoggerFactory.getLogger("OutputServiceImplConsole3");
		logger.info("아웃풋서비스임플리먼트콘솔3 생성자 실행");
	}
	
}
