package pl.coderslab.driver;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CasualConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
