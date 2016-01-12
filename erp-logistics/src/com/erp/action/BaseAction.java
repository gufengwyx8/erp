package com.erp.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.erp.model.User;
import com.erp.service.ContactService;
import com.erp.service.DeliveryService;
import com.erp.service.ProductService;
import com.erp.service.QuoteDetailService;
import com.erp.service.QuoteService;
import com.erp.service.RecommendDetailService;
import com.erp.service.RecommendService;
import com.erp.service.RecordService;
import com.erp.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class BaseAction extends ActionSupport implements SessionAware {

    @Resource(name = "userService")
    protected UserService userService;

    @Resource(name = "productService")
    protected ProductService productService;

    @Resource(name = "contactService")
    protected ContactService contactService;

    @Resource(name = "deliveryService")
    protected DeliveryService deliveryService;

    @Resource(name = "quoteService")
    protected QuoteService quoteService;

    @Resource(name = "quoteDetailService")
    protected QuoteDetailService quoteDetailService;

    @Resource(name = "recommendService")
    protected RecommendService recommendService;

    @Resource(name = "recommendDetailService")
    protected RecommendDetailService recommendDetailService;

    @Resource(name = "recordService")
    protected RecordService recordService;

    //常用的页面参数
    protected User user;

    protected User loginUser;

    protected String msg = "";

    protected String value;

    protected Integer id;

    protected int page;

    protected int rows = 20;

    protected Map<String, Object> session;

    protected ValueStack getValueStack() {
        return ActionContext.getContext().getValueStack();
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(msg.getBytes());
    }

    /**
     * 返回  user
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置 user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 返回  msg
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置 msg
     * @param msg msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回  id
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回  loginUser
     * @return loginUser
     */
    public User getLoginUser() {
        return loginUser;
    }

    /**
     * 设置 loginUser
     * @param loginUser loginUser
     */
    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 返回  page
     * @return page
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置 page
     * @param page page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 返回  rows
     * @return rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * 设置 rows
     * @param rows rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * 返回  value
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置 value
     * @param value value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
