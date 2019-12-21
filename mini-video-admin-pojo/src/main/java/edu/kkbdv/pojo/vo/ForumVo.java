package edu.kkbdv.pojo.vo;



import java.util.Date;


public class ForumVo {

    private String id;

    private String forumTitle;

    private String forumAddress;

    private String forumDesc;

    private Integer joinCounts;

    private String forumDate;

    private String forumStart;

    private Integer forumDuration;

    private Integer status;

    private String userId;

    private Date createTime;

    private String forumCoverpath;

    private String endTime;

    private String nickname;

    private String faceImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForumTitle() {
        return forumTitle;
    }

    public void setForumTitle(String forumTitle) {
        this.forumTitle = forumTitle;
    }

    public String getForumAddress() {
        return forumAddress;
    }

    public void setForumAddress(String forumAddress) {
        this.forumAddress = forumAddress;
    }

    public String getForumDesc() {
        return forumDesc;
    }

    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }

    public Integer getJoinCounts() {
        return joinCounts;
    }

    public void setJoinCounts(Integer joinCounts) {
        this.joinCounts = joinCounts;
    }

    public String getForumDate() {
        return forumDate;
    }

    public void setForumDate(String forumDate) {
        this.forumDate = forumDate;
    }

    public String getForumStart() {
        return forumStart;
    }

    public void setForumStart(String forumStart) {
        this.forumStart = forumStart;
    }

    public Integer getForumDuration() {
        return forumDuration;
    }

    public void setForumDuration(Integer forumDuration) {
        this.forumDuration = forumDuration;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getForumCoverpath() {
        return forumCoverpath;
    }

    public void setForumCoverpath(String forumCoverpath) {
        this.forumCoverpath = forumCoverpath;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }
}
