
package com.ats.tankwebapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tankwebapi.model.Customer;
import com.ats.tankwebapi.model.Employee;
import com.ats.tankwebapi.model.GetCustomerLocName;
import com.ats.tankwebapi.model.Info;
import com.ats.tankwebapi.model.Location;
import com.ats.tankwebapi.model.Payment;
import com.ats.tankwebapi.model.Setting;
import com.ats.tankwebapi.model.User;
import com.ats.tankwebapi.model.Work;
import com.ats.tankwebapi.repository.CustomerRepo;
import com.ats.tankwebapi.repository.EmployeeRepo;
import com.ats.tankwebapi.repository.GetCustomerDetailsRepo;
import com.ats.tankwebapi.repository.GetCustomerInfoRepo;
import com.ats.tankwebapi.repository.GetCustomerLocNameRepo;
import com.ats.tankwebapi.repository.GetPaymentDetailRepo;
import com.ats.tankwebapi.repository.GetWorkCustomerRepo;
import com.ats.tankwebapi.repository.LocationRepo;
import com.ats.tankwebapi.repository.PaymentRepo;
import com.ats.tankwebapi.repository.SettingRepo;
import com.ats.tankwebapi.repository.UserRepo;
import com.ats.tankwebapi.repository.WorkDetailRepo;
import com.ats.tankwebapi.repository.WorkRepo;
import com.ats.tankwebapi.work.model.GetCustomerDetails;
import com.ats.tankwebapi.work.model.GetCustomerInfo;
import com.ats.tankwebapi.work.model.GetPaymentDetail;
import com.ats.tankwebapi.work.model.GetWorkCustomer;
import com.ats.tankwebapi.work.model.GetWorkDetail;

@RestController
public class MasterController {
	
	  @Autowired 
	  UserRepo userRepo;
	  
	  @Autowired
	  CustomerRepo customerRepo;
	  
	  @Autowired
	  EmployeeRepo employeeRepo;
	  
	  @Autowired
	  LocationRepo locationRepo;
	  
	  @Autowired
	  WorkRepo workRepo;
	  
	  @Autowired
	  GetWorkCustomerRepo getWorkCustomerRepo;
	  
	  @Autowired
	  GetCustomerInfoRepo getCustomerInfoRepo;
	  
	  @Autowired
	  SettingRepo settingRepo;
	  
	  @Autowired
	  PaymentRepo paymentRepo;
	  
	  @Autowired
	  GetCustomerDetailsRepo getCustomerDetailsRepo;
	  
	  @Autowired
	  GetCustomerLocNameRepo getCustomerLocNameRepo;
	  
	  @Autowired
	  WorkDetailRepo workDetailRepo;
	  
	  @Autowired
	  GetPaymentDetailRepo getPaymentDetailRepo;
	  
		@RequestMapping(value = { "/loginUser" }, method = RequestMethod.POST)
		public @ResponseBody User loginUser(@RequestParam("username") String userName,
				@RequestParam("userPass") String pass) {

			User loginResponse = new User();
			try {

				loginResponse = userRepo.findByDelStatusAndMobileNumberAndPassword(1,userName, pass);

				if (loginResponse == null) {
					loginResponse = new User();
					loginResponse.setError(true);
					loginResponse.setMsg("record Not found");
				} else {
					loginResponse.setError(false);
					loginResponse.setMsg("Record Found");
				}
				System.out.println("loginResponse :" + loginResponse);
			} catch (Exception e) {
				e.printStackTrace();

				loginResponse = new User();
				loginResponse.setError(true);
				loginResponse.setMsg("record Not found");
			}
			return loginResponse;
		}

		@RequestMapping(value = { "/saveUser" }, method = RequestMethod.POST)
		public @ResponseBody User saveUser(@RequestBody User user) {

			User save = new User();
			try {

				save = userRepo.saveAndFlush(user);

				if (save != null) {
					save.setError(false);
				} else {

					save = new User();
					save.setError(true);
				}

			} catch (Exception e) {
				save = new User();
				save.setError(true);
				e.printStackTrace();
			}

			return save;
		}

