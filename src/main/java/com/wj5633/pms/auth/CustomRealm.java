package com.wj5633.pms.auth;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

/**
 * @author wj
 * @create 2018-09-20 9:36
 **/
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    protected boolean permissionsLookupEnabled = false;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        String username = (String) getAvailablePrincipal(principals);

        Set<String> roleNames = getRoleNamesForUser(username);
        Set<String> permissions = null;
        if (permissionsLookupEnabled) {
            permissions = getPermissions(username, roleNames);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    private Set<String> getPermissions(String username, Set<String> roleNames) {
        Set<String> permissions = Sets.newHashSet();
        if ("admin".equals(username)) {
            for (String role : roleNames) {
                permissions.add(role + ":read");
                if ("admin".equals(role)) {
                    permissions.add(role + ":write");
                }
            }
        }
        return permissions;
    }

    private Set<String> getRoleNamesForUser(String username) {
        if ("admin".equals(username)) {
            return Sets.newHashSet("admin", "user");
        }
        return Sets.newHashSet();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        String password = getPasswordForUser(username);

        if (password == null) {
            throw new UnknownAccountException("No account found for user [" + username + "]");
        }
        return new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
    }

    private String getPasswordForUser(String username) {
        if ("admin".equals(username)) {
            return "123456";
        }
        return null;
    }

    public boolean isPermissionsLookupEnabled() {
        return permissionsLookupEnabled;
    }

    public void setPermissionsLookupEnabled(boolean permissionsLookupEnabled) {
        this.permissionsLookupEnabled = permissionsLookupEnabled;
    }
}
