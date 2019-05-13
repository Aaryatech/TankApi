package com.ats.tankwebapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tankwebapi.model.User;
import com.ats.tankwebapi.repository.GetCustInfowithPaymentInfoRepo;
import com.ats.tankwebapi.repository.GetCustomerDetailsRepo;
import com.ats.tankwebapi.repository.GetEmployeeInfoRepo;
import com.ats.tankwebapi.repository.GetWorkCustomerRepo;
import com.ats.tankwebapi.repository.UserRepo;
import com.ats.tankwebapi.work.model.GetCustInfowithPaymentInfo;
import com.ats.tankwebapi.work.model.GetCustomerDetails;
import com.ats.tankwebapi.work.model.GetEmployeeInfo;
import com.ats.tankwebapi.work.model.GetWorkCustomer;

@RestController
public class ReportController {

	 @Autowired
	  GetCustomerDetailsRepo getCustomerDetailsRepo;
	 
	
	  @Autowired
	  GetCustInfowithPaymentInfoRepo getCustInfowithPaymentInfoRepo;
	 
	 
	 @Autowired
	  GetWorkCustomerRepo getWorkCustomerRepo;
	 
	 @Autowired
	 GetEmployeeInfoRepo getEmployeeInfoRepo;
	 
	 @Autowired 
	  UserRepo userRepo;
	 
	@RequestMapping(value = { "/getCustomerWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCustomerDetails> getCustomerInfoByAmtDesc(@RequestParam("areaId") int areaId) {

		List<GetCustomerDetails> list = new ArrayList<GetCustomerDetails>();
		try {
			if(areaId==0)
			{
				list = getCustomerDetailsRepo.getCustomerWiseReport();
			}
			else {

			list = getCustomerDetailsRepo.getCustomerWiseReportByAreaId(areaId);
			} 

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	@RequestMapping(value = { "/getDateWorkWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWorkCustomer> getDateWorkWiseReport(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

		List<GetWorkCustomer> list = new ArrayList<GetWorkCustomer>();
		try {
			
			list = getWorkCustomerRepo.getWorkListByDate(fromDate,toDate);
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	@RequestMapping(value = { "/getDatePaymentWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCustInfowithPaymentInfo> getDatePaymentWiseReport(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

		List<GetCustInfowithPaymentInfo> list = new ArrayList<GetCustInfowithPaymentInfo>();
		try {
			
			list = getCustInfowithPaymentInfoRepo.getPaymentListByDate(fromDate,toDate);
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}
	
	@RequestMapping(value = { "/getEmployeeWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEmployeeInfo> getEmployeeWiseReport(@RequestParam("empId") int empId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

		List<GetEmployeeInfo> workList = new ArrayList<GetEmployeeInfo>();
		try {
			
			workList = getEmployeeInfoRepo.getEmpInfoByDate(empId,fromDate,toDate);
			int j=0;
			for(int i=0;i<workList.size();i++)
			{
				String empIds=workList.get(i).getEmployeeId();
				String[] values = empIds.split(",");
			
				List<String> al = new ArrayList<String>(Arrays.asList(values));

				Set<String> set = new HashSet<>(al);
				al.clear();
				al.addAll(set);
				//System.err.println("emp ids for notification are:--------------:" + al.toString());
				List<User> userList =new ArrayList<User>();
				for(j=0;j<al.size();j++)
				{
					User user =userRepo.findByUserIdAndDelStatusOrderByUserIdDesc(Integer.parseInt(al.get(j)),1);
					userList.add(user); 
				
					}
				if(al.size()>0) {
					
				workList.get(i).setUserName(userList.get(i).getUserName());
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return workList;

	}
}
