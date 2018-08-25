package com.eintrusty.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eintrusty.constant.VariableConstant;
import com.eintrusty.dao.EmployeeDao;
import com.eintrusty.dto.EmployeeDto;
import com.eintrusty.entity.Employee;
import com.eintrusty.model.Model;
import com.eintrusty.service.IEmployeeService;
import com.eintrusty.utility.UtilityBuilder;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Override
	public int addEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		try {
			Employee addEmp = new Employee();
			addEmp.setId(generatedId());
			addEmp.setFirstName(employeeDto.getFirstName());
			addEmp.setMiddleName(employeeDto.getMiddleName());
			addEmp.setLastName(employeeDto.getLastName());
			addEmp.setJobTitle(employeeDto.getJobTitle());
			addEmp.setAddress(employeeDto.getAddress());
			addEmp.setContact(employeeDto.getContact());
			addEmp.setCreatedDate(UtilityBuilder.getLocalDate());
			employeeDao.save(addEmp);
			return VariableConstant.OK;
		} catch (Exception e) {
			logger.warn("Failed to save in Service : " + e.getMessage());
			return VariableConstant.ERROR;

		}
	}

	private String generatedId() {

		try {
			Date date = UtilityBuilder.getLocalDate();
			SimpleDateFormat sdf = new SimpleDateFormat("YYMM");
			String uiid = sdf.format(date);
			List<String> hui = employeeDao.findIdByParameter(uiid);
			List<Model> listId = null;
			if (hui.size() > 0) {
				listId = hui.stream().map(s -> {
					Model model = new Model(s);
					return model;
				}).filter(s -> s != null).collect(Collectors.toList());
			}
			Collections.sort(listId, idComparator);
			StringBuffer sb = new StringBuffer();
			if (listId.size() > 0) {
				String temp = listId.get(0).getId();
				String temp2 = temp.substring(temp.indexOf("C") + 1);
				int number = Integer.parseInt(temp2);
				int number2 = number + 1;
				sb.append("EC").append(number2);
			} else {
				sb.append(uiid).append("01");
			}
			return sb.toString();

		} catch (Exception e) {
			logger.warn("Error generatedId " + e.getMessage());
			return "";
		}

	}

	private static Comparator<Model> idComparator = new Comparator<Model>() {

		@Override
		public int compare(Model m1, Model m2) {
			String model1 = m1.getId();
			String model2 = m1.getId();
			// ascending order
			return model1.compareTo(model2);

			// descending order
			// return model2.compareTo(model1);
		}
	};
}
