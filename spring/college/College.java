package spring.college;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class College {

    @Value("${college.Name}")
    private String collegeName;

    @Autowired
    private Principal principal; // class variable

    @Autowired
    @Qualifier("scienceTeacher")
    private Teacher teacher; // interface variable

    public void test() {
        principal.principalInfo();
        teacher.teach();
        System.out.println("Our college name is "+ collegeName);
        System.out.println("testing this methods");
    }

}
