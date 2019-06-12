package greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value="outputter")
public class OutputServiceImplConsole extends OutputServiceImpl {
	
	public OutputServiceImplConsole() {
		// TODO Auto-generated method stub
		Logger logger = LoggerFactory.getLogger("OutputServiceImplConsole");
		logger.info("아웃풋서비스임플리먼트콘솔 생성자 실행");
	}
	
}
