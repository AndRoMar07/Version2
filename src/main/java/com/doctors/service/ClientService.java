package com.doctors.service;

import com.doctors.model.ClientModel;
import com.doctors.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients(){
       return clientRepository.getAllClients();
        }

    public Optional<ClientModel> getClient(Integer id){
       return clientRepository.getClient(id);
    }

    public ClientModel saveClient(ClientModel clientModel){
        if (clientModel.getIdClient()==null){
            return clientRepository.saveClient(clientModel);
              }
        else { Optional<ClientModel> clientModel1=clientRepository.getClient(clientModel.getIdClient());
            if (clientModel1.isEmpty()) {
                return clientRepository.saveClient(clientModel);
                                        }
            else {
                return clientModel;
                }
            }
    }

    public boolean deleteClient(Integer id){
        return clientRepository.deleteClient(id);
    }

    public ClientModel updateClient(ClientModel clientModel){
           return clientRepository.saveClient(clientModel);
      }
}
