package com.ats.tankwebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.tankwebapi.repository.GetCustomerDetailsRepo;
import com.ats.tankwebapi.work.model.GetCustomerDetails;

@RestController
public class ReportController {

	 @Autowired
	  GetCustomerDetailsRepo getCustomerDetailsRepo;
	
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
}
