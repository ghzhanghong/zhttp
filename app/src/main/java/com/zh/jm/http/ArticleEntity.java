package com.zh.jm.http;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleEntity {

    @SerializedName("adminAdd")
    private Boolean adminAdd;
    @SerializedName("apkLink")
    private String apkLink;
    @SerializedName("audit")
    private Integer audit;
    @SerializedName("author")
    private String author;
    @SerializedName("canEdit")
    private Boolean canEdit;
    @SerializedName("chapterId")
    private Integer chapterId;
    @SerializedName("chapterName")
    private String chapterName;
    @SerializedName("collect")
    private Boolean collect;
    @SerializedName("courseId")
    private Integer courseId;
    @SerializedName("desc")
    private String desc;
    @SerializedName("descMd")
    private String descMd;
    @SerializedName("envelopePic")
    private String envelopePic;
    @SerializedName("fresh")
    private Boolean fresh;
    @SerializedName("host")
    private String host;
    @SerializedName("id")
    private Integer id;
    @SerializedName("isAdminAdd")
    private Boolean isAdminAdd;
    @SerializedName("link")
    private String link;
    @SerializedName("niceDate")
    private String niceDate;
    @SerializedName("niceShareDate")
    private String niceShareDate;
    @SerializedName("origin")
    private String origin;
    @SerializedName("prefix")
    private String prefix;
    @SerializedName("projectLink")
    private String projectLink;
    @SerializedName("publishTime")
    private Long publishTime;
    @SerializedName("realSuperChapterId")
    private Integer realSuperChapterId;
    @SerializedName("route")
    private Boolean route;
    @SerializedName("selfVisible")
    private Integer selfVisible;
    @SerializedName("shareDate")
    private Long shareDate;
    @SerializedName("shareUser")
    private String shareUser;
    @SerializedName("superChapterId")
    private Integer superChapterId;
    @SerializedName("superChapterName")
    private String superChapterName;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private Integer type;
    @SerializedName("userId")
    private Integer userId;
    @SerializedName("visible")
    private Integer visible;
    @SerializedName("zan")
    private Integer zan;
    @SerializedName("tags")
    private List<TagsDTO> tags;

    public Boolean isAdminAdd() {
        return adminAdd;
    }

    public void setAdminAdd(Boolean adminAdd) {
        this.adminAdd = adminAdd;
    }

    public String getApkLink() {
        return apkLink;
    }

    public void setApkLink(String apkLink) {
        this.apkLink = apkLink;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Boolean isCollect() {
        return collect;
    }

    public void setCollect(Boolean collect) {
        this.collect = collect;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescMd() {
        return descMd;
    }

    public void setDescMd(String descMd) {
        this.descMd = descMd;
    }

    public String getEnvelopePic() {
        return envelopePic;
    }

    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }

    public Boolean isFresh() {
        return fresh;
    }

    public void setFresh(Boolean fresh) {
        this.fresh = fresh;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isIsAdminAdd() {
        return isAdminAdd;
    }

    public void setIsAdminAdd(Boolean isAdminAdd) {
        this.isAdminAdd = isAdminAdd;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    public String getNiceShareDate() {
        return niceShareDate;
    }

    public void setNiceShareDate(String niceShareDate) {
        this.niceShareDate = niceShareDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getRealSuperChapterId() {
        return realSuperChapterId;
    }

    public void setRealSuperChapterId(Integer realSuperChapterId) {
        this.realSuperChapterId = realSuperChapterId;
    }

    public Boolean isRoute() {
        return route;
    }

    public void setRoute(Boolean route) {
        this.route = route;
    }

    public Integer getSelfVisible() {
        return selfVisible;
    }

    public void setSelfVisible(Integer selfVisible) {
        this.selfVisible = selfVisible;
    }

    public Long getShareDate() {
        return shareDate;
    }

    public void setShareDate(Long shareDate) {
        this.shareDate = shareDate;
    }

    public String getShareUser() {
        return shareUser;
    }

    public void setShareUser(String shareUser) {
        this.shareUser = shareUser;
    }

    public Integer getSuperChapterId() {
        return superChapterId;
    }

    public void setSuperChapterId(Integer superChapterId) {
        this.superChapterId = superChapterId;
    }

    public String getSuperChapterName() {
        return superChapterName;
    }

    public void setSuperChapterName(String superChapterName) {
        this.superChapterName = superChapterName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public List<TagsDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagsDTO> tags) {
        this.tags = tags;
    }

    public static class TagsDTO {
        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
