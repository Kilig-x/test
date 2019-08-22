package cn.itrip.dao.hotelcomment;

import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.comment.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItripHotelCommentMapper {
    public ItripScoreCommentVO getHotelScore(@Param("cityId") Integer cityId) throws Exception;

    public ItripCountCommentVO getCount(@Param("cityId") Integer cityId) throws Exception;

    public List<ItripComment> getCommentList(ItripSearchCommentVO vo);

    public int getPageCount(ItripSearchCommentVO vo);

    public List<ItripImageVO> getCommentImg(Integer integer) throws Exception;

    public ItripHotelDescVO getItripHotelDesc(Integer integer) throws Exception;

    public List<ItripLabelDicVO> getItripTravelType() throws Exception;

    public int getItripCommentAdd(ItripAddCommentVO vo) throws Exception;
}
