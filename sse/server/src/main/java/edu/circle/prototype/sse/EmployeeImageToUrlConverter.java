package edu.circle.prototype.sse;

import edu.circle.prototype.sse.domain.Employee;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class EmployeeImageToUrlConverter implements Converter<Employee, String> {

    @Override
    public String convert(MappingContext<Employee, String> context) {
        Employee employee = context.getSource();
        if (employee.getId() != null) {
            return "/users/" + employee.getId() + "/image";
        }
        return null;
    }
}