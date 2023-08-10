package com.example.sticky.Service;

import org.springframework.transaction.annotation.Transactional;
import com.example.sticky.Entity.Client;
import com.example.sticky.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(rollbackFor = Exception.class)
    public void cadastrar(@RequestBody final Client client){

        Assert.isTrue(client.getName().length() > 2, "O nome está faltando");

        this.clientRepository.save(client);
    }

    @Transactional(rollbackFor = Exception.class)
    public void edit(final Client client, final Long id){

        final Client brandBanco = this.clientRepository.findById(id).orElse(null);

        Assert.isTrue(brandBanco != null || this.clientRepository.findById(id).equals(client.getID()), "Não foi possivel indenficar o registro no banco");

        Assert.isTrue(client.getName().length() > 2, "O nome está faltando");

        Assert.isTrue(this.clientRepository.findByName(client.getName()).isEmpty(), "ja existe essa marca");

        this.clientRepository.save(client);
    }


    @Transactional(rollbackFor = Exception.class)
    public void delete(final Client client){
        final Client clientBanco = this.clientRepository.findById(client.getID()).orElse(null);

    }

}
