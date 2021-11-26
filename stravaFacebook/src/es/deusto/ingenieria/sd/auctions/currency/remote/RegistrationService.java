package es.deusto.ingenieria.sd.auctions.currency.remote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.TipoUsuarioDTO;
import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

public class RegistrationService extends UnicastRemoteObject implements IRegistration {
	private static final long serialVersionUID = 1L;

	
	//Attribute for the Singleton pattern
	public static RegistrationService instance;
			
	private RegistrationService() throws RemoteException {
		super();
//		getConversionRates();
	}
	
	public static RegistrationService getInstance() {
		if (instance == null) {
			try {
				instance = new RegistrationService();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}

	@Override
	public UserDTO getUsuarioGoogle(String nickName) {
		HashMap<String, UserDTO> hashGoogle = new HashMap();
		
		UserDTO u = new UserDTO();
		u.setNickname("Billlie");
		
		EntrenamientoDTO e1 = new EntrenamientoDTO();
		e1.setDeporte("bici");
		e1.setDistancia(110);
		e1.setDuracion(11);
		e1.setFechaIni("11/11/2021");
		e1.setHoraIni("11:11");
		e1.setTitulo("EncontrarABilllie");
		
		EntrenamientoDTO e2 = new EntrenamientoDTO();
		e1.setDeporte("correr");
		e1.setDistancia(11000);
		e1.setDuracion(111);
		e1.setFechaIni("11/11/2021");
		e1.setHoraIni("11:11");
		e1.setTitulo("CorrerOMorir");

		List<EntrenamientoDTO> entrenamientos = new ArrayList<>();
		entrenamientos.add(e2);
		entrenamientos.add(e1);
		u.setEntrenamientos(entrenamientos);
		
		u.setRetosAceptados(new ArrayList<>());
		u.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
		
		hashGoogle.put(u.getNickname(), u);
		
		UserDTO u2 = new UserDTO();
		u2.setNickname("Astro");
		
		EntrenamientoDTO e3 = new EntrenamientoDTO();
		e3.setDeporte("bici");
		e3.setDistancia(9000);
		e3.setDuracion(2);
		e3.setFechaIni("20/11/2021");
		e3.setHoraIni("10:23");
		e3.setTitulo("PedaLeando");
		
		EntrenamientoDTO e4 = new EntrenamientoDTO();
		e4.setDeporte("correr");
		e4.setDistancia(10000);
		e4.setDuracion(2);
		e4.setFechaIni("19/09/2021");
		e4.setHoraIni("00:03");
		e4.setTitulo("AstroNauta");

		List<EntrenamientoDTO> entrenamientos2 = new ArrayList<>();
		entrenamientos.add(e3);
		entrenamientos.add(e4);
		u2.setEntrenamientos(entrenamientos2);
		
		u2.setRetosAceptados(new ArrayList<>());
		u2.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
		
		hashGoogle.put(u2.getNickname(), u2);
		
		if(hashGoogle.containsKey(nickName)) {
			return hashGoogle.get(nickName);
		}
		
		return null;
	}

	
}