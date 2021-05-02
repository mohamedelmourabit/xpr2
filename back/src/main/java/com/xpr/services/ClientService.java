package com.xpr.services;

import java.util.List;
import org.springframework.data.domain.Page;
import com.xpr.entities.Client;
import com.xpr.exceptions.ClientException;

public interface ClientService {
	
	public Client saveClient(Client client);

	public Client findClientByIce(String ice) throws ClientException;

	public Page<Client> findAllClientByMc(String mc, int page, int size);

	public List<Client> findAll();

	public Client updateClient(String ice, Client client);

	public void deleteClient(String ice);
	

}
