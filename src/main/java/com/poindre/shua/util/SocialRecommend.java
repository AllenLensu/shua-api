package com.poindre.shua.util;

import java.math.BigDecimal;
import java.util.Date;


// POJO

public class SocialRecommend {

    private Date time;
    private long collectNum;
    private long likeNum;
    private long commentNum;
    private long content_id;
    private double hot;

    public SocialRecommend(long content_id) {
        setContent_id(content_id);
    }

    /**
     * 45000 代表的是一个 12.5 小时周期内的总秒数。
     * log10 可以使得早期的投票获得更大的权重。
     */
    public void srRank() {
        double popularity = weighted(getCollectNum(), getLikeNum(), getCommentNum());
        double freshness = freshness(getTime()) / 45000000.0;
        if (Math.abs(popularity - 0.0) < 0.01) {
            setHot(freshness);
        } else {
            BigDecimal a = new BigDecimal(Double.toString(freshness));
            BigDecimal b = new BigDecimal(Double.toString(Math.log(popularity)));
            double tmp = a.add(b).doubleValue();
            setHot(tmp);
        }
    }

    /**
     * @param sendTime 帖子发送时间
     * @return 新鲜度
     */
    private long freshness(Date sendTime) {
        long baseTime = 1641916800;
        return sendTime.getTime() - baseTime;
    }

    /**
     * @param collectNum 收藏数
     * @param likeNum    点赞数
     * @param commentNum 评论数
     * @return 加权后的推荐指数
     */
    private double weighted(long collectNum, long likeNum, long commentNum) {
        return likeNum * 8 + collectNum * 24 + commentNum * 36;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public long getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(long collectNum) {
        this.collectNum = collectNum;
    }

    public long getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(long likeNum) {
        this.likeNum = likeNum;
    }

    public long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(long commentNum) {
        this.commentNum = commentNum;
    }

    public long getContent_id() {
        return content_id;
    }

    public void setContent_id(long content_id) {
        this.content_id = content_id;
    }

    public double getHot() {
        return hot;
    }

    public void setHot(double hot) {
        this.hot = hot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SocialRecommend that = (SocialRecommend) o;

        if (collectNum != that.collectNum) return false;
        if (likeNum != that.likeNum) return false;
        if (commentNum != that.commentNum) return false;
        if (content_id != that.content_id) return false;
        if (Double.compare(that.hot, hot) != 0) return false;
        return time.equals(that.time);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = time.hashCode();
        result = 31 * result + (int) (collectNum ^ (collectNum >>> 32));
        result = 31 * result + (int) (likeNum ^ (likeNum >>> 32));
        result = 31 * result + (int) (commentNum ^ (commentNum >>> 32));
        result = 31 * result + (int) (content_id ^ (content_id >>> 32));
        temp = Double.doubleToLongBits(hot);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SocialRecommend{" +
                "time=" + time +
                ", collectNum=" + collectNum +
                ", likeNum=" + likeNum +
                ", commentNum=" + commentNum +
                ", content_id=" + content_id +
                ", hot=" + hot +
                '}';
    }
}
