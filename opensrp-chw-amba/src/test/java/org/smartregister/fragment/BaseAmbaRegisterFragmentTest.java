package org.smartregister.fragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.amba.activity.BaseAmbaProfileActivity;
import org.smartregister.chw.amba.fragment.BaseAmbaRegisterFragment;
import org.smartregister.commonregistry.CommonPersonObjectClient;

import static org.mockito.Mockito.times;

public class BaseAmbaRegisterFragmentTest {
    @Mock
    public BaseAmbaRegisterFragment baseAmbaRegisterFragment;

    @Mock
    public CommonPersonObjectClient client;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void openProfile() throws Exception {
        Whitebox.invokeMethod(baseAmbaRegisterFragment, "openProfile", client);
        PowerMockito.mockStatic(BaseAmbaProfileActivity.class);
        BaseAmbaProfileActivity.startProfileActivity(null, null);
        PowerMockito.verifyStatic(times(1));

    }
}
