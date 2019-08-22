package cn.itrip.controller.comment;

import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.pojo.ItripHotelTradingArea;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.beans.vo.ItripAreaDicVO;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.comment.*;
import cn.itrip.beans.vo.hotel.HotelVideoDescVO;
import cn.itrip.beans.vo.hotel.ItripSearchFacilitiesHotelVO;
import cn.itrip.beans.vo.hotel.ItripSearchPolicyHotelVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.Page;
import cn.itrip.service.find.ItripFindService;
import cn.itrip.service.hotelcomment.ItripCommentService;
import cn.itrip.service.hotelcomment.ItripCommentServiceImpl;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 用户信息Controller
 * <p>
 * 包括API接口：
 * 1、根据UserId、联系人姓名查询常用联系人接口
 * 2、指定用户下添加联系人
 * 3、修改指定用户下的联系人信息
 * 4、删除指定用户下的联系人信息
 * <p>
 * 注：错误码（100401 ——100500）
 * <p>
 * Created by hanlu on 2017/5/9.
 */

@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/comment", produces = "application/json; charset=utf-8")
public class HotelComment {
    private Logger logger = Logger.getLogger(HotelComment.class);

    @Resource
    private ItripCommentService itripCommentService;

    /**
     * 查询酒店评分
     *
     * @param cityId
     * @return
     */
    //以该地址作为父路径
    @RequestMapping(value = "/gethotelscore/{cityId}", method = RequestMethod.GET)
    //将方法的返回值以特定的格式写入到response的body区域
    @ResponseBody
    public Dto getHotelScore(@PathVariable("cityId") Integer cityId) {
        logger.info("gethotelscore>>>>>>>>>>>>>");
        ItripScoreCommentVO list = null;
        try {
            list = itripCommentService.findHotelScore(cityId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (list == null) {
            return DtoUtil.returnFail("查询酒店评分失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店评分", list);
    }

    /**
     * 查询酒店评论数量
     *
     * @param cityId
     * @return
     */
    @RequestMapping(value = "/getcount/{cityId}", method = RequestMethod.GET)
    @ResponseBody
    public Dto getHotelCount(@PathVariable("cityId") Integer cityId) {
        logger.info("getcount>>>>>>>>>>>>>");
        ItripCountCommentVO list = null;
        try {
            list = itripCommentService.findHotelCount(cityId);

        } catch (
                Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询酒店评论数量失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店评论数量", list);
    }

    /**
     * 查询评论内容列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getcommentlist", method = RequestMethod.POST)
    @ResponseBody
    public Dto<Page<ItripComment>> getCommentList(@RequestBody ItripSearchCommentVO vo) {
        logger.info("getcommentlist>>>>>>>>>>>>>");
        List<ItripComment> list = itripCommentService.findCommentList(vo);
        int total = itripCommentService.findCommentPageCount(vo);
        Page<ItripComment> page = new Page<ItripComment>(vo.getPageNo(), vo.getPageSize(), total);
        page.setRows(list);
        if (list == null) {
            return DtoUtil.returnFail("查询评论内容列表失败", "100401");
        }
        return DtoUtil.returnSuccess("查询评论内容列表", page);
    }


    /**
     * 查询酒店图片
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getimg/{commentId}", method = RequestMethod.POST)
    @ResponseBody
    public Dto<Page<ItripComment>> getCommentImg(@PathVariable("commentId") Integer integer) {
        logger.info("getimg>>>>>>>>>>>>>");
        List<ItripImageVO> list = null;
        try {
            list = itripCommentService.findCommentImg(integer);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询酒店图片失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店图片", list);
    }

    /**
     * 查询酒店详情（评论）
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/gethoteldesc/{hotelId}", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripHotelDescVO> getHotelDesc(@PathVariable("hotelId") Integer integer) {
        logger.info("gethoteldesc>>>>>>>>>>>>>");
        ItripHotelDescVO list = null;
        try {
            list = itripCommentService.findHotelDesc(integer);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询酒店详情失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店详情", list);
    }

    /**
     * 查询旅游类型列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/gettraveltype", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripLabelDicVO> getTravelType() {
        logger.info("gettraveltype>>>>>>>>>>>>>");
        List<ItripLabelDicVO> list = null;
        try {
            list = itripCommentService.findTravelType();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        if (list == null) {
            return DtoUtil.returnFail("查询旅游类型列表失败", "100401");
        }
        return DtoUtil.returnSuccess("查询旅游类型列表", list);
    }

    /**
     * 新增评论
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Dto<ItripAddCommentVO> getCommentAdd(@RequestBody ItripAddCommentVO vo) {
        logger.info("getCommentAdd>>>>>>>>>>>>>");
        int count = 0;
        try {
            count = itripCommentService.getAddComment(vo);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
        if (count == 0) {
            return DtoUtil.returnFail("新增评论失败", "100401");
        }
        return DtoUtil.returnSuccess("新增评论");
    }
}
