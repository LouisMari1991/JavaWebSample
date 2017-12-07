package com.sync.changsha.gson.bean;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/7.
 */
public class MapBean {

  private int momeyTotal;
  private int volunteerTotal;
  private int gainTotal;
  private int activityTotal;
  private int publishTotal;
  private Map<String, Object> volunteerMap;

  public int getMomeyTotal() {
    return momeyTotal;
  }

  public void setMomeyTotal(int momeyTotal) {
    this.momeyTotal = momeyTotal;
  }

  public int getVolunteerTotal() {
    return volunteerTotal;
  }

  public void setVolunteerTotal(int volunteerTotal) {
    this.volunteerTotal = volunteerTotal;
  }

  public int getGainTotal() {
    return gainTotal;
  }

  public void setGainTotal(int gainTotal) {
    this.gainTotal = gainTotal;
  }

  public int getActivityTotal() {
    return activityTotal;
  }

  public void setActivityTotal(int activityTotal) {
    this.activityTotal = activityTotal;
  }

  public int getPublishTotal() {
    return publishTotal;
  }

  public void setPublishTotal(int publishTotal) {
    this.publishTotal = publishTotal;
  }

  public Map<String, Object> getVolunteerMap() {
    return volunteerMap;
  }

  public void setVolunteerMap(Map<String, Object> volunteerMap) {
    this.volunteerMap = volunteerMap;
  }

  @Override public String toString() {
    return "MapBean{" +
        "momeyTotal=" + momeyTotal +
        ", volunteerTotal=" + volunteerTotal +
        ", gainTotal=" + gainTotal +
        ", activityTotal=" + activityTotal +
        ", publishTotal=" + publishTotal +
        ", volunteerMap=" + volunteerMap +
        '}';
  }
}
