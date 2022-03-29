package learn.DontWreckMyHouse.data;
import learn.DontWreckMyHouse.models.Host;

import java.util.List;

public interface HostRepository {

    List<Host> findAll();

    List<Host> findGuestById();

    List<Host> findGuestByEmail();
}
