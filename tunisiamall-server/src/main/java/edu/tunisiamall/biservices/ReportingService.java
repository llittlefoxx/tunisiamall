package edu.tunisiamall.biservices;

import java.util.Date;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class ReportingService
 */
@Stateless
public class ReportingService implements ReportingServiceRemote, ReportingServiceLocal {

    /**
     * Default constructor. 
     */
    public ReportingService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void CreateReport(String name, String mesure, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteReport(String name) {
		// TODO Auto-generated method stub
		
	}

}
