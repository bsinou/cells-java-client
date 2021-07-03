package org.bsinou.cells.integration;

import com.pydio.cells.client.ClientFactory;
import com.pydio.cells.utils.tests.TestClientFactory;
import com.pydio.cells.utils.tests.TestConfiguration;
import com.pydio.cells.utils.tests.TestUtils;

import java.net.URL;

public class LocalTestUtils {

    private static final String accountFolder = "/accounts";

    public static URL getLocalResourceURL() {
        return TestConfiguration.class.getResource("/");
    }

    public static String getRunID() {
        return TestUtils.randomString(4);
    }

    public static URL getAccountURL() {
        return TestConfiguration.class.getResource(accountFolder);
    }

    public static TestConfiguration getConfig() {
        return new TestConfiguration(getAccountURL());
    }

    public static ClientFactory createFactory() {
        // TokenService tokens = new TokenService(new SimpleTokenStore());
        return new TestClientFactory();
    }

}


