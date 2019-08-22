package cn.itrip.service.hotelcomment;

import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.comment.*;
import cn.itrip.dao.hotelcomment.ItripHotelCommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripCommentServiceImpl implements ItripCommentService {
    @Resource
    private ItripHotelCommentMapper itripHotelCommentMapper;

    public ItripScoreCommentVO findHotelScore(Integer cityId) throws Exception {
        return itripHotelCommentMapper.getHotelScore(cityId);
    }

    public ItripCountCommentVO findHotelCount(Integer cityId) throws Exception {
        return itripHotelCommentMapper.getCount(cityId);
    }

    @Override
    public List<ItripComment> findCommentList(ItripSearchCommentVO vo) {
        vo.setPageNo((vo.getPageNo() - 1) * vo.getPageSize() + 1);
        return itripHotelCommentMapper.getCommentList(vo);
    }

    @Override
    public int findCommentPageCount(ItripSearchCommentVO vo) {
        return itripHotelCommentMapper.getPageCount(vo);
    }

    @Override
    public List<ItripImageVO> findCommentImg(Integer integer) throws Exception {
        return itripHotelCommentMapper.getCommentImg(integer);
    }

    @Override
    public ItripHotelDescVO findHotelDesc(Integer integer) throws Exception {
        return itripHotelCommentMapper.getItripHotelDesc(integer);
    }

    @Override
    public List<ItripLabelDicVO> findTravelType() throws Exception {
        return itripHotelCommentMapper.getItripTravelType();
    }

    @Override
    public int getAddComment(ItripAddCommentVO vo) throws Exception {
        return itripHotelCommentMapper.getItripCommentAdd(vo);
    }


}
