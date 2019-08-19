package com.bit2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	    public Map execCommand(String... str) {
	        Map<Integer, String> map = new HashMap<>();
	        ProcessBuilder pb = new ProcessBuilder(str);
	        pb.redirectErrorStream(true);
	        Process process = null;
	        try {
	            process = pb.start();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        BufferedReader reader = null;
	        if (process != null) {
	            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        }

	        String line;
	        StringBuilder stringBuilder = new StringBuilder();
	        try {
	            if (reader != null) {
	                while ((line = reader.readLine()) != null) {
	                    stringBuilder.append(line).append("\n");
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        try {
	            if (process != null) {
	                process.waitFor();
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        if (process != null) {
	            map.put(0, String.valueOf(process.exitValue()));
	        }

	        try {
	            map.put(1, stringBuilder.toString());
	        } catch (StringIndexOutOfBoundsException e) {
	            if (stringBuilder.toString().length() == 0) {
	                return map;
	            }
	        }
	        return map;
	    }
	    
	    public void shRun(String param1, String param2, String param3){
			
			Runtime rt = Runtime.getRuntime();
			Process proc = null;
			InputStream is = null;
			BufferedReader bf = null;
			
			logger.info("info param1:: " + param1);
			
			try {
				String[] cmd = {
						param1
						, param2
						, param3
				};
							
				proc = rt.exec(cmd);
				proc.getInputStream();
				is = proc.getInputStream();
				bf = new BufferedReader(new InputStreamReader(is));
				
				while (true) {
					String info = bf.readLine();
					if(info == null || info.equals("")){
						break;
					}
					logger.info("info :: " + info);
				}
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
	
}
