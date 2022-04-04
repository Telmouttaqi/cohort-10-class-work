package learn.DontWreckMyHouse.data;

import learn.DontWreckMyHouse.models.Host;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HostRepositoryDouble implements HostRepository{


    private List<Host> hosts = new ArrayList<>();

    public HostRepositoryDouble(){
        // hostId, lastName, email, phone, address, city, state, postalCode,BigDecimal standardRate, BigDecimal weekEndRate

        // host number 1 : e0a8112e-fd35-4054-af88-cb8448394004
        hosts.add(new Host("e0a8112e-fd35-4054-af88-cb8448394004","LastName","test@gmail.com",
                "6179439070","320 Washington","Greensboro"
                ,"MA","27409",new BigDecimal(230),new BigDecimal(500)));

        // host number 2 : e0a8112e-fd35-4054-af98-cb8448394004
        hosts.add(new Host("e0a8112e-fd35-4054-af98-cb8448394004","LastName2","test2@gmail.com",
                "9739803145","320 Washington","Malden"
                ,"NY","02148",new BigDecimal(280),new BigDecimal(600)));
    }

    @Override
    public List<Host> findAll() throws DataException {
        return hosts;
    }

    @Override
    public Host findHostByEmail(String hostEmail) throws DataException {
        return null;
    }


    @Override
    public Host findHostById(String hostId) throws DataException {
        return hosts.stream()
                .filter(h->h.getHostId().equalsIgnoreCase(hostId))
                .findFirst()
                .orElse(null);
    }


}
