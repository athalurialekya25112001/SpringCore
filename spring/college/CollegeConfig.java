package spring.college;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "spring.college")
@PropertySource("classpath:college-info.properties")
public class CollegeConfig {
/*
    @Bean
    public College collegeBean()    // collegeBean - bean id
    {
        College college = new College();
        college.setPrincipal(principalBean());
        college.setTeacher(mathTeacherBean());
        return college;
    }

    @Bean
    public Principal principalBean() {
        Principal principal = new Principal();
        return principal;
    }

    @Bean
    public Teacher mathTeacherBean() {
        return new MathTeacher();
    }
 */
}
