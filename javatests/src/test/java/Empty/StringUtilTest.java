package Empty;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void test_string_is_not_empty(){
        Assert.assertFalse(StringUtil.isEmpty("Hello world"));
    }

    @Test
    public void test_string_is_empty(){
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void white_space_is_empty(){
        String str = new String(" ");
        Assert.assertTrue(StringUtil.isEmpty(str));
    }

    @Test
    public void null_is_empty(){
        Assert.assertTrue(StringUtil.isEmpty(null));
    }
}