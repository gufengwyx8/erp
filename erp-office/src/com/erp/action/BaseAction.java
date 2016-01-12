package com.erp.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.erp.model.User;
import com.erp.service.AdService;
import com.erp.service.InstitutionService;
import com.erp.service.KnowledgeService;
import com.erp.service.MeetingService;
import com.erp.service.PlanService;
import com.erp.service.ReportService;
import com.erp.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class BaseAction extends ActionSupport implements SessionAware {

    @Resource(name = "userService")
    protected UserService userService;

    @Resource(name = "adService")
    protected AdService adService;

    @Resource(name = "institutionService")
    protected InstitutionService institutionService;

    @Resource(name = "knowledgeService")
    protected KnowledgeService knowledgeService;

    @Resource(name = "meetingService")
    protected MeetingService meetingService;

    @Resource(name = "planService")
    protected PlanService planService;

    @Resource(name = "reportService")
    protected ReportService reportService;

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
