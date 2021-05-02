package com.xpr.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.xpr.dao.ClientRepository;
import com.xpr.entities.Client;
import com.xpr.exceptions.ClientException;

@Service
public class ClientServiceImp implements ClientService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImp.class);
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client saveClient(Client client) {
		LOGGER.info("Ajout d'un nouveau client : {} ", client.getNom());
		return clientRepository.save(client);
	}

	@Override
	public Client findClientByIce(String ice) throws ClientException {
		LOGGER.info("Récuperation du client par ice : {} ", ice);
		
		Client c = clientRepository.findById(ice).orElse(null);
		
		if(c==null) {
			throw new ClientException("Client ice : "+ice+" introuvable");
		}
		return c;
	}

	@Override
	public Page<Client> findAllClientByMc(String mc, int page, int size) {
		LOGGER.info("Récuperation des client par mot clé : {} ", mc);
		return clientRepository.findClientByNom(mc, PageRequest.of(page, size));
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client updateClient(String ice, Client client) {
		LOGGER.info("Modification du client : {} ", client.getNom());
		client.setIce(ice);
		return clientRepository.save(client);
	}

	@Override
	public void deleteClient(String ice) {
		LOGGER.info("Suppresion client ice : {} ", ice);
		Client c = clientRepository.findById(ice).orElse(null);
		c.setDisabled(true);
		clientRepository.delete(c);
		
	}

}
