package johny.dotsville.hello.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
