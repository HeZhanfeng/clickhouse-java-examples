package cn.piesat.clickhouse.commons.response;

/**
 * API 统一返回状态码
 *
 * <p>
 * Description:
 * </p>
 *
 * @author hezhanfeng
 * @version v1.0
 * @date 2020/6/20 21:59
 */
public enum ResponseCode {

    /**
     * 未知错误
     */
    UNKNOWN(-1, "未知错误"),

    /**
     * 请求成功
     */
    SUCCESS(20000, "成功"),
    /**
     * 请求失败
     */
    FAILURE(20002, "失败"),

    /**
     * 验证码失效
     */
    CAPTCHA_EXPIRED(20003,"验证码失效"),

    /**
     * 验证码错误
     */
    CAPTCHA_ERROR(20004,"验证码错误"),

    // ------------------------------------------------------- 参数错误：10001-19999 Start

    /**
     * 参数无效
     */
    PARAM_IS_INVALID(10001, "参数无效"),
    /**
     * 参数为空
     */
    PARAM_IS_BLANK(10002, "参数为空"),
    /**
     * 参数类型错误
     */
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    /**
     * 参数缺失
     */
    PARAM_NOT_COMPLETE(10004, "参数缺失"),

    // ------------------------------------------------------- 参数错误：10001-19999 End

    // ------------------------------------------------------- 用户错误：20001-29999 Start

    // ------------------------------------------------------- 用户错误：20001-29999 End

    // ------------------------------------------------------- 业务错误：30001-39999 Start

    // ------------------------------------------------------- 业务错误：30001-39999 End

    // ------------------------------------------------------- 系统错误：40001-49999 Start

    // ------------------------------------------------------- 系统错误：40001-49999 End

    // ------------------------------------------------------- 数据错误：50001-599999 Start

    /**
     * 数据未找到
     */
    RESULT_DATA_NONE(50001, "数据未找到"),

    /**
     * 上传失败
     */
    UPLOAD_FAILURE(50004, "上传失败"),

    /**
     * 删除失败
     */
    DELETE_FAILURE(50005, "删除失败"),

    // ------------------------------------------------------- 数据错误：50001-599999 End

    // ------------------------------------------------------- 接口错误：60001-69999 Start

    /**
     * 内部系统接口调用异常
     */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    /**
     * 外部系统接口调用异常
     */
    INTERFACE_OUTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    /**
     * 该接口禁止访问
     */
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    /**
     * 接口地址无效
     */
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    /**
     * 接口请求超时
     */
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    /**
     * 接口负载过高
     */
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /**
     * 不允许重复提交，请稍后再试
     */
    CANNOT_REPEAT_SUBMIT(60007, "不允许重复提交，请稍后再试"),

    /**
     * 获取数据库连接异常
     */
    GET_DATABASE_CONNECTION_EXCEPTION(70001, "获取数据库连接异常"),

    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    FILE_IS_Empty(403, "文件内容不能为空！"),
    TRACK_CHANGE_HAS_EXISTED(403, "变轨事件已存在！"),
    TRACK_TIME_IS_EMPTY(403, "变轨时间不能为空！"),
    SCENE_NAME_HAS_EXISTED(403, "场景名称已存在！"),
    NO_DATA_FOUND(403, "没找到数据！"),
    SATELITE_HAS_EXISTED(403, "卫星已存在！"),
    STATION_HAS_EXISTED(403, "测站已存在！"),
    ORBIT_CHANGE_HAS_EXISTED(403, "变轨事件已经存在！"),
    SATELLITE_INFO_HAS_EXISTED(403, "卫星编号已经存在！"),
    NEAR_EVENT_HAS_EXISTED(403, "接近事件已经存在！"),
    SATELLITE_TLE_HAS_EXISTED(403, "TLE已经存在！"),
    STATION_INFO_HAS_EXISTED(403, "测站编号已经存在！"),
    ONLY_PARSE_ZIP_OR_RAR_ARCHIVES(403, "只能解析zip或rar压缩包！"),
    ONLY_PARSE_ZIP_ARCHIVES(403, "只能解析zip压缩包！"),
    FILE_UPLOAD_FAILED(403, "文件上传失败！"),
    SUB_SCENE_NOT_EXIST(403, "子场景不存在！"),
    SCENE_NOT_EXIST(403, "场景不存在！"),
    PATROL_AREA_HAS_EXISTED(403, "巡视区域已经存在！"),
    SUBSCENE_NOT_SATELLITE(403, "子场景没有配置卫星！"),
    SUBSCENE_ONE_SATELLITE(403, "子场景只有一种卫星！"),
    SATELLITE_NAME_HAS_EXISTED(403, "卫星名称已经存在！"),
    SATELLITE_CODE_OR_NAME_HAS_EXISTED(403, "卫星名称或编号已经存在！"),
    CREATE_SCENE_FAILED(403, "创建场景失败！"),;

    // ------------------------------------------------------- 接口错误：60001-69999 End

    private Integer code;

    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResponseCode item : ResponseCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
