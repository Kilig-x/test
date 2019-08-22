package cn.itrip.controller.hotelroom;

import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.hotelroom.ItripHotelRoomVO;
import cn.itrip.beans.vo.hotelroom.SearchHotelRoomVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.service.hotelroom.ItripRoomService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.util.*;

@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/hotelroom", produces = "application/json; charset=utf-8")
public class HotelRoom {
    private Logger logger = Logger.getLogger(HotelRoom.class);

    @Resource
    private ItripRoomService itripRoomService;

    /**
     * 查询酒店房型图片
     *
     * @param roomId
     * @return
     */
    //以该地址作为父路径
    @RequestMapping(value = "/getimg/{roomId}", method = RequestMethod.GET)
    //将方法的返回值以特定的格式写入到response的body区域
    @ResponseBody
    public Dto<ItripImageVO> getHotelImg(@PathVariable("roomId") Integer roomId) {
        logger.info("getHotelImg>>>>>>>>>>>>>");
        List<ItripImageVO> list = null;
        try {
            list = itripRoomService.findItripHotelImg(roomId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询酒店房型图片失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店房型图片", list);
    }

    /**
     * 查询酒店房型列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/queryhotelroombyhotel", method = RequestMethod.POST)
    @ResponseBody
    public Dto<List<List<ItripHotelRoomVO>>> getQueryHotelRoomByHotel(@RequestBody SearchHotelRoomVO searchHotelRoomVO) {
        logger.info("queryhotelroombyhotel>>>>>>>>>>>>>");
        List<List<ItripHotelRoomVO>> lists = null;
        try {
            lists = new ArrayList<List<ItripHotelRoomVO>>();
        } catch (Exception e) {
            for (ItripHotelRoomVO itripHotelRoomVOSs : itripRoomService.findItripHotelRoomBy(searchHotelRoomVO)) {
                List<ItripHotelRoomVO> list = new ArrayList<ItripHotelRoomVO>();
                list.add(itripHotelRoomVOSs);
                lists.add(list);
            }
        }
        if (lists == null) {
            return DtoUtil.returnFail("查询酒店房型列表失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店房型列表", lists);
    }

    /**
     * 查询酒店床型
     *
     * @return
     */
    @RequestMapping(value = "/queryhotelroombed", method = RequestMethod.GET)
    @ResponseBody
    public Dto<ItripLabelDicVO> getQueryHotelLabelDicVO() {
        logger.info("queryhotelroombed>>>>>>>>>>>>>");
        List<ItripLabelDicVO> list = null;
        try {
            list = itripRoomService.findHotelLabelDicVO();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询酒店床型列表失败", "100401");
        }
        return DtoUtil.returnSuccess("查询酒店床型列表", list);
    }
}
