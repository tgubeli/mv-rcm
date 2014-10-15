package com.example.switchyard.rcm;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.switchyard.component.bean.Service;

import com.redhat.locators.ServiceLocator;
import com.redhat.locators.ServiceLocatorException;
import com.redhat.masvida.ejb.RCMFacade;
import com.redhat.masvida.vo.RcmVO;

@Stateless
@Service(BuscaRcm.class)
public class BuscaRcmBean implements BuscaRcm {

	public String buscarRcm(String numero) {
		try {
			RcmVO rcm = new RcmVO();
			// RCMFacade facade = (RCMFacade) new
			// InitialContext().lookup("java:global/rcm-ejb-0.0.1-SNAPSHOT/RCMFacadeBean!com.redhat.masvida.ejb.RCMFacade");
			RCMFacade facade = (RCMFacade) ServiceLocator
					.getInstance()
					.doRemoteLookUp("", "rcm-ejb-0.0.1-SNAPSHOT", "",
							"RCMFacadeBean", "com.redhat.masvida.ejb.RCMFacade");

			// Ver si hace algo en la actualidad...
			rcm = facade.buscarRcm(new java.math.BigDecimal(String.valueOf(1)));
			
			//Probamos la Asignación al VO
            System.out.println("-------------------------------");	
            System.out.println("Información del VO (Parcial)");
            System.out.println("-------------------------------");
			System.out.println("Folio RCM: "+rcm.getRcmFolio());
			System.out.println("A Nombre de: "+rcm.getRcmNombrede());
			System.out.println("Fecha Recepción: "+rcm.getRcmFechaRecepcion());
			System.out.println("Fecha Pago: "+rcm.getRcmFechaPago());
			System.out.println("Observación: "+rcm.getRcmObserv());
			
			return numero;
		} catch (ServiceLocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}