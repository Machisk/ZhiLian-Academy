package com.zhilian.customer.controller.operation;

import com.zhilian.api.customer.dto.request.EvaluationSubmitReqDTO;
import com.zhilian.common.model.CurrentUserInfo;
import com.zhilian.customer.model.dto.request.AuditReqDTO;
import com.zhilian.customer.model.dto.request.EvaluationPageByTargetReqDTO;
import com.zhilian.customer.model.dto.request.LikeOrCancelReqDTO;
import com.zhilian.customer.model.dto.response.EvaluationAndOrdersResDTO;
import com.zhilian.customer.model.dto.response.EvaluationResDTO;
import com.zhilian.customer.model.dto.response.EvaluationTokenDto;
import com.zhilian.customer.service.EvaluationService;
import com.zhilian.mvc.utils.UserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评价相关接口
 *
 **/
@RestController("operationEvaluationController")
@RequestMapping("/operation/evaluation")
@Api(tags = "运营端 - 评价相关接口")
public class EvaluationController {
    @Resource
    private EvaluationService evaluationService;


    @GetMapping("/token")
    @ApiOperation("获取评价系统token")
    public EvaluationTokenDto getToken() {
        return evaluationService.getEvaluationInfo();
    }
}
