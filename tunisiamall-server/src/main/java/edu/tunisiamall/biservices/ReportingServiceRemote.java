package edu.tunisiamall.biservices;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface ReportingServiceRemote {

	public void CreateReport(String name, String mesure,Date startDate,Date endDate);
	public void DeleteReport(String name);	
}
