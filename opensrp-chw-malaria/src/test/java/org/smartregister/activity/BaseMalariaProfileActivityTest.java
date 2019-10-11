package org.smartregister.activity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.smartregister.chw.malaria.activity.BaseMalariaProfileActivity;

public class BaseMalariaProfileActivityTest {
    @Mock
    protected BaseMalariaProfileActivity baseMalariaProfileActivity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseMalariaProfileActivity);
    }

    @Test
    public void setProfileViewWithData() {
        baseMalariaProfileActivity.setProfileViewWithData();
        Mockito.verify(view, Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void setDueColor() {
        baseMalariaProfileActivity.setDueColor();
        Mockito.verify(view, Mockito.never()).setBackgroundColor(Color.BLUE);
    }

    @Test
    public void setOverDueColor() {
        baseMalariaProfileActivity.setOverDueColor();
        Mockito.verify(view, Mockito.never()).setBackgroundColor(Color.RED);
    }

    @Test
    public void checkFormattedTime() {
        baseMalariaProfileActivity.formatTime("2019-10-07");
        Mockito.verify(view, Mockito.never()).setBackgroundColor(Color.RED);
    }

}
