package p46;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorServiceImpl implements CalculatorService{
	
	private List valueList;
	
	@Override
	public void setValueList(List valueList) {
		// TODO Auto-generated method stub
		Logger logger = LoggerFactory.getLogger("CalculatorServiceImple");
		this.valueList = valueList;
		logger.info("list");
		output();
		
	}
	
	private void output() {
		for(Object el: valueList) {
			System.out.println(el);
		}
	}

}
