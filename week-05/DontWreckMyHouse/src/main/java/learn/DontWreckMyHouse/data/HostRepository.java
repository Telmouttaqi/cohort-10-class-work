package learn.DontWreckMyHouse.data;
import learn.DontWreckMyHouse.models.Guest;
import learn.DontWreckMyHouse.models.Host;

import java.util.List;

public interface HostRepository {

    List<Host> findAll();

    Host findHostByEmail(String hostEmail);

    Host findHostById(String hostId);
}
