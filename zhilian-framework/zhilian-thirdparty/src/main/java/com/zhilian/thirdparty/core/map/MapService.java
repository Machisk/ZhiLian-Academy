package com.zhilian.thirdparty.core.map;

import com.zhilian.thirdparty.dto.MapLocationDTO;

public interface MapService {
    /**
     * 根据地址获取经纬度坐标
     *
     * @param address 地址
     * @return 经纬度坐标
     */
    String getLocationByAddress(String address);

    /**
     * 根据经纬度获取城市编码
     *
     * @param location 经纬度，经度在前，纬度在后
     * @return 城市编码
     */
    MapLocationDTO getCityCodeByLocation(String location);
}
