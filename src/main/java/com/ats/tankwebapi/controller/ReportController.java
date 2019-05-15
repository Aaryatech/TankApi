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
import com.ats.tankwebapi.repository.GetPaymentMonthDetailsRepo;
import com.ats.tankwebapi.repository.GetWorkCustomerRepo;
import com.ats.tankwebapi.repository.GetWorkMonthDetailsRepo;
import com.ats.tankwebapi.repository.UserRepo;
import com.ats.tankwebapi.work.model.GetCustInfowithPaymentInfo;
import com.ats.tankwebapi.work.model.GetCustomerDetails;
import com.ats.tankwebapi.work.model.GetEmployeeInfo;
import com.ats.tankwebapi.work.model.GetPaymentDetail;
import com.ats.tankwebapi.work.model.GetPaymentMonthDetails;
import com.ats.tankwebapi.work.model.GetWorkCustomer;
import com.ats.tankwebapi.work.model.GetWorkDetail;
import com.ats.tankwebapi.work.model.GetWorkMonthDetails;

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

	@Autowired
	GetWorkMonthDetailsRepo getWorkMonthDetailsRepo;

	@Autowired
	GetPaymentMonthDetailsRepo getPaymentMonthDetailsRepo;

	@RequestMapping(value = { "/getCustomerWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCustomerDetails> getCustomerInfoByAmtDesc(@RequestParam("areaId") int areaId) {

		List<GetCustomerDetails> list = new ArrayList<GetCustomerDetails>();
		try {
			if (areaId == 0) {
				list = getCustomerDetailsRepo.getCustomerWiseReport();
			} else {

				list = getCustomerDetailsRepo.getCustomerWiseReportByAreaId(areaId);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getDateWorkWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWorkCustomer> getDateWorkWiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetWorkCustomer> list = new ArrayList<GetWorkCustomer>();
		try {

			list = getWorkCustomerRepo.getWorkListByDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getDatePaymentWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCustInfowithPaymentInfo> getDatePaymentWiseReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetCustInfowithPaymentInfo> list = new ArrayList<GetCustInfowithPaymentInfo>();
		try {

			list = getCustInfowithPaymentInfoRepo.getPaymentListByDate(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	/*
	 * @RequestMapping(value = { "/getEmployeeWiseReport" }, method =
	 * RequestMethod.POST) public @ResponseBody List<GetEmployeeInfo>
	 * getEmployeeWiseReport(@RequestParam("empId") int
	 * empId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate")
	 * String toDate) {
	 * 
	 * List<GetEmployeeInfo> workList = new ArrayList<GetEmployeeInfo>();
	 * List<GetEmployeeInfo> resultList = new ArrayList<GetEmployeeInfo>(); try {
	 * if(empId==0)
	 * 
	 * { List<User> list = new ArrayList<User>(); workList =
	 * getEmployeeInfoRepo.getEmpInfoByFromDate(fromDate,toDate); list =
	 * userRepo.findByDelStatus(1); for(int i=0;i<list.size();i++) { for(int
	 * j=0;j<workList.size();j++) {
	 * if(workList.get(j).getEmployeeId().contains(String.valueOf(list.get(i).
	 * getUserId()))) { workList.get(j).setUserName(list.get(i).getUserName());
	 * resultList.add(workList.get(j)); } } }
	 * 
	 * } else { resultList =
	 * getEmployeeInfoRepo.getEmpInfoByDate(empId,fromDate,toDate); for(int
	 * i=0;i<workList.size();i++) { String empIds=workList.get(i).getEmployeeId();
	 * String[] values = empIds.split(",");
	 * 
	 * 
	 * List<String> al = new ArrayList<String>(Arrays.asList(values));
	 *//**
		 * Set<String> set = new HashSet<>(al); al.clear(); al.addAll(set);
		 *//*
			 * 
			 * //System.err.println("emp ids for notification are:--------------:" +
			 * al.toString()); List<String> userList = getEmployeeInfoRepo.getUserName(al);
			 * //userList.add(user);
			 * 
			 * resultList.get(i).setUser(userList);
			 * 
			 * } }
			 * 
			 * } catch (Exception e) {
			 * 
			 * e.printStackTrace(); }
			 * 
			 * return resultList;
			 * 
			 * }
			 */

	@RequestMapping(value = { "/getWorkMonthWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWorkMonthDetails> getWorkMonthWiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<GetWorkMonthDetails> list = new ArrayList<GetWorkMonthDetails>();
		try {

			list = getWorkMonthDetailsRepo.getWorkDetailsByMonth(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getPaymentMonthWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPaymentMonthDetails> getPaymentMonthWiseReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetPaymentMonthDetails> list = new ArrayList<GetPaymentMonthDetails>();
		try {

			list = getPaymentMonthDetailsRepo.getPaymentDetailsByMonth(fromDate, toDate);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getMonthWiseReportByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetPaymentMonthDetails> getMonthWiseReportByDate(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<GetWorkMonthDetails> workList = new ArrayList<GetWorkMonthDetails>();
		List<GetPaymentMonthDetails> paymentList = new ArrayList<GetPaymentMonthDetails>();
		try {

			workList = getWorkMonthDetailsRepo.getWorkDetailsByMonth(fromDate, toDate);
			paymentList = getPaymentMonthDetailsRepo.getPaymentDetailsByMonth(fromDate, toDate);

			for (int i = 0; i < workList.size(); i++) {

				int find = 0;

				for (int j = 0; j < paymentList.size(); j++) {

					if (workList.get(i).getMonthName().equalsIgnoreCase(paymentList.get(j).getMonthName())
							&& workList.get(i).getYear().equalsIgnoreCase(paymentList.get(j).getYear())) {
						paymentList.get(j).setTotalAmt(workList.get(i).getTotalAmt());
						paymentList.get(j).setFinalAmt(workList.get(i).getFinalAmt());
						paymentList.get(j).setDiscAmt(workList.get(i).getDiscAmt());
						find = 1;
						break;
					}
				}

				if (find == 0) {

					GetPaymentMonthDetails getPaymentDetail = new GetPaymentMonthDetails();
					getPaymentDetail.setMonthName(workList.get(i).getMonthName());
					getPaymentDetail.setTotalAmt(workList.get(i).getTotalAmt());
					getPaymentDetail.setMonthDate(workList.get(i).getMonthDate());
					getPaymentDetail.setYear(workList.get(i).getYear());
					getPaymentDetail.setFinalAmt(workList.get(i).getFinalAmt());
					getPaymentDetail.setDiscAmt(workList.get(i).getDiscAmt());
					// getPaymentDetail.setCostRs(workList.get(i).getCostRs());
					// getPaymentDetail.setPaymentId(workList.get(i).getPaymentId());
					paymentList.add(getPaymentDetail);
					System.out.println("List: " + paymentList.toString());
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return paymentList;

	}
	
	@RequestMapping(value = { "/getEmployeeWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetEmployeeInfo> getEmployeeWiseReport(@RequestParam("empId") int empId,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

	
		List<GetEmployeeInfo> resultList = new ArrayList<GetEmployeeInfo>();
		try {
			if(empId==0)
				
			{
				resultList = getEmployeeInfoRepo.getEmpInfoByFromDate(fromDate,toDate);
				
				
			}
			else
			{
				resultList = getEmployeeInfoRepo.getEmpInfoByDate(empId,fromDate,toDate);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return resultList;

	}
}
