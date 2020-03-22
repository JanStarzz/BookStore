package com.study.test;

import com.study.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;



/**
 * @author 17672
 */
public class BeatUtilTest {
    @Test
    public void Test() throws InvocationTargetException, IllegalAccessException {
        User user = new User();
        Map map = null;
        BeanUtils.populate(user,map);
        System.out.println(user);
    }
}
