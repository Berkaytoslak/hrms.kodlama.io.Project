package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.dataAccsess.abstracts.CitiesRepository;
import kodlamaio.hrms.entities.concretes.Cities;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CitiesManagerTest {

    private CitiesManager citiesManager;

    private CitiesRepository citiesRepository;

    private final List<Cities> cities = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

        citiesRepository = Mockito.mock(CitiesRepository.class);

        citiesManager = new CitiesManager(citiesRepository);



    }

    @Test
    public void getAll() {

        Cities citie = new Cities();
        citie.setId(1);
        citie.setCity("Ankara123");

        cities.add(citie);

        Mockito.when(citiesRepository.findAll()).thenReturn(cities);

        List<Cities> cities1 = citiesManager.getAll().getData();

        assertEquals(cities1.size(),cities.size());



    }
}