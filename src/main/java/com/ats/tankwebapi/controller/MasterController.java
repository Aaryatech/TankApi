
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
import com.ats.tankwebapi.model.Info;
import com.ats.tankwebapi.model.Location;
import com.ats.tankwebapi.model.User;
import com.ats.tankwebapi.model.Work;
import com.ats.tankwebapi.repository.CustomerRepo;
import com.ats.tankwebapi.repository.EmployeeRepo;
import com.ats.tankwebapi.repository.GetWorkCustomerRepo;
import com.ats.tankwebapi.repository.LocationRepo;
import com.ats.tankwebapi.repository.UserRepo;
import com.ats.tankwebapi.repository.WorkRepo;
import com.ats.tankwebapi.work.model.GetWorkCustomer;

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
}
