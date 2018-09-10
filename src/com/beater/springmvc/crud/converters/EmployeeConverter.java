package com.beater.springmvc.crud.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.beater.springmvc.crud.entities.Department;
import com.beater.springmvc.crud.entities.Employee;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String source) {
		// TODO Auto-generated method stub
		String vals[] = source.split("-");
		//字符串格式： lastName-email-gender-department.id
		if(vals != null && vals.length==4) {
			Employee employee = new Employee();
			employee.setLastName(vals[0]);
			employee.setEmail(vals[1]);
			employee.setGender(Integer.parseInt(vals[2]));
			Department department = new Department();
			department.setId(Integer.parseInt(vals[3]));
			employee.setDepartment(department);
			return employee;
		}
		return null;
	}

}
