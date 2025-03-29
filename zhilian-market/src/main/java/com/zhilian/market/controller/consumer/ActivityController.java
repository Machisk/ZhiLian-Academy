package com.zhilian.market.controller.consumer;

import com.zhilian.common.model.PageResult;
import com.zhilian.market.model.dto.request.ActivityQueryForPageReqDTO;
import com.zhilian.market.model.dto.request.ActivitySaveReqDTO;
import com.zhilian.market.model.dto.response.ActivityInfoResDTO;
import com.zhilian.market.model.dto.response.SeizeCouponInfoResDTO;
import com.zhilian.market.service.IActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("consumerActivityController")
@RequestMapping("/consumer/activity")
@Api(tags = "用户端-活动相关接口")
public class ActivityController {

    @Resource
    private IActivityService activityService;



}
