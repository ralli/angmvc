package angmvc.core.dao;

import angmvc.TestContext;
import angmvc.core.config.DataSourceConfig;
import angmvc.core.entities.Visit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataSourceConfig.class, TestContext.class })
@Transactional
public class VisitDaoTest {
  @Autowired
  private VisitDao visitDao;

  @Test
  public void testFindByPet() {
    final Long petId = 7L;
    List<Visit> visits = visitDao.findByPet(petId);
    assertFalse(visits.isEmpty());
  }

  @Test
  public void testFindById() {
    final Long visitId = 1L;
    Visit visit = visitDao.findById(visitId);
    assertNotNull(visit);
  }

  private Date createDate(int year, int month, int day) {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date(0L));
    c.set(Calendar.YEAR, year);
    c.set(Calendar.MONTH, month+1);
    c.set(Calendar.DAY_OF_MONTH, day);
    return c.getTime();
  }

  @Test
  public void testInsertUpdateDelete() {
    final long petId = 1L;
    Visit visit = new Visit();
    visit.setDescription("Test Visit");
    visit.setVisitDate(createDate(2011, 1, 21));
    visit.setPetId(petId);
    visitDao.insert(visit);
    assertNotNull(visit.getId());
    Long id = visit.getId();
    visit.setDescription("Another Description");
    visitDao.update(visit);
    visit = visitDao.findById(id);
    assertNotNull(visit);
    assertEquals("Another Description", visit.getDescription());
    visitDao.delete(visit);
    visit = visitDao.findById(id);
    assertNull(visit);
  }
}
