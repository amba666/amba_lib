package org.smartregister.activity;

import android.content.Intent;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.amba.activity.BaseAmbaRegisterActivity;

public class BaseAmbaRegisterActivityTest {
    @Mock
    public Intent data;
    @Mock
    private BaseAmbaRegisterActivity baseAmbaRegisterActivity = new BaseAmbaRegisterActivity();

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseAmbaRegisterActivity);
    }

    @Test
    public void testFormConfig() {
        Assert.assertNull(baseAmbaRegisterActivity.getFormConfig());
    }

    @Test
    public void checkIdentifier() {
        Assert.assertNotNull(baseAmbaRegisterActivity.getViewIdentifiers());
    }

    @Test(expected = Exception.class)
    public void onActivityResult() throws Exception {
        Whitebox.invokeMethod(baseAmbaRegisterActivity, "onActivityResult", 2244, -1, data);
        Mockito.verify(baseAmbaRegisterActivity.presenter()).saveForm(null);
    }

}
