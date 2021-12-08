package com.wanghuiwen.user.queue;


import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 活动开始前 3 / 7 天提醒
 */
public class NotificationDelayedMessage implements Delayed {

    private String notificationTitle;
    private String notificationContext;
    private Map<String,String> data;
    private Long startDate;
    private String id;
    private Long eventId;
    /**
     * 1 通知
     * 2 referral
     */
    private int type;

    /**
     * 获得延迟时间 过期时间减去当前时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        long remaining = startDate - System.currentTimeMillis();
        return unit.convert(remaining, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }


    @Override
    public boolean equals(Object o) {
        if(!(o instanceof NotificationDelayedMessage)) return false;
        if (this == o) return true;
        NotificationDelayedMessage that = (NotificationDelayedMessage) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationContext() {
        return notificationContext;
    }

    public void setNotificationContext(String notificationContext) {
        this.notificationContext = notificationContext;
    }

    public String getId() {
        return id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
