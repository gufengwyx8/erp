/*
 * @(#)PlanAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.Plan;
import com.erp.model.PlanDetail;
import com.erp.model.Product;

/**
 * PlanAction
 * @author wang
 * @version 1.0
 *
 */
@Component("planAction")
@Scope("prototype")
public class PlanAction extends BaseAction {
    private Plan plan;

    private List<Plan> planList;

    private PlanDetail planDetail;

    private List<PlanDetail> planDetailList;

    private Product product;

    private List<Product> productList;

    public String listPlan() {
        planList = planService.list();
        return SUCCESS;
    }

    public String savePlan() {
        plan.setDate(new Date());
        plan.setUser(loginUser);
        planService.saveOrUpdate(plan);
        msg = "success";
        return SUCCESS;
    }

    public String destoryPlan() {
        plan = planService.getEntityById(plan.getId());
        for (PlanDetail pd : plan.getPlanDetailList()) {
            planDetailService.delete(pd);
        }
        planService.delete(plan);
        return SUCCESS;
    }

    public String listPlanDetail() {
        productList = productService.list();
        plan = planService.getEntityById(plan.getId());
        planDetailList = plan.getPlanDetailList();
        return SUCCESS;
    }

    public String savePlanDetail() {
        planDetailService.saveOrUpdate(planDetail);
        msg = "success";
        return SUCCESS;
    }

    public String destoryPlanDetail() {
        planDetailService.delete(planDetail);
        return SUCCESS;
    }

    /**
     * 返回  plan
     * @return plan
     */
    public Plan getPlan() {
        return plan;
    }

    /**
     * 设置 plan
     * @param plan plan
     */
    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    /**
     * 返回  planList
     * @return planList
     */
    public List<Plan> getPlanList() {
        return planList;
    }

    /**
     * 设置 planList
     * @param planList planList
     */
    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

    /**
     * 返回  planDetail
     * @return planDetail
     */
    public PlanDetail getPlanDetail() {
        return planDetail;
    }

    /**
     * 设置 planDetail
     * @param planDetail planDetail
     */
    public void setPlanDetail(PlanDetail planDetail) {
        this.planDetail = planDetail;
    }

    /**
     * 返回  planDetailList
     * @return planDetailList
     */
    public List<PlanDetail> getPlanDetailList() {
        return planDetailList;
    }

    /**
     * 设置 planDetailList
     * @param planDetailList planDetailList
     */
    public void setPlanDetailList(List<PlanDetail> planDetailList) {
        this.planDetailList = planDetailList;
    }

    /**
     * 返回  product
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * 设置 product
     * @param product product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * 返回  productList
     * @return productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * 设置 productList
     * @param productList productList
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
