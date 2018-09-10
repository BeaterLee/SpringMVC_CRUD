package com.beater.springmvc.crud.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beater.springmvc.crud.dao.EmployeeDao;
import com.beater.springmvc.crud.entities.Employee;

@Controller
public class SpringMVC_CRUD_Test {

	@Autowired
	private EmployeeDao employeeDao;
//	private DepartmentDao departmentDao;
//
//	{
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringMVC_CRUD_Config.xml");
//		departmentDao = (DepartmentDao) ctx.getBean("departmentDao");
//	}
//
//	@Test
//	public void testGetDepartments() {
//		System.out.println(departmentDao.getDepartments());
//	}

	@RequestMapping("/testConverter")
	public String testConverter(Employee employee) {
		employeeDao.save(employee);
		System.out.println("save:" + employee);
		return "redirect:/listAll";
	}
}
