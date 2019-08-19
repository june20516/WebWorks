package com.bit2;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ShRunnerTest {

    ShRunner shRunner = new ShRunner();
    
    
    @RequestMapping("test")
    public String  home() throws IOException, InterruptedException {
    	String procPath = System.getProperty("user.dir") + "./src/main/python/ImageProcessor/"; //프로젝트까지의 경로
    	String procShPath = procPath+"imgProcessor.sh"; 
    	String inputPath = procPath+"sample.jpg";
		String outputPath = procPath+"sample_output.png";
		
		shRunner.shRun(procShPath, inputPath, outputPath);
		
//		String cmds = "sh "+procShPath + " " + inputPath + " " + outputPath;
//		String[] callCmd = { cmds};
//		Map map = shRunner.execCommand(callCmd);
//		System.out.println(map);
		return "test";
    }
}