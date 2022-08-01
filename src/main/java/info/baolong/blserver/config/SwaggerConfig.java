package info.baolong.blserver.config;

//import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;


//@EnableKnife4j
//@EnableSwagger2	   //开启 Swagger2
@EnableOpenApi // 开启Swagger3 可以不写
@Configuration // 开启knife4j 可以不写
public class SwaggerConfig {


//    @Bean
//    public Docket systemApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .groupName("小明童鞋demo")
//                .genericModelSubstitutes(DeferredResult.class).useDefaultResponseMessages(false).forCodeGeneration(true)
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                // 这里写controller 所在的路径
//                .apis(RequestHandlerSelectors.basePackage("club.beimeng.book_manage_keshe.controller"))
//                .paths(PathSelectors.any()).build()
//                .pathMapping("/")
//                // 暂时不加权限认证
////                .securitySchemes(Collections.singletonList(securitySchema()))
////                .securityContexts(Collections.singletonList(securityContext()))
//                .apiInfo(apiInfo());
//    }

        /**
         * 添加摘要信息
         * @return 返回ApiInfo对象
         */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("图书管理系统测试文档")
                // 服务条款
                .termsOfServiceUrl("NO terms of service")
                // 描述
                .description("这是SWAGGER_3生成的接口文档")
                // 作者信息
                .contact(new Contact("github地址", "https://github.com/MrBeiMeng/book_manage_keshe/settings/access", "1192384722@qq.com"))
                // 版本
                .version("版本号:V1.0")
                //协议
                .license("The Apache License")
                // 协议url
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        // Swagger 2 使用的是：DocumentationType.SWAGGER_2
        // Swagger 3 使用的是：DocumentationType.OAS_30
        return new Docket(DocumentationType.OAS_30).pathMapping("/")
                // 定义是否开启swagger，false为关闭，可以通过变量控制
//                .enable(SwaggerProperties.getEnable())
                // 将api的元信息设置为包含在json ResourceListing响应中。
                .apiInfo(apiInfo())
                // 分组名称
                .groupName("1.0")
                // 接口调试地址
//                .host(swaggerProperties.getTryHost())
                // 选择哪些接口作为swagger的doc发布
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("info.baolong")) // 指定扫描包
                .paths(PathSelectors.any())
                .build()


                // 支持的通讯协议集合
//                .protocols(new HashSet("https", "http"))
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    /**
     * 认证的安全上下文
     */
    private List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> securitySchemes = new ArrayList<>();
        securitySchemes.add(new ApiKey("Authorization", "Authorization", "header"));
        return securitySchemes;
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any()).build());
        return securityContexts;
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }




}


