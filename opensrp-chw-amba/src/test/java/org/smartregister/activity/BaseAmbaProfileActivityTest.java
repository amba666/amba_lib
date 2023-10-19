package org.smartregister.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.amba.activity.BaseAmbaProfileActivity;
import org.smartregister.chw.amba.contract.AmbaProfileContract;
import org.smartregister.domain.AlertStatus;
import org.smartregister.amba.R;

import static org.mockito.Mockito.validateMockitoUsage;

public class BaseAmbaProfileActivityTest {
    @Mock
    public BaseAmbaProfileActivity baseAmbaProfileActivity;

    @Mock
    public AmbaProfileContract.Presenter profilePresenter;

    @Mock
    public View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseAmbaProfileActivity);
    }

    @Test
    public void setOverDueColor() {
        baseAmbaProfileActivity.setOverDueColor();
        Mockito.verify(view, Mockito.never()).setBackgroundColor(Color.RED);
    }

    @Test
    public void formatTime() {
        BaseAmbaProfileActivity activity = new BaseAmbaProfileActivity();
        try {
            Assert.assertEquals("25 Oct 2019", Whitebox.invokeMethod(activity, "formatTime", "25-10-2019"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkHideView() {
        baseAmbaProfileActivity.hideView();
        Mockito.verify(view, Mockito.never()).setVisibility(View.GONE);
    }

    @Test
    public void checkProgressBar() {
        baseAmbaProfileActivity.showProgressBar(true);
        Mockito.verify(view, Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void medicalHistoryRefresh() {
        baseAmbaProfileActivity.refreshMedicalHistory(true);
        Mockito.verify(view, Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void onClickBackPressed() {
        baseAmbaProfileActivity = Mockito.spy(new BaseAmbaProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.title_layout);
        Mockito.doNothing().when(baseAmbaProfileActivity).onBackPressed();
        baseAmbaProfileActivity.onClick(view);
        Mockito.verify(baseAmbaProfileActivity).onBackPressed();
    }

    @Test
    public void onClickOpenMedicalHistory() {
        baseAmbaProfileActivity = Mockito.spy(new BaseAmbaProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.rlLastVisit);
        Mockito.doNothing().when(baseAmbaProfileActivity).openMedicalHistory();
        baseAmbaProfileActivity.onClick(view);
        Mockito.verify(baseAmbaProfileActivity).openMedicalHistory();
    }

    @Test
    public void onClickOpenUpcomingServices() {
        baseAmbaProfileActivity = Mockito.spy(new BaseAmbaProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.rlUpcomingServices);
        Mockito.doNothing().when(baseAmbaProfileActivity).openUpcomingService();
        baseAmbaProfileActivity.onClick(view);
        Mockito.verify(baseAmbaProfileActivity).openUpcomingService();
    }

    @Test
    public void onClickOpenFamlilyServicesDue() {
        baseAmbaProfileActivity = Mockito.spy(new BaseAmbaProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.rlFamilyServicesDue);
        Mockito.doNothing().when(baseAmbaProfileActivity).openFamilyDueServices();
        baseAmbaProfileActivity.onClick(view);
        Mockito.verify(baseAmbaProfileActivity).openFamilyDueServices();
    }

    @Test(expected = Exception.class)
    public void refreshFamilyStatusComplete() throws Exception {
        baseAmbaProfileActivity = Mockito.spy(new BaseAmbaProfileActivity());
        TextView textView = view.findViewById(R.id.textview_family_has);
        Whitebox.setInternalState(baseAmbaProfileActivity, "tvFamilyStatus", textView);
        Mockito.doNothing().when(baseAmbaProfileActivity).showProgressBar(false);
        baseAmbaProfileActivity.refreshFamilyStatus(AlertStatus.complete);
        Mockito.verify(baseAmbaProfileActivity).showProgressBar(false);
        PowerMockito.verifyPrivate(baseAmbaProfileActivity).invoke("setFamilyStatus", "Family has nothing due");
    }

    @Test(expected = Exception.class)
    public void refreshFamilyStatusNormal() throws Exception {
        baseAmbaProfileActivity = Mockito.spy(new BaseAmbaProfileActivity());
        TextView textView = view.findViewById(R.id.textview_family_has);
        Whitebox.setInternalState(baseAmbaProfileActivity, "tvFamilyStatus", textView);
        Mockito.doNothing().when(baseAmbaProfileActivity).showProgressBar(false);
        baseAmbaProfileActivity.refreshFamilyStatus(AlertStatus.complete);
        Mockito.verify(baseAmbaProfileActivity).showProgressBar(false);
        PowerMockito.verifyPrivate(baseAmbaProfileActivity).invoke("setFamilyStatus", "Family has services due");
    }

    @Test(expected = Exception.class)
    public void onActivityResult() throws Exception {
        baseAmbaProfileActivity = Mockito.spy(new BaseAmbaProfileActivity());
        Whitebox.invokeMethod(baseAmbaProfileActivity, "onActivityResult", 2244, -1, null);
        Mockito.verify(profilePresenter).saveForm(null);
    }

}
