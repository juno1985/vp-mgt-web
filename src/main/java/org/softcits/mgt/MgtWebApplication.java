package org.softcits.mgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MgtWebApplication {

	public static void main(String[] args) {
       SpringApplication.run(MgtWebApplication.class, args);
      /*  SpringApplication springApplication = new SpringApplication(MgtWebApplication.class);
        springApplication.addListeners(new VPApplicationStartup());
        springApplication.run(args);*/
    }
}
