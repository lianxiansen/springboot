
package com.kamfu.controller;


import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.kamfu.mapper.RoleMapper;
import com.kamfu.model.dto.UserInfo;
import com.kamfu.service.BoxService;
import com.kamfu.service.CabinetService;
import com.kamfu.service.DeliverService;
import com.kamfu.service.DeptService;
import com.kamfu.service.DictionaryClassService;
import com.kamfu.service.DictionaryService;
import com.kamfu.service.PermissionService;
import com.kamfu.service.RoleService;
import com.kamfu.service.UserService;
import com.kamfu.util.HttpContext;

/**
 * 鎺у埗鍣ㄥ熀绫伙紝灏佽涓�浜涙帶鍒跺櫒甯哥敤鐨勬柟娉�
 *
 * @author fengshuonan
 * @Date 2018/7/23 涓嬪崍3:45
 */
public class BaseController {
	protected int pagesize=20;
    protected final String REDIRECT = "redirect:";
    protected final String FORWARD = "forward:";
    @Autowired
    protected DeptService deptService;
    @Autowired
    protected  PermissionService permissionService;
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected  RoleMapper roleMapper;
    @Autowired
    protected UserService userService;
    @Autowired
    protected BoxService boxService;
    @Autowired
    protected DictionaryClassService dictionaryClassService;
    @Autowired
    protected DictionaryService dictionaryService;
    @Autowired
    protected CabinetService cabinetService;
    @Autowired
    protected DeliverService deliverService;
    protected HttpServletRequest getHttpServletRequest() {
        return HttpContext.getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return HttpContext.getResponse();
    }

    protected HttpSession getSession() {
        return Objects.requireNonNull(HttpContext.getRequest()).getSession();
    }

    protected HttpSession getSession(Boolean flag) {
        return Objects.requireNonNull(HttpContext.getRequest()).getSession(flag);
    }

    protected String getPara(String name) {
        return Objects.requireNonNull(HttpContext.getRequest()).getParameter(name);
    }

    protected void setAttr(String name, Object value) {
        Objects.requireNonNull(HttpContext.getRequest()).setAttribute(name, value);
    }



    /**
     * 鍒犻櫎cookie
     */
    protected void deleteCookieByName(String cookieName) {
        Cookie[] cookies = this.getHttpServletRequest().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                Cookie temp = new Cookie(cookie.getName(), "");
                temp.setMaxAge(0);
                this.getHttpServletResponse().addCookie(temp);
            }
        }
    }

    /**
     * 鍒犻櫎鎵�鏈塩ookie
     */
    protected void deleteAllCookie() {
        Cookie[] cookies = this.getHttpServletRequest().getCookies();
        for (Cookie cookie : cookies) {
            Cookie temp = new Cookie(cookie.getName(), "");
            temp.setMaxAge(0);
            this.getHttpServletResponse().addCookie(temp);
        }
    }

    /**
     * 杩斿洖鍓嶅彴鏂囦欢娴�
     *
     * @author fengshuonan
     * @date 2017骞�2鏈�28鏃� 涓嬪崍2:53:19
     */
    protected ResponseEntity<InputStreamResource> renderFile(String fileName, String filePath) {
        FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}
        return renderFile(fileName, inputStream);
    }

    /**
     * 杩斿洖鍓嶅彴鏂囦欢娴�
     *
     * @author fengshuonan
     * @date 2017骞�2鏈�28鏃� 涓嬪崍2:53:19
     */
    protected ResponseEntity<InputStreamResource> renderFile(String fileName, byte[] fileBytes) {
        return renderFile(fileName, new ByteArrayInputStream(fileBytes));
    }

    /**
     * 杩斿洖鍓嶅彴鏂囦欢娴�
     *
     * @param fileName    鏂囦欢鍚�
     * @param inputStream 杈撳叆娴�
     * @return
     * @author 0x0001
     */
    protected ResponseEntity<InputStreamResource> renderFile(String fileName, InputStream inputStream) {
        InputStreamResource resource = new InputStreamResource(inputStream);
        String dfileName = null;
        try {
            dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<>(resource, headers, HttpStatus.CREATED);
    }
    
    protected UserInfo getUser() {
    	UserInfo user=  (UserInfo) SecurityUtils.getSubject().getPrincipal();
    	return user;
	}
    
}
