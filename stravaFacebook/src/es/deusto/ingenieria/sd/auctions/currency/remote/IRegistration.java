package es.deusto.ingenieria.sd.auctions.currency.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.auctions.server.data.dto.UserDTO;

public interface IRegistration extends Remote {

	public UserDTO getUsuarioGoogle(String nickName);
}
