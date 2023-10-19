package org.smartregister.dao;

import net.sqlcipher.database.SQLiteDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.smartregister.chw.amba.dao.AmbaDao;
import org.smartregister.repository.Repository;

@RunWith(MockitoJUnitRunner.class)
public class AmbaDaoTest extends AmbaDao {

    @Mock
    private Repository repository;

    @Mock
    private SQLiteDatabase database;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        setRepository(repository);
    }

    @Test
    public void testGetAmbaTestDate() {
        Mockito.doReturn(database).when(repository).getReadableDatabase();
        AmbaDao.getAmbaTestDate("123456");
        Mockito.verify(database).rawQuery(Mockito.anyString(), Mockito.any());
    }

    @Test
    public void testIsRegisteredForAmba() {
        Mockito.doReturn(database).when(repository).getReadableDatabase();
        boolean registered = AmbaDao.isRegisteredForAmba("12345");
        Mockito.verify(database).rawQuery(Mockito.anyString(), Mockito.any());
        Assert.assertFalse(registered);
    }
}

