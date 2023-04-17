package org.apache.bookkeeper;
import org.apache.bookkeeper.conf.ServerConfiguration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDebug {
    @Test
    public void test() throws Exception {
        ServerConfiguration config = new ServerConfiguration();

        int count = 0;
        String name = (String) config.getProperty("name");

        String age = (String) config.getProperty("age");
        System.out.println("name: " + name + ", age: " + age);

        String str = (String) config.getProperty("fake-param");
        config.setProperty("fake2", 200);
        config.setProperty("fake3", 300);
        assertEquals(200, config.getProperty("fake2"));

        //System.out.println(str);
        if (str != null) {
            if (str.equals("always")) {
                System.out.println("always");
                count++;
                // This should fail if the fuzzer is not specified with -DexpectedException=java.lang.AssertionError
                assertEquals(200, config.getProperty("fake3"));
            } else if (str.equals("asneeded")) {
                System.out.println("asneeded");
                count--;
                throw new Exception("Fake Bug asneeded");
            } else {
                System.out.println(str);
            }
        } else {
            System.out.println("str is null!!!");
        }
    }
}