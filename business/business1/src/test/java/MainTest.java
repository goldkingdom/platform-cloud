import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Welink on 2017/6/30.
 */
public class MainTest {

    public static final BigDecimal maxValue = new BigDecimal(Double.MAX_VALUE);

    @Test
    public void readMaxValue() {
//        Double d = Double.POSITIVE_INFINITY;
//        Double d1 = Double.MAX_VALUE;
//        System.out.println(d1 > d);
        System.out.println(maxValue);
    }

    @Test
    public void lamda() {
        List<Map> list = Lists.newArrayList();
        Map map = Maps.newHashMap();
        System.out.println(map);
    }

}
