package com.hx.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CementStrength {
    private Integer ID;

    private Integer sampleID;

    private String sampleNo;

    private String kind;

    private String sampleTime;

    private String shapeTime;

    private String destructTime;

    private String duration;

    private String hour;

    private String temperature;

    private String experimentStand;

    private String stressType;

    private String flexureType;

    private String stressNo;

    private String flexureNo;

    private String stressSta;

    private String flexureSta;

    private String stressVail;

    private String flexureVail;

    private String stressCKS;

    private String flexureCKS;

    private String notes;

    private String stress1;

    private String stress2;

    private String stress3;

    private String stress4;

    private String stress5;

    private String stress6;

    private String pressure1;

    private String pressure2;

    private String pressure3;

    private String pressure4;

    private String pressure5;

    private String pressure6;

    private String avgPressure;

    private String flexure1;

    private String flexure2;

    private String flexure3;

    private String avgFlexure;

    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  //前台传时间到后台时间格式转换
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8") //后传时间到前台时间格式转换
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getSampleID() {
        return sampleID;
    }

    public void setSampleID(Integer sampleID) {
        this.sampleID = sampleID;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo == null ? null : sampleNo.trim();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public String getSampleTime() {
        return sampleTime;
    }

    public void setSampleTime(String sampleTime) {
        this.sampleTime = sampleTime == null ? null : sampleTime.trim();
    }

    public String getShapeTime() {
        return shapeTime;
    }

    public void setShapeTime(String shapeTime) {
        this.shapeTime = shapeTime == null ? null : shapeTime.trim();
    }

    public String getDestructTime() {
        return destructTime;
    }

    public void setDestructTime(String destructTime) {
        this.destructTime = destructTime == null ? null : destructTime.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour == null ? null : hour.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getExperimentStand() {
        return experimentStand;
    }

    public void setExperimentStand(String experimentStand) {
        this.experimentStand = experimentStand == null ? null : experimentStand.trim();
    }

    public String getStressType() {
        return stressType;
    }

    public void setStressType(String stressType) {
        this.stressType = stressType == null ? null : stressType.trim();
    }

    public String getFlexureType() {
        return flexureType;
    }

    public void setFlexureType(String flexureType) {
        this.flexureType = flexureType == null ? null : flexureType.trim();
    }

    public String getStressNo() {
        return stressNo;
    }

    public void setStressNo(String stressNo) {
        this.stressNo = stressNo == null ? null : stressNo.trim();
    }

    public String getFlexureNo() {
        return flexureNo;
    }

    public void setFlexureNo(String flexureNo) {
        this.flexureNo = flexureNo == null ? null : flexureNo.trim();
    }

    public String getStressSta() {
        return stressSta;
    }

    public void setStressSta(String stressSta) {
        this.stressSta = stressSta == null ? null : stressSta.trim();
    }

    public String getFlexureSta() {
        return flexureSta;
    }

    public void setFlexureSta(String flexureSta) {
        this.flexureSta = flexureSta == null ? null : flexureSta.trim();
    }

    public String getStressVail() {
        return stressVail;
    }

    public void setStressVail(String stressVail) {
        this.stressVail = stressVail == null ? null : stressVail.trim();
    }

    public String getFlexureVail() {
        return flexureVail;
    }

    public void setFlexureVail(String flexureVail) {
        this.flexureVail = flexureVail == null ? null : flexureVail.trim();
    }

    public String getStressCKS() {
        return stressCKS;
    }

    public void setStressCKS(String stressCKS) {
        this.stressCKS = stressCKS == null ? null : stressCKS.trim();
    }

    public String getFlexureCKS() {
        return flexureCKS;
    }

    public void setFlexureCKS(String flexureCKS) {
        this.flexureCKS = flexureCKS == null ? null : flexureCKS.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getStress1() {
        return stress1;
    }

    public void setStress1(String stress1) {
        this.stress1 = stress1 == null ? null : stress1.trim();
    }

    public String getStress2() {
        return stress2;
    }

    public void setStress2(String stress2) {
        this.stress2 = stress2 == null ? null : stress2.trim();
    }

    public String getStress3() {
        return stress3;
    }

    public void setStress3(String stress3) {
        this.stress3 = stress3 == null ? null : stress3.trim();
    }

    public String getStress4() {
        return stress4;
    }

    public void setStress4(String stress4) {
        this.stress4 = stress4 == null ? null : stress4.trim();
    }

    public String getStress5() {
        return stress5;
    }

    public void setStress5(String stress5) {
        this.stress5 = stress5 == null ? null : stress5.trim();
    }

    public String getStress6() {
        return stress6;
    }

    public void setStress6(String stress6) {
        this.stress6 = stress6 == null ? null : stress6.trim();
    }

    public String getPressure1() {
        return pressure1;
    }

    public void setPressure1(String pressure1) {
        this.pressure1 = pressure1 == null ? null : pressure1.trim();
    }

    public String getPressure2() {
        return pressure2;
    }

    public void setPressure2(String pressure2) {
        this.pressure2 = pressure2 == null ? null : pressure2.trim();
    }

    public String getPressure3() {
        return pressure3;
    }

    public void setPressure3(String pressure3) {
        this.pressure3 = pressure3 == null ? null : pressure3.trim();
    }

    public String getPressure4() {
        return pressure4;
    }

    public void setPressure4(String pressure4) {
        this.pressure4 = pressure4 == null ? null : pressure4.trim();
    }

    public String getPressure5() {
        return pressure5;
    }

    public void setPressure5(String pressure5) {
        this.pressure5 = pressure5 == null ? null : pressure5.trim();
    }

    public String getPressure6() {
        return pressure6;
    }

    public void setPressure6(String pressure6) {
        this.pressure6 = pressure6 == null ? null : pressure6.trim();
    }

    public String getAvgPressure() {
        return avgPressure;
    }

    public void setAvgPressure(String avgPressure) {
        this.avgPressure = avgPressure == null ? null : avgPressure.trim();
    }

    public String getFlexure1() {
        return flexure1;
    }

    public void setFlexure1(String flexure1) {
        this.flexure1 = flexure1 == null ? null : flexure1.trim();
    }

    public String getFlexure2() {
        return flexure2;
    }

    public void setFlexure2(String flexure2) {
        this.flexure2 = flexure2 == null ? null : flexure2.trim();
    }

    public String getFlexure3() {
        return flexure3;
    }

    public void setFlexure3(String flexure3) {
        this.flexure3 = flexure3 == null ? null : flexure3.trim();
    }

    public String getAvgFlexure() {
        return avgFlexure;
    }

    public void setAvgFlexure(String avgFlexure) {
        this.avgFlexure = avgFlexure == null ? null : avgFlexure.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CementStrength{" +
                "ID=" + ID +
                ", sampleID=" + sampleID +
                ", sampleNo='" + sampleNo + '\'' +
                ", kind='" + kind + '\'' +
                ", sampleTime='" + sampleTime + '\'' +
                ", shapeTime='" + shapeTime + '\'' +
                ", destructTime='" + destructTime + '\'' +
                ", duration='" + duration + '\'' +
                ", notes='" + notes + '\'' +
                ", pressure1='" + pressure1 + '\'' +
                ", pressure2='" + pressure2 + '\'' +
                ", pressure3='" + pressure3 + '\'' +
                ", pressure4='" + pressure4 + '\'' +
                ", pressure5='" + pressure5 + '\'' +
                ", pressure6='" + pressure6 + '\'' +
                ", avgPressure='" + avgPressure + '\'' +
                ", flexure1='" + flexure1 + '\'' +
                ", flexure2='" + flexure2 + '\'' +
                ", flexure3='" + flexure3 + '\'' +
                ", avgFlexure='" + avgFlexure + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}