package com.wj5633.pms;

import com.wj5633.pms.auth.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @author wj
 * @create 2018-09-20 9:22
 **/
public class CustomRealmTest {

    @Test
    public void testAuthentication() {
        CustomRealm customRealm = new CustomRealm();
        customRealm.setPermissionsLookupEnabled(true);

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(customRealm);

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken("admin", "123456");

        subject.login(token);

        subject.checkRole("admin");
        subject.checkRoles("admin", "user");

        subject.checkPermissions("admin:read");
        subject.checkPermissions("admin:read", "admin:write");
        subject.checkPermissions("user:read");
        subject.checkPermissions("user:read", "user:write");
    }
}
