package cn.itrip.controller.hotel;

import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripHotelTradingArea;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.beans.vo.ItripAreaDicVO;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.hotel.HotelVideoDescVO;
import cn.itrip.beans.vo.hotel.ItripSearchFacilitiesHotelVO;
import cn.itrip.beans.vo.hotel.ItripSearchPolicyHotelVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.service.find.ItripFindService;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@RequestMapping(value = "/api/hotel", produces = "application/json; charset=utf-8")
public class HotelController {
    private Logger logger = Logger.getLogger(HotelController.class);

    @Resource
    private ItripFindService findService;

    /**
     * 查询热门城市
     *
     * @param cityId
     * @return
     */
    //以该地址作为父路径
    @RequestMapping(value = "/queryhotcity/{cityId}", method = RequestMethod.GET)
    //将方法的返回值以特定的格式写入到response的body区域
    @ResponseBody
    public Dto getQueryHotcity(@PathVariable("cityId") Integer cityId) {
        logger.info("getQueryHotelById>>>>>>>>>>>>>");
        List<ItripAreaDicVO> list = null;
        try {
            list = findService.itripQueryHotcity(cityId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询热门城市失败", "100401");
        }
        return DtoUtil.returnSuccess("查询热门城市", list);
    }

    /**
     * 查询所有酒店特色
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/queryhotelfeature", method = RequestMethod.GET)
    @ResponseBody
    public Dto getQueryHotelFeatures() {
        logger.info("getQueryHotelFeatures>>>>>>>>>>>>>");
        List<ItripLabelDicVO> list = null;
        try {
            list = findService.itripQueryHotelFeatures();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询所有酒店特色失败", "100401");
        }
        return DtoUtil.returnSuccess("查询所有酒店特色", list);
    }

    /**
     * 查询城市商圈
     *
     * @param cityId
     * @return
     */
    @RequestMapping(value = "/querytradearea/{cityId}", method = RequestMethod.GET)
    @ResponseBody
    public Dto getQueryTradearea(@PathVariable("cityId") Integer cityId) {
        logger.info("getQueryTradearea>>>>>>>>>>>>>");
        List<ItripHotelTradingArea> list = null;
        try {
            list = findService.itripQueryTradearea(cityId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询城市商圈失败", "100401");
        }
        return DtoUtil.returnSuccess("查询城市商圈", list);
    }

    /**
     * 查询酒店视频信息
     *
     * @param cityId
     * @return
     */
    @RequestMapping(value = "/getvideodesc/{cityId}", method = RequestMethod.GET)
    @ResponseBody
    public Dto<HotelVideoDescVO> getVideoDesc(@PathVariable("cityId") Integer cityId) {
        HotelVideoDescVO hotelVideoDescVO = new HotelVideoDescVO();
        try {
            hotelVideoDescVO.setHotelName(findService.getItripHotelName(cityId));
            hotelVideoDescVO.setTradingAreaNameList(findService.getItripTradingAreaNameList(cityId));
            hotelVideoDescVO.setHotelFeatureList(findService.getItripHotelFeatureList(cityId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (hotelVideoDescVO == null) {
            return DtoUtil.returnFail("查询酒店视频信息失败", "100401");
        } else {
            return DtoUtil.returnSuccess("查询酒店视频信息", hotelVideoDescVO);
        }
    }


    /**
     * 查询酒店描述和特色
     *
     * @param cityId
     * @return
     */
    @RequestMapping(value = "/queryhoteldetails/{cityId}", method = RequestMethod.GET)
    @ResponseBody
    public Dto getQueryHotelDetails(@PathVariable("cityId") Integer cityId) {
        logger.info("getQueryHotelDetails>>>>>>>>>>>>>");
        List<ItripLabelDic> list = null;
        try {
            list = findService.itripQueryHotelDetails(cityId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询酒店描述和特色失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店描述和特色", list);
    }

    /**
     * 查询酒店设施
     *
     * @param cityId
     * @return
     */
    @RequestMapping(value = "/queryhotelfacilities/{cityId}", method = RequestMethod.GET)
    @ResponseBody
    public Dto<ItripSearchFacilitiesHotelVO> getQueryHotelFacilities(@PathVariable("cityId") Integer cityId) {
        logger.info("getQueryHotelFacilities>>>>>>>>>>>>>");
        List<ItripSearchFacilitiesHotelVO> list = null;
        try {
            list = findService.itripQueryHotelFacilities(cityId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询酒店设施失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店设施", list);
    }

    /**
     * 查询酒店设施
     *
     * @param cityId
     * @return
     */
    @RequestMapping(value = "/queryhotelpolicy/{cityId}", method = RequestMethod.GET)
    @ResponseBody
    public Dto<ItripSearchPolicyHotelVO> getQueryHotelPolicy(@PathVariable("cityId") Integer cityId) {
        logger.info("getQueryHotelPolicy>>>>>>>>>>>>>");
        List<ItripSearchPolicyHotelVO> list = null;
        try {
            list = findService.itripQueryHotelPolicy(cityId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询酒店设施失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店设施", list);
    }


    /**
     * 查询酒店设施
     *
     * @param roomId
     * @return
     */
    @RequestMapping(value = "/getimg/{roomId}", method = RequestMethod.GET)
    @ResponseBody
    public Dto<ItripImageVO> getHotelImg(@PathVariable("roomId") Integer roomId) {
        logger.info("getHotelImg>>>>>>>>>>>>>");
        List<ItripImageVO> list = null;
        try {
            list = findService.itripQueryHotelImg(roomId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询酒店设施失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店设施", list);
    }

}
