package cn.itrip.service.hotelcomment;

import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.comment.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItripCommentService {

    //查询酒店评分
    public ItripScoreCommentVO findHotelScore(Integer cityId) throws Exception;

    //查询评论数量
    public ItripCountCommentVO findHotelCount(Integer cityId) throws Exception;

    //查询评论内容列表
    public List<ItripComment> findCommentList(ItripSearchCommentVO vo);

    public int findCommentPageCount(ItripSearchCommentVO vo);

    public List<ItripImageVO> findCommentImg(Integer integer) throws Exception;

    public ItripHotelDescVO findHotelDesc(Integer integer) throws Exception;

    public List<ItripLabelDicVO> findTravelType() throws Exception;

    public int getAddComment(ItripAddCommentVO vo) throws Exception;
}
