package whu.yes.hand_hand.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // 标注一个配置类
@EnableSwagger2 // 提供swagger注解
@ComponentScan("whu.yes.hand_hand.controller")//扫描控制器包下的文件
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    //展现API文档的基本信息
    private ApiInfo apiInfo(){
        //联系人信息(展现在主页)
        Contact contact = new Contact("csy",
                "","839454195@qq.com");
        return new ApiInfoBuilder()
                .title("测试swagger")
                .description("测试swagger对于接口的展示和调用")
                .contact(contact)
                .version("1.1.0")
                .build();
    }
}
