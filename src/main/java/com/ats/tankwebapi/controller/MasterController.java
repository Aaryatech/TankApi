
package com.ats.tankwebapi.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.ats.tankwebapi.repository.CustomerRepo;
import com.ats.tankwebapi.repository.EmployeeRepo;
import com.ats.tankwebapi.repository.LocationRepo;
import com.ats.tankwebapi.repository.UserRepo;

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
	  
		@RequestMapping(value = { "/loginUser" }, method = RequestMethod.POST)
		public @ResponseBody User loginUser(@RequestParam("username") String userName,
				@RequestParam("userPass") String pass) {

			User loginResponse = new User();
			try {

				loginResponse = userRepo.findByMobileNumberAndPassword(userName, pass);

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

				list = userRepo.findByOrderByUserIdDesc();

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/getUserList" }, method = RequestMethod.POST)
		public @ResponseBody User getUserList(@RequestParam("userId") int userId) {

			User list = new User();
			try {

				list = userRepo.findByUserIdOrderByUserIdDesc(userId);

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

				list = customerRepo.findByOrderByCustomerIdDesc();

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/getCustInfoByCustId" }, method = RequestMethod.POST)
		public @ResponseBody Customer getCustInfoByCustId(@RequestParam("custId") int custId) {

			Customer list = new Customer();
			try {

				list = customerRepo.findByCustomerIdOrderByCustomerIdDesc(custId);

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

				list = locationRepo.findByOrderByLocationIdDesc();

			} catch (Exception e) {

				e.printStackTrace();
			}

			return list;

		}

		@RequestMapping(value = { "/getLocationInfoByLocId" }, method = RequestMethod.POST)
		public @ResponseBody Location getLocationInfoByLocId(@RequestParam("locationId") int locationId) {

			Location list = new Location();
			try {

				list = locationRepo.findByLocationIdOrderByLocationIdDesc(locationId);

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
}
