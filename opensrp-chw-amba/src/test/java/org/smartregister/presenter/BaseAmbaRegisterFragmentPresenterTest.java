package org.smartregister.presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.smartregister.chw.amba.contract.AmbaRegisterFragmentContract;
import org.smartregister.chw.amba.presenter.BaseAmbaRegisterFragmentPresenter;
import org.smartregister.chw.amba.util.Constants;
import org.smartregister.chw.amba.util.DBConstants;
import org.smartregister.configurableviews.model.View;

import java.util.Set;
import java.util.TreeSet;

public class BaseAmbaRegisterFragmentPresenterTest {
    @Mock
    protected AmbaRegisterFragmentContract.View view;

    @Mock
    protected AmbaRegisterFragmentContract.Model model;

    private BaseAmbaRegisterFragmentPresenter baseAmbaRegisterFragmentPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        baseAmbaRegisterFragmentPresenter = new BaseAmbaRegisterFragmentPresenter(view, model, "");
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseAmbaRegisterFragmentPresenter);
    }

    @Test
    public void getMainCondition() {
        Assert.assertEquals("", baseAmbaRegisterFragmentPresenter.getMainCondition());
    }

    @Test
    public void getDueFilterCondition() {
        Assert.assertEquals(" (cast( julianday(STRFTIME('%Y-%m-%d', datetime('now'))) -  julianday(IFNULL(SUBSTR(amba_test_date,7,4)|| '-' || SUBSTR(amba_test_date,4,2) || '-' || SUBSTR(amba_test_date,1,2),'')) as integer) between 7 and 14) ", baseAmbaRegisterFragmentPresenter.getDueFilterCondition());
    }

    @Test
    public void getDefaultSortQuery() {
        Assert.assertEquals(Constants.TABLES.AMBA_CONFIRMATION + "." + DBConstants.KEY.LAST_INTERACTED_WITH + " DESC ", baseAmbaRegisterFragmentPresenter.getDefaultSortQuery());
    }

    @Test
    public void getMainTable() {
        Assert.assertEquals(Constants.TABLES.AMBA_CONFIRMATION, baseAmbaRegisterFragmentPresenter.getMainTable());
    }

    @Test
    public void initializeQueries() {
        Set<View> visibleColumns = new TreeSet<>();
        baseAmbaRegisterFragmentPresenter.initializeQueries(null);
        Mockito.doNothing().when(view).initializeQueryParams("ec_amba_confirmation", null, null);
        Mockito.verify(view).initializeQueryParams("ec_amba_confirmation", null, null);
        Mockito.verify(view).initializeAdapter(visibleColumns);
        Mockito.verify(view).countExecute();
        Mockito.verify(view).filterandSortInInitializeQueries();
    }

}