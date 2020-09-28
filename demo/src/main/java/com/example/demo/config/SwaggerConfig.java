package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Swagger2配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
   //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi(){
    	ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("Authorization").description("user ticket")//Token 以及Authorization 为自定义的参数，session保存的名字是哪个就可以写成那个
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
    	
    	return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")) // 注意修改此处的包名
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    // 预览地址:swagger-ui.html
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Logistics-System-Simulator")
                .description("接口访问地址：http://localhost:8012/")
                .termsOfServiceUrl("http://localhost:8012/swagger-ui.html")
                .version("1.0")
                .build();
    }
}