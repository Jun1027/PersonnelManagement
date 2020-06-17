package jun.shiro.realm;

import jun.dao.TUserDao;
import jun.entity.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Create by Jun on 2020-05-22
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    TUserDao tUserDao;

    //确认用户的权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1、根据principalCollection（用户名）去数据库中查询该用户拥有的角色和权限
        String username = principalCollection.toString();
        Set<String> roles = tUserDao.selectRoleName(username);
        Set<String> premissions = tUserDao.selectPermissionName(username);
        //2、将角色和权限封装到AuthorizationInfo交给shiro
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(premissions);
        return authorizationInfo;
    }

    //确认用户的信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //authenticationToken就是收集到的用户的信息
        //1、根据用户提交的用户名，查看用户是否存在
        String username = authenticationToken.getPrincipal().toString();
        //2、查询数据库，确认用户名是存在
        TUser tUser = tUserDao.selectByName(username);
        if(tUser==null){
            throw new UnknownAccountException("用户名不存在！");
        }else{
            //存到shiro的session中
            SecurityUtils.getSubject().getSession().setAttribute("user",tUser);
            //3、如果用户存在，获取该用户的正确密码
            //4、将正确的用户名和密码提价给shiro判断
            //认证用户是否正确的工作还是要交给shiro，我们提供正确的用户名和密码
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,tUser.getUPwd(),this.getName());
            return authenticationInfo;
        }
    }
}
