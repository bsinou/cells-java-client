package org.bsinou.cells.integration;

import com.pydio.cells.client.SessionFactory;
import com.pydio.cells.transport.auth.SimpleTokenStore;
import com.pydio.cells.transport.auth.TokenService;
import com.pydio.cells.utils.tests.TestConfiguration;
import com.pydio.cells.utils.tests.TestSessionFactory;
import com.pydio.cells.utils.tests.TestUtils;

import java.net.URL;

public class LocalTestUtils {

    private static final String accountFolder = "/accounts";

    public static URL getLocalResourceURL() {
        return TestConfiguration.class.getResource("/");
    }

    public static String getRunID () {
        return TestUtils.randomString(4);
    }

    public static URL getAccountURL() {
        return TestConfiguration.class.getResource(accountFolder);
    }

    public static TestConfiguration getConfig(){
        return new TestConfiguration(getAccountURL());
    }

    public static SessionFactory createFactory(){
        TokenService tokens = new TokenService(new SimpleTokenStore());
        return new TestSessionFactory(tokens);
    }



}


