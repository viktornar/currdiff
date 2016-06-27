package lt.viktornar.currdiff.context;


import lt.viktornar.currdiff.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppConfig.class)
public class CurrDiffContextTest {
    /**
     * Just an empty method witch is used only for context startup and validation test.
     */
    @Test
    public void testEmpty() {
        Assert.assertTrue(true);
    }
}