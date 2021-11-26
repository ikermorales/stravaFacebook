package es.deusto.ingenieria.sd.auctions.currency.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.auctions.currency.remote.RegistrationService;
import es.deusto.ingenieria.sd.auctions.currency.remote.IRegistration;

public class RegistrationServer {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IRegistration remoteObject = RegistrationService.getInstance();			
			Naming.rebind(name, remoteObject);
			System.out.println(" * Currency Exchange Server '" + name + "' started!!");
		} catch (Exception ex) {
			System.out.println(" # Currency Exchange Server: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}