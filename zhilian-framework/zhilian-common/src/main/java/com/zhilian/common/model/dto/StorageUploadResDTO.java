package com.zhilian.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件上传响应值
 *
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageUploadResDTO {
    /**
     * 文件地址
     */
    private String url;
}