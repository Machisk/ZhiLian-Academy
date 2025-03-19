package com.zhilian.foundations.constants;

/**
 * redis相关常量
 *
 **/
public class RedisConstants {

    public static final class CacheName {
        /**
         * 服务缓存
         */
        public static final String ZL_CACHE = "ZL_CACHE";

        /**
         * 用户端首页服务图标
         */
        public static final String SERVE_ICON = "ZL_CACHE:SERVE_ICON";

        /**
         * 用户端首页热门服务
         */
        public static final String HOT_SERVE = "ZL_CACHE:HOT_SERVE";

        /**
         * 用户端已开通服务分类
         */
        public static final String SERVE_TYPE = "ZL_CACHE:SERVE_TYPE";

        /**
         * 服务项
         */
        public static final String SERVE_ITEM = "ZL_CACHE:SERVE_ITEM";

        /**
         * 服务
         */
        public static final String SERVE = "ZL_CACHE:SERVE_RECORD";
    }

    public static final class CacheManager {
        /**
         * 缓存时间永久
         */
        public static final String FOREVER = "cacheManagerForever";

        /**
         * 缓存时间永久
         */
        public static final String THIRTY_MINUTES = "cacheManager30Minutes";

        /**
         * 缓存时间1天
         */
        public static final String ONE_DAY = "cacheManagerOneDay";
    }

    public static final class Ttl {
        /**
         * 缓存时间30分钟
         */
        public static final int THIRTY = 30;
    }

}
