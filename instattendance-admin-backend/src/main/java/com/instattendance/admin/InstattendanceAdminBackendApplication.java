package com.instattendance.admin;

import java.net.InetAddress;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class InstattendanceAdminBackendApplication {

	public static void main(String[] args)throws Exception {
		Properties props = new Properties();
		 props.put("server.address", InetAddress.getLocalHost().getHostAddress());
		 new SpringApplicationBuilder(InstattendanceAdminBackendApplication.class)
         .properties(props).run(args);
		 
		//SpringApplication.run(InstattendanceAdminBackendApplication.class, args);
	}

}
