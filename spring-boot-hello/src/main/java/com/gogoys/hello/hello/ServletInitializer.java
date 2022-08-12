package com.gogoys.hello.hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/*
 SpringBootServletInitializer 클래스
 Boot Project에서 root-context.xml, servlet-context.xml을 대신하는 클래스로서
 여기에서 HelloApllication.class.main() method를 호출한다
 */

/*
 ComponentScan
 Anotation을 이용하여 Class를 Scan하여 bean으로 생성하도록 하는 지시어
 여러개의 Scan이 필요할 경우 문자열배열을 사용하여 주입한다.
 */
@ComponentScan({"com.gogoys.hello.controller","com.gogoys.hello.service"})
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HelloApplication.class);
	}

}
