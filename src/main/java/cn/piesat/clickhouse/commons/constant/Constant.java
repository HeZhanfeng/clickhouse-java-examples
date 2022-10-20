package cn.piesat.clickhouse.commons.constant;

/**
 * 常量接口
 *
 * <p>
 * Description:
 * </p>
 *
 * @author hezhanfeng
 * @version v1.0
 * @date 2020/10/28 20:43
 */
public interface Constant {

    /**
     * zip
     */
    String ZIP = "zip";

    /**
     * rar
     */
    String RAR = "rar";

    /**
     * 创建日期
     */
    String CREATE_TIME = "createTime";
    /**
     * 注册日期
     */
    String UPDATE_TIME = "updateTime";

    /**
     * 初识密码
     */
    String INITIAL_PASSWORD = "123456";

    /**
     * 验证码math类型
     */
    String CAPTCHA_MATH_TYPE = "math";

    /**
     * 验证码char类型
     */
    String CAPTCHA_CHAR_TYPE = "char";

    /**
     * 验证码 redis key
     */
    String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * 短信验证码 redis key
     */
    String MSG_CODE_KEY = "msg_codes:";

    /**
     * 系统管理员
     */
    String ADMIN = "admin";

    /**
     * OPTIONS请求方式
     */
    String OPTIONS = "OPTIONS";

    /**
     * 登录成功
     */
    Integer LOGIN_SUCCESS = 1;

    /**
     * 登录成功消息
     */
    String LOGIN_SUCCESS_MSG = "登录成功";

    /**
     * 注销成功消息
     */
    String LOGOUT_SUCCESS_MSG = "退出成功";

    /**
     * 注销
     */
    String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    Integer LOGIN_FAIL = 0;

    /**
     * 防重提交 redis key
     */
    String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 可用
     */
    String AVAILABLE = "Y";

    /**
     * 不可用
     */
    String UNAVAILABLE = "N";

    /**
     * 已删除
     */
    Integer DELETED = 0;

    /**
     * 未删除
     */
    Integer NOT_DELETED = 1;

    /**
     * 主星
     */
    Integer MASTER_SATELLITE = 1;
    /**
     * 从星
     */
    Integer SLAVE_SATELLITE = 2;
    /**
     * 其他从星
     */
    Integer OTHER_SLAVE_SATELLITE = 3;

    /**
     * 是
     */
    String YES = "Y";
    /**
     * 否
     */
    String NO = "N";
}
