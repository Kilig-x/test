package cn.itrip.controller;

import cn.itrip.ItripHotelVO;
import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.vo.hotel.SearchHotCityVO;
import cn.itrip.beans.vo.hotel.SearchHotelVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ErrorCode;
import cn.itrip.common.Page;
import cn.itrip.service.ItripHotelListService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 酒店
 *
 * @author MXY
 * @date 2019/8/1 - 15:22
 */

@Controller
@RequestMapping(value = "/api/hotellist")
public class HotelListController {

    private Logger logger = Logger.getLogger(HotelListController.class);

    @Resource
    private ItripHotelListService itripHotelListService;

    /**
     * 根据热门城市查询6个酒店
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/searchItripHotelListByHotCity", method = RequestMethod.POST)
    @ResponseBody
    public Dto<List<ItripHotelVO>> searchItripHotelListByHotCity(@RequestBody SearchHotCityVO vo) {
        List list;
        try {
            list = itripHotelListService.getItripHotelList(vo.getCityId().toString(), vo.getCount());
            return DtoUtil.returnSuccess("获取城市6个酒店信息成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("系统异常", ErrorCode.AUTH_UNKNOWN);
        }
    }

    /**
     * 搜索酒店（分页）
     *
     * @param vo
     * @return
     */
    @RequestMapping(value = "/searchItripHotelPage", method = RequestMethod.POST)
    @ResponseBody
    public Dto<Page<ItripHotelVO>> searchItripHotelPage(@RequestBody SearchHotelVO vo) {
        try {
            Page<ItripHotelVO> page = itripHotelListService.getItripHotelPage(vo);
            return DtoUtil.returnSuccess("酒店搜索成功", page);
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("系统异常", ErrorCode.AUTH_UNKNOWN);
        }
    }
}

