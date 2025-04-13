import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        return new Course("Java Programming", 3);
    }

    @Bean
    public Student student() {
        return new Student("Anshu Kumar", course());
    }
}
