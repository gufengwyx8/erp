/*
 * @(#)KnowledgeAction.java 2015-4-4 下午02:45:11 erp-manufacture
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

import com.erp.model.Knowledge;

/**
 * KnowledgeAction
 * @author wang
 * @version 1.0
 *
 */
@Component("knowledgeAction")
@Scope("prototype")
public class KnowledgeAction extends BaseAction {
    
    public static final String UPLOAD_PATH = "/upload/knowledge";
    
    private Knowledge knowledge;

    private List<Knowledge> knowledgeList;
    
    private File file;

    private String fileFileName;

    private String fileContentType;
    
    private String content;
    
    public String listKnowledge() {
        knowledgeList = knowledgeService.list();
        return SUCCESS;
    }

    public String saveKnowledge() {
        knowledge.setDate(new Date());
        knowledge.setUser(loginUser);
        knowledgeService.saveOrUpdate(knowledge);
        msg = "success";
        return SUCCESS;
    }

    public String destoryKnowledge() {
        knowledge = knowledgeService.getEntityById(knowledge.getId());
        knowledgeService.delete(knowledge);
        return SUCCESS;
    }

    public String listKnowledgeDetail() {
        knowledge = knowledgeService.getEntityById(knowledge.getId());
        return SUCCESS;
    }
    
    public String submitContent(){
        knowledge = knowledgeService.getEntityById(knowledge.getId());
        knowledge.setContent(content);
        if (file != null) {
            knowledge.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            knowledge.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        knowledgeService.saveOrUpdate(knowledge);
        return SUCCESS;
    }

    public String download() {
        knowledge = knowledgeService.getEntityById(knowledge.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(knowledge.getRealFileName()));
        try {
            fileFileName = new String(knowledge.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 返回  knowledge
     * @return knowledge
     */
    public Knowledge getKnowledge() {
        return knowledge;
    }

    /**
     * 设置 knowledge
     * @param knowledge knowledge
     */
    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    /**
     * 返回  knowledgeList
     * @return knowledgeList
     */
    public List<Knowledge> getKnowledgeList() {
        return knowledgeList;
    }

    /**
     * 设置 knowledgeList
     * @param knowledgeList knowledgeList
     */
    public void setKnowledgeList(List<Knowledge> knowledgeList) {
        this.knowledgeList = knowledgeList;
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
