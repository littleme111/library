import fr.afpa.balthazar.logic.configuration.AppConfig;
import fr.afpa.balthazar.logic.dao.LivreDao;
import fr.afpa.balthazar.logic.model.Auteur;
import fr.afpa.balthazar.logic.model.Collection;
import fr.afpa.balthazar.logic.model.Livre;
import fr.afpa.balthazar.logic.service.LivreService;
import fr.afpa.balthazar.logic.service.LivreServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import static junit.framework.Assert.assertEquals;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
public class livresTests {

    @Mock
    LivreDao livreDao;

    @InjectMocks
    LivreServiceImpl livreService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        List<Livre> listLivres = new ArrayList<Livre>();
        Livre livre1 = new Livre();
        listLivres.add(livre1);
        Mockito.when(livreService.trouverTous()).thenReturn(listLivres);
    }


    @Test
    public void test(){
        List<Livre> ll = livreService.trouverTous();
        assertEquals("array size is not correct", 1, ll.size());


    }

    @After
    public void tearDown(){}

}