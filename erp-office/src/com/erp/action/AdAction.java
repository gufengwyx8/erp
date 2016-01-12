/*
 * @(#)AdAction.java 2015-4-4 下午02:45:11 erp-manufacture
 */
package com.erp.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.erp.model.Ad;

/**
 * AdAction
 * @author wang
 * @version 1.0
 *
 */
@Component("adAction")
@Scope("prototype")
public class AdAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/ad";
    
    private Ad ad;

    private List<Ad> adList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listAd() {
        adList = adService.list();
        return SUCCESS;
    }

    public String saveAd() {
        ad.setDate(new Date());
        ad.setUser(loginUser);
        adService.saveOrUpdate(ad);
        msg = "success";
        return SUCCESS;
    }

    public String destoryAd() {
        ad = adService.getEntityById(ad.getId());
        adService.delete(ad);
        return SUCCESS;
    }

    public String listAdDetail() {
        ad = adService.getEntityById(ad.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        ad = adService.getEntityById(ad.getId());
        ad.setContent(content);
        if (file != null) {
            ad.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            ad.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        adService.saveOrUpdate(ad);
        return SUCCESS;
    }

    public String download() {
        ad = adService.getEntityById(ad.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(ad.getRealFileName()));
        try {
            fileFileName = new String(ad.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 返回  ad
     * @return ad
     */
    public Ad getAd() {
        return ad;
    }

    /**
     * 设置 ad
     * @param ad ad
     */
    public void setAd(Ad ad) {
        this.ad = ad;
    }

    /**
     * 返回  adList
     * @return adList
     */
    public List<Ad> getAdList() {
        return adList;
    }

    /**
     * 设置 adList
     * @param adList adList
     */
    public void setAdList(List<Ad> adList) {
        this.adList = adList;
    }
    
    /**
     * 返回  file
     * @return file
     */
    public File getFile() {
        return file;
    }

    /**
     * 设置 file
     * @param file file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * 返回  fileFileName
     * @return fileFileName
     */
    public String getFileFileName() {
        return fileFileName;
    }

    /**
     * 设置 fileFileName
     * @param fileFileName fileFileName
     */
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    /**
     * 返回  fileContentType
     * @return fileContentType
     */
    public String getFileContentType() {
        return fileContentType;
    }

    /**
     * 设置 fileContentType
     * @param fileContentType fileContentType
     */
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
    
    /**
     * 返回  fileContentType
     * @return fileContentType
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 fileContentType
     * @param fileContentType fileContentType
     */
    public void setContent(String content) {
        this.content = content;
    }

}
