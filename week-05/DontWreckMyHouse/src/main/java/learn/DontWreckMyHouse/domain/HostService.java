package learn.DontWreckMyHouse.domain;

import learn.DontWreckMyHouse.data.DataException;

import learn.DontWreckMyHouse.data.HostRepository;

import learn.DontWreckMyHouse.models.Host;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class HostService {

    private final HostRepository repository;


    public HostService(HostRepository repository) {
        this.repository = repository;
    }

    // find all
    public List<Host> findAll() throws DataException {
        return repository.findAll();
    }

    // find host by email

    public Host findHostByEmail(String hostEmail) throws DataException {
        Host host = repository.findHostByEmail(hostEmail);
        return repository.findHostByEmail(hostEmail);
    }


}



