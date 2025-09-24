package edu.circle.prototype.sse.config;

import edu.circle.prototype.sse.EmployeeImageToUrlConverter;
import edu.circle.prototype.sse.domain.Employee;
import edu.circle.prototype.sse.dto.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        var converter = new EmployeeImageToUrlConverter();

        modelMapper.typeMap(Employee.class, EmployeeDto.class)
                .addMappings(mapper -> mapper.using(converter)
                        .map(src -> src, EmployeeDto::setImageUrl));
        return modelMapper;
    }
}
