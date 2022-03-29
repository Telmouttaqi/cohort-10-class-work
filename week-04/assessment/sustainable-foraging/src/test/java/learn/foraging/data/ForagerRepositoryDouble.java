package learn.foraging.data;

import learn.foraging.models.Forager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForagerRepositoryDouble implements ForagerRepository {

    public final static Forager FORAGER = makeForager();

    private final ArrayList<Forager> foragers = new ArrayList<>();

    public ForagerRepositoryDouble() {
        foragers.add(FORAGER);
    }

    @Override
    public Forager findById(String id) {
        return foragers.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Forager> findAll() {
        return foragers;
    }

    @Override
    public List<Forager> findByState(String stateAbbr) {
        return foragers.stream()
                .filter(i -> i.getState().equalsIgnoreCase(stateAbbr))
                .collect(Collectors.toList());
    }

    @Override
    public Forager add(Forager forager) {
        return null;
    }



    private static Forager makeForager() {
        Forager forager = new Forager();
        forager.setId("f4b050a5-060a-4450-b621-3b386776a716");
        forager.setFirstName("Tawfik");
        forager.setLastName("Mouttaqi");
        forager.setState("NC");
        return forager;
    }



}
