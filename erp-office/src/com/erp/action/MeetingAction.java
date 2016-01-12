/*
 * @(#)MeetingAction.java 2015-4-4 下午02:45:11 erp-manufacture
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

import com.erp.model.Meeting;
import com.erp.model.Plan;

/**
 * MeetingAction
 * @author wang
 * @version 1.0
 *
 */
@Component("meetingAction")
@Scope("prototype")
public class MeetingAction extends BaseAction {

    public static final String UPLOAD_PATH = "/upload/meeting";

    private Meeting meeting;

    private List<Meeting> meetingList;

    private File file;

    private String fileFileName;

    private String fileContentType;

    private String content;

    public String listMeeting() {
        meetingList = meetingService.list();
        return SUCCESS;
    }

    public String saveMeeting() {
        meeting.setDate(new Date());
        meeting.setUser(loginUser);
        meetingService.saveOrUpdate(meeting);
        msg = "success";
        return SUCCESS;
    }

    public String destoryMeeting() {
        meeting = meetingService.getEntityById(meeting.getId());
        for (Plan p : planService.listByMeeting(meeting)) {
            planService.delete(p);
        }
        meetingService.delete(meeting);
        return SUCCESS;
    }

    public String listMeetingDetail() {
        meeting = meetingService.getEntityById(meeting.getId());
        return SUCCESS;
    }

    public String submitContent() {
        meeting = meetingService.getEntityById(meeting.getId());
        meeting.setContent(content);
        if (file != null) {
            meeting.setFileName(fileFileName);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            String uuid = UUID.randomUUID().toString();
            meeting.setRealFileName(uuid);
            File newFile = new File(realpath, uuid);
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        meetingService.saveOrUpdate(meeting);
        return SUCCESS;
    }

    public String download() {
        meeting = meetingService.getEntityById(meeting.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(meeting.getRealFileName()));
        try {
            fileFileName = new String(meeting.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 返回  meeting
     * @return meeting
     */
    public Meeting getMeeting() {
        return meeting;
    }

    /**
     * 设置 meeting
     * @param meeting meeting
     */
    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    /**
     * 返回  meetingList
     * @return meetingList
     */
    public List<Meeting> getMeetingList() {
        return meetingList;
    }

    /**
     * 设置 meetingList
     * @param meetingList meetingList
     */
    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = meetingList;
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
