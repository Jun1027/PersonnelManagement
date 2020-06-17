import com.github.pagehelper.PageInfo;
import jun.dao.TUserDao;
import jun.entity.TUser;
import jun.service.TUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * 用户测试
 * Create by Jun on 2020-05-18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-bean.xml","classpath:applicationContext-datasource.xml"})
public class ServiceTest {

    @Autowired
    TUserService tUserService;

    @Test
    public void login(){
        TUser user = tUserService.login("1136","123");
        System.out.println(user);
    }

    @Autowired
    TUserDao tUserDao;
    @Test
    public void t(){

        TUser tUser = tUserDao.selectByName("143");
        System.out.println(tUser);
        Set<String> set = tUserDao.selectRoleName("143");
        set.forEach(s->{
            System.out.println(s);
        });
        Set<String> set1 = tUserDao.selectPermissionName("143");
        set1.forEach(s->{
            System.out.println(s);
        });
    }


}
