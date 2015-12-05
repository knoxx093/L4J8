package no.stelar7.api.l4j8.tests;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import no.stelar7.api.l4j8.basic.DataCall;
import no.stelar7.api.l4j8.basic.DataCall.DataCallBuilder;
import no.stelar7.api.l4j8.basic.Server;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBase
{
    protected static DataCallBuilder builder = DataCall.builder();

    @BeforeClass
    public static void init()
    {
        TestBase.builder = DataCall.builder();
        TestBase.builder.asVerbose(true);
        TestBase.builder.withAPIKey(SecretFile.API_KEY);
        TestBase.builder.withServer(Server.EUW);
        TestBase.builder.withRegion(Server.EUW);
    }

}