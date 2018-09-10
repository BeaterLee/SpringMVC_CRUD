package com.beater.springmvc.crud.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.beater.springmvc.crud.dao.DepartmentDao;
import com.beater.springmvc.crud.dao.EmployeeDao;
import com.beater.springmvc.crud.entities.Employee;
import com.beater.springmvc.crud.exception.NumberNotMatchException;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private ResourceBundleMessageSource resourceBundleMessageSource;

	@RequestMapping("/listAll")
	public String listAll(Map<String, Object> employees) {
		List<Employee> list = new ArrayList<>(employeeDao.getAll());
		employees.put("employees", list);
		return "listall";
	}

	@RequestMapping(value = { "/employee", "/employee/{id}" }, method = RequestMethod.GET)
	public String getEmployee(@PathVariable(value = "id", required = false) Integer id, Map<String, Object> map) {
		map.put("departments", departmentDao.getDepartments());
		Map<Integer, String> itemMap = new HashMap<>();
		itemMap.put(1, "male");
		itemMap.put(2, "female");
		map.put("genders", itemMap);
		if (id == null) {
			map.put("employee", new Employee());
		} else {
			map.put("employee", employeeDao.get(id));
			System.out.println(employeeDao.get(id));
		}
		return "getEmployee";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	// BindingResult储存数据转换、数据格式化和数据校验产生的错误，可作为参数传入
	// 需校验的Bean 对象和其绑定结果对象或错误对象时成对出现的，它们之间不允许声明其他的入参
	public String addEmployee(@Valid Employee employee, BindingResult result, Map<String, Object> map
//			,@Valid Department department, BindingResult departymentresult
	) {
		System.out.println(employee);
		if (result.getErrorCount() > 0) {
			System.out.println("出错了！");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}
			Map<Integer, String> itemMap = new HashMap<>();
			itemMap.put(1, "male");
			itemMap.put(2, "female");
			map.put("genders", itemMap);
			map.put("departments", departmentDao.getDepartments());
			return "getEmployee";
		}
		employeeDao.save(employee);
		return "redirect:/listAll";
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public String deleteEmployee(@PathVariable(value = "id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/listAll";
	}

	//	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	//	public String getEmployee(@PathVariable("id")int id,Map<String, Object> map) {
	//		map.put("employee", employeeDao.get(id));
	//		return "editemployee";
	//	}

	@ModelAttribute
	public void getEmployeeFromDataBase(@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			map.put("updateEmployee", employeeDao.get(id));
		}
	}

	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	public String editEmployee(@ModelAttribute(value = "updateEmployee") Employee employee) {
		employeeDao.save(employee);
		return "redirect:/listAll";
	}

//	 @InitBinder注解的方法对WebDataBinder进行初始化，需要传入WebDataBinder作为参数,返回类型必须为void
//	 @InitBinder
//	 public void initBinder(WebDataBinder webDataBinder) {
//	 webDataBinder.setDisallowedFields("lastName");
//	 }

	/**
	 * 当控制器处理方法使用到 @RequestBody/@ResponseBody 或HttpEntity<T>/ResponseEntity<T> 时 
	 * Spring 首先根据请求头或响应头的Accept 属性选择匹配的 HttpMessageConverter
	 * 进而根据参数类型或泛型类型的过滤得到匹配的 HttpMessageConverter
	 * 若找不到可用的HttpMessageConverter 将报错
	 * （此方法的@RequestBody注解了一个String类型的入参，那么SpringMVC会找String类型的HttpMessageConverter把前台传过来的数据转为String类型的)
	 * @ResponseBody同上，关注点是返回值的类型
	 * @param requestBody
	 * @return
	 */
	@RequestMapping("/testJson")
	@ResponseBody
	public Collection<Employee> testJson(@RequestBody String requestBody) {
		System.out.println(requestBody);
		return employeeDao.getAll();
	}

	@RequestMapping(value = { "/user" })
	public String testLocale(Locale locale) {
		System.out.println(resourceBundleMessageSource.getMessage("user", null, locale));
		return "user";
	}

	@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file)
			throws IOException {
		System.out.println("desc:" + desc);
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getInputStream());
		return "Success";
	}

	@RequestMapping("/testExceptionHandler")
	public String testExceptionHandler(@RequestParam(value = "i") int i) {
		System.out.println(10 / i);
		return "Success";
	}
	
	@RequestMapping("/testResposeStatusExceptionHandler")
	public String testResposeStatusExceptionHandler(@RequestParam("i") int i) {
		if(i == 10) {
			throw new NumberNotMatchException();
		}
		return "Success";
	}
	
	@RequestMapping(value="/testDefaultHandlerExceptionResolver",method=RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver(){
		System.out.println("testDefaultHandlerExceptionResolver...");
		return "Success";
	}
	
	@RequestMapping("/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
		String [] vals = new String[10];
		System.out.println(vals[i]);
		return "Success";
	}
}
