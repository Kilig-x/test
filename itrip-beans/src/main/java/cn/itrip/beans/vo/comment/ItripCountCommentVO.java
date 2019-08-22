package cn.itrip.beans.vo.comment;

import io.swagger.annotations.ApiModel;

/**
 * 页面输入-新增评论VO
 * Created by hanlu on 2017/5/7.
 */
@ApiModel(value = "ItripCountCommentVO", description = "用户评论")
public class ItripCountCommentVO {
    private Integer allcomment;//评论总数
    private Integer isok;//值得推荐
    private Integer improve;//有待改善
    private Integer havingimg;//是否含有图片

    public Integer getIsok() {
        return isok;
    }

    public void setIsok(Integer isok) {
        this.isok = isok;
    }

    public Integer getImprove() {
        return improve;
    }

    public void setImprove(Integer improve) {
        this.improve = improve;
    }

    public Integer getHavingimg() {
        return havingimg;
    }

    public void setHavingimg(Integer havingimg) {
        this.havingimg = havingimg;
    }

    public Integer getAllcomment() {
        return allcomment;
    }

    public void setAllcomment(Integer allcomment) {
        this.allcomment = allcomment;
    }
}