		@RequestMapping(value = { "/getAllUserList" }, method = RequestMethod.GET)
		public @ResponseBody List<User> getAllUserList() {

			List<User> list = new ArrayList<User>();
			try {

				list = userRepo.findByDelStatusOrderByUserIdDesc(1);

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/getUserList" }, method = RequestMethod.POST)
		public @ResponseBody User getUserList(@RequestParam("userId") int userId) {

			User list = new User();
			try {

				list = userRepo.findByUserIdAndDelStatusOrderByUserIdDesc(userId,1);

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteUser(@RequestParam("userId") int userId) {

			Info info = new Info();

			try {

				int delete = userRepo.deleteUser(userId);

				if (delete > 0) {
					info.setError(false);
					info.setMsg("deleted");
				} else {
					info.setError(true);
					info.setMsg("failed");
				}

			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("failed");
			}

			return info;

		}
		@RequestMapping(value = { "/saveCustomer" }, method = RequestMethod.POST)
		public @ResponseBody Customer saveCustomer(@RequestBody Customer user) {

			Customer save = new Customer();
			try {

				save = customerRepo.saveAndFlush(user);

				if (save != null) {
					save.setError(false);
				} else {

					save = new Customer();
					save.setError(true);
				}

			} catch (Exception e) {
				save = new Customer();
				save.setError(true);
				e.printStackTrace();
			}

			return save;
		}

		@RequestMapping(value = { "/getAllCustomerList" }, method = RequestMethod.GET)
		public @ResponseBody List<Customer> getAllCustomerList() {

			List<Customer> list = new ArrayList<Customer>();
			try {

				list = customerRepo.findByDelStatusAndIsUsedOrderByCustomerIdDesc(1,1);
					System.out.print("Cust List : "+list);
			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}
		@RequestMapping(value = { "/getAllCustomerListWithLocName" }, method = RequestMethod.GET)
		public @ResponseBody List<GetCustomerLocName> getAllCustomerListWithLocName() {

			List<GetCustomerLocName> list = new ArrayList<GetCustomerLocName>();
			try {

				list = getCustomerLocNameRepo.getCustomerListWithLocName();
					System.out.print("Cust List : "+list);
			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/getCustInfoByCustId" }, method = RequestMethod.POST)
		public @ResponseBody Customer getCustInfoByCustId(@RequestParam("custId") int custId) {

			Customer list = new Customer();
			try {

				list = customerRepo.findByCustomerIdAndDelStatusOrderByCustomerIdDesc(custId,1);

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/deleteCustomer" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteCustomer(@RequestParam("custId") int custId) {

			Info info = new Info();

			try {

				int delete = customerRepo.deleteCustomer(custId);

				if (delete > 0) {
					info.setError(false);
					info.setMsg("deleted");
				} else {
					info.setError(true);
					info.setMsg("failed");
				}

			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("failed");
			}

			return info;

		}
		@RequestMapping(value = { "/saveLocation" }, method = RequestMethod.POST)
		public @ResponseBody Location saveLocation(@RequestBody Location user) {

			Location save = new Location();
			try {

				save = locationRepo.saveAndFlush(user);

				if (save != null) {
					save.setError(false);
				} else {

					save = new Location();
					save.setError(true);
				}

			} catch (Exception e) {
				save = new Location();
				save.setError(true);
				e.printStackTrace();
			}

			return save;
		}

		@RequestMapping(value = { "/getAllLocationList" }, method = RequestMethod.GET)
		public @ResponseBody List<Location> getAllLocationList() {

			List<Location> list = new ArrayList<Location>();
			try {

				list = locationRepo.findByDelStatusOrderByLocationIdDesc(1);

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/getLocationInfoByLocId" }, method = RequestMethod.POST)
		public @ResponseBody Location getLocationInfoByLocId(@RequestParam("locationId") int locationId) {

			Location list = new Location();
			try {

				list = locationRepo.findByLocationIdAndDelStatusOrderByLocationIdDesc(locationId,1);

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/deleteLocation" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteLocation(@RequestParam("locationId") int locationId) {

			Info info = new Info();

			try {

				int delete = locationRepo.deleteLocation(locationId);

				if (delete > 0) {
					info.setError(false);
					info.setMsg("deleted");
				} else {
					info.setError(true);
					info.setMsg("failed");
				}

			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("failed");
			}

			return info;

		}
		
		@RequestMapping(value = { "/saveWork" }, method = RequestMethod.POST)
		public @ResponseBody Work saveWork(@RequestBody Work work) {

			Work save = new Work();
			try {

				save = workRepo.saveAndFlush(work);

				if (save != null) {
					save.setError(false);
				} else {

					save = new Work();
					save.setError(true);
				}

			} catch (Exception e) {
				save = new Work();
				save.setError(true);
				e.printStackTrace();
			}

			return save;
		}
		@RequestMapping(value = { "/getCustomerByLocationId" }, method = RequestMethod.POST)
		public @ResponseBody List<Customer> getCustomerByLocationId(@RequestParam("areaId") int areaId) {

			 List<Customer> list = new  ArrayList<Customer>();
			try {

				list = customerRepo.findByAreaIdAndDelStatus(areaId,1);

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/getWorkByStatus" }, method = RequestMethod.POST)
		public @ResponseBody  List<GetWorkCustomer> getWorkByStatus(@RequestParam("status") int status) {

			
			 List<GetWorkCustomer>   workList = new ArrayList<GetWorkCustomer>();
			try {
				workList=getWorkCustomerRepo.getAllworkInfo(status);
				for(int i=0;i<workList.size();i++)
				{
					String empIds=workList.get(i).getEmployeeId();
					String[] values = empIds.split(",");
					///System.err.println("emp ids for notification are::" + empIds);
					List<String> al = new ArrayList<String>(Arrays.asList(values));

					Set<String> set = new HashSet<>(al);
					al.clear();
					al.addAll(set);
					//System.err.println("emp ids for notification are:--------------:" + al.toString());
					List<User> userList =new ArrayList<User>();
					for(int j=0;j<al.size();j++)
					{
						User user =userRepo.findByUserIdAndDelStatusOrderByUserIdDesc(Integer.parseInt(al.get(j)),1);
						userList.add(user); 						
					}
					workList.get(i).setUser(userList);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

			return workList;

		}
		
		@RequestMapping(value = { "/getWorkListSchedule" }, method = RequestMethod.POST)
		public @ResponseBody  List<GetWorkCustomer> getWorkListSchedule(@RequestParam("status") int status) {

			
			 List<GetWorkCustomer> workList = new ArrayList<GetWorkCustomer>();
			try {
				workList=getWorkCustomerRepo.getAllworkInfoSchedule(status);
				for(int i=0;i<workList.size();i++)
				{
					String empIds=workList.get(i).getEmployeeId();
					String[] values = empIds.split(",");
					///System.err.println("emp ids for notification are::" + empIds);
					List<String> al = new ArrayList<String>(Arrays.asList(values));

					Set<String> set = new HashSet<>(al);
					al.clear();
					al.addAll(set);
					//System.err.println("emp ids for notification are:--------------:" + al.toString());
					List<User> userList =new ArrayList<User>();
					for(int j=0;j<al.size();j++)
					{
						User user =userRepo.findByUserIdAndDelStatusOrderByUserIdDesc(Integer.parseInt(al.get(j)),1);
						userList.add(user); 						
					}
					workList.get(i).setUser(userList);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

			return workList;

		}
		@RequestMapping(value = { "/getWorkHistoryByCustId" }, method = RequestMethod.POST)
		public @ResponseBody  List<GetWorkCustomer> getWorkHistoryByCustId(@RequestParam("custId") int custId ,@RequestParam("status") List<Integer> status,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {

			
			 List<GetWorkCustomer> workList = new ArrayList<GetWorkCustomer>(); 
			try {
				if(custId==0)
				{
					workList=getWorkCustomerRepo.getAllWorkHistoryByDate(status,fromDate,toDate);
				}
				else
				{
					workList=getWorkCustomerRepo.getAllworkHistory(custId,status,fromDate,toDate);
				}
							
				for(int i=0;i<workList.size();i++)
				{
					String empIds=workList.get(i).getEmployeeId();
					String[] values = empIds.split(",");
					///System.err.println("emp ids for notification are::" + empIds);
					List<String> al = new ArrayList<String>(Arrays.asList(values));

					Set<String> set = new HashSet<>(al);
					al.clear();
					al.addAll(set);
					//System.err.println("emp ids for notification are:--------------:" + al.toString());
					List<User> userList =new ArrayList<User>();
					for(int j=0;j<al.size();j++)
					{
						User user =userRepo.findByUserIdAndDelStatusOrderByUserIdDesc(Integer.parseInt(al.get(j)),1);
						userList.add(user); 						
					}
					workList.get(i).setUser(userList);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

			return workList;

		}


		@RequestMapping(value = { "/getCustInfoPaymentByCustId" }, method = RequestMethod.POST)
		public @ResponseBody  List<GetCustomerInfo> getCustInfoPaymentByCustId(@RequestParam("custId") int custId) {

			
			 List<GetCustomerInfo> workList = new ArrayList<GetCustomerInfo>(); 
			try {
				workList=getCustomerInfoRepo.getAllCustInfoPayment(custId);
				
			} catch (Exception e) {

				e.printStackTrace();
			}

			return workList;

		}
		
		@RequestMapping(value = { "/updateSettingValue" }, method = RequestMethod.POST)
		public @ResponseBody Info updateSettingValue(@RequestParam("fromDate") String fromDate) {

			Info info = new Info();

			try {

				int updatre = settingRepo.UpdateDate(fromDate);

				if (updatre > 0) {
					info.setError(false);
					info.setMsg("Update");
				} else {
					info.setError(true);
					info.setMsg("failed");
				}

			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("failed");
			}

			return info;

		}
		@RequestMapping(value = { "/getSettingValue" }, method = RequestMethod.GET)
		public @ResponseBody Info getSettingValue() {

			Info info = new Info();
			Setting setting=new Setting();
			try {

				setting = settingRepo.findBySettingsId(1);

			
					info.setError(false);
					info.setMsg(setting.getSettingsValue());
			

			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("failed");
			}

			return info;

		}
		@RequestMapping(value = { "/savePayment" }, method = RequestMethod.POST)
		public @ResponseBody Payment savePayment(@RequestBody Payment payment) {

			Payment save = new Payment();
			try {

				save = paymentRepo.saveAndFlush(payment);

				if (save != null) {
					save.setError(false);
				} else {

					save = new Payment();
					save.setError(true);
				}

			} catch (Exception e) {
				save = new Payment();
				save.setError(true);
				e.printStackTrace();
			}

			return save;
		}
		@RequestMapping(value = { "/getCustomerInfoByAmtDesc" }, method = RequestMethod.GET)
		public @ResponseBody List<GetCustomerDetails> getCustomerInfoByAmtDesc() {

			List<GetCustomerDetails> list = new ArrayList<GetCustomerDetails>();
			try {

				list = getCustomerDetailsRepo.getCustomerInfoByAmtDesc();

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}
		@RequestMapping(value = { "/getTotalWorkByCustId" }, method = RequestMethod.POST)
		public @ResponseBody  List<GetWorkDetail> getTotalWorkByCustId(@RequestParam("custId") int custId) {

			
			 List<GetWorkDetail> workList = new ArrayList<GetWorkDetail>(); 
			try {
				workList=workDetailRepo.getTotalWorkAmtByCustId(custId);
				
			} catch (Exception e) {

				e.printStackTrace();
			}

			return workList;

		}
		@RequestMapping(value = { "/getTotalPaymentByCustId" }, method = RequestMethod.POST)
		public @ResponseBody  List<GetPaymentDetail> getTotalPaymentByCustId(@RequestParam("custId") int custId) {

			
			 List<GetPaymentDetail> workList = new ArrayList<GetPaymentDetail>(); 
			try {
				workList=getPaymentDetailRepo.getTotalPaymentAmtByCustId(custId);
				
			} catch (Exception e) {

				e.printStackTrace();
			}

			return workList;

		}
		
		@RequestMapping(value = { "/getTotalAmountByCustId" }, method = RequestMethod.POST)
		public @ResponseBody  List<GetPaymentDetail> getTotalAmountByCustId(@RequestParam("custId") int custId ) {

			
			 List<GetPaymentDetail> paymentList = new ArrayList<GetPaymentDetail>(); 
			try {
				 List<GetWorkDetail> workList=workDetailRepo.getTotalWorkAmtByCustId(custId);
				 paymentList = getPaymentDetailRepo.getTotalPaymentAmtByCustId(custId);
					 
				 
				 for(int i = 0 ; i<workList.size() ; i++) {
					 
					 int find = 0 ;
					 
					 for(int j = 0 ; j<paymentList.size() ; j++) {
						 
						 if(workList.get(i).getWorkDate().compareTo(paymentList.get(j).getPaymentDate())==0) {
							 paymentList.get(j).setTotalAmt(workList.get(i).getTotalAmt());
							 find=1;
							 break;
						 }
					 }
					 
					 if(find==0) {
						 
						 GetPaymentDetail getPaymentDetail = new GetPaymentDetail();
						 getPaymentDetail.setPaymentDate(workList.get(i).getWorkDate());
						 getPaymentDetail.setTotalAmt(workList.get(i).getTotalAmt());
						 getPaymentDetail.setCustomerId(workList.get(i).getCustomerId());
						// getPaymentDetail.setPaymentId(workList.get(i).getPaymentId());
						 paymentList.add(getPaymentDetail);
					 }
					 
				 }

			} catch (Exception e) {

				e.printStackTrace();
			}

			return paymentList;

		}
		@RequestMapping(value = { "/deleteAssignedWork" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteAssignedWork(@RequestParam("workId") int workId) {

			Info info = new Info();

			try {

				int delete = workRepo.deleteAssignedWork(workId);

				if (delete > 0) {
					info.setError(false);
					info.setMsg("deleted");
				} else {
					info.setError(true);
					info.setMsg("failed");
				}

			} catch (Exception e) {

				e.printStackTrace();
				info.setError(true);
				info.setMsg("failed");
			}

			return info;

		}
}
