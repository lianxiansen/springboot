package com.kamfu.model;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;

public class BaseResponse extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";

    /**
     * 状态类型
     */
    public enum Type
    {
        /** 成功 */
        SUCCESS(0),
        /** 正常 */
        /**失败*/
        FAIL(1),
        /** 警告 */
        WARN(301),
        /** 错误 */
        ERROR(500);
        protected final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    /** 状态类型 */
    protected Type type;

    /** 状态码 */
    protected int code;

    /** 返回内容 */
    protected String msg;

    /** 数据对象 */
    protected Object data;

    /**
     * 初始化一个新创建的 AjaxResponse 对象，使其表示一个空消息。
     */
    public BaseResponse()
    {
    }

    /**
     * 初始化一个新创建的 AjaxResponse 对象
     * 
     * @param type 状态类型
     * @param msg 返回内容
     */
    public BaseResponse(Type type, String msg)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResponse 对象
     * 
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public BaseResponse(Type type, String msg, Object data)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }
    
    public BaseResponse(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }

    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static BaseResponse success()
    {
        return BaseResponse.success("操作成功");
    }

    /**
     * 返回成功消息
     * 
     * @param msg 返回内容
     * @return 成功消息
     */
    public static BaseResponse success(String msg)
    {
        return BaseResponse.success(msg, null);
    }

    /**
     * 返回成功消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static BaseResponse success(String msg, Object data)
    {
        return new BaseResponse(Type.SUCCESS, msg, data);
    }
    
    public static BaseResponse success(int code ,String msg, Object data)
    {
        return new BaseResponse(code, msg, data);
    }


    /**
     * 返回失败消息
     *
     * @return 成功消息
     */
    public static BaseResponse fail()
    {
        return BaseResponse.fail("操作失败");
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static BaseResponse fail(String msg)
    {
        return BaseResponse.fail(msg, null);
    }
    
    public String toJSONString() {
    	return JSON.toJSONString(this);
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static BaseResponse fail(String msg, Object data)
    {
        return new BaseResponse(Type.FAIL, msg, data);
    }

    /**
     * 返回警告消息
     * 
     * @param msg 返回内容
     * @return 警告消息
     */
    public static BaseResponse warn(String msg)
    {
        return BaseResponse.warn(msg, null);
    }

    /**
     * 返回警告消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static BaseResponse warn(String msg, Object data)
    {
        return new BaseResponse(Type.WARN, msg, data);
    }

    /**
     * 返回错误消息
     * 
     * @return
     */
    public static BaseResponse error()
    {
        return BaseResponse.error("操作失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回内容
     * @return 警告消息
     */
    public static BaseResponse error(String msg)
    {
        return BaseResponse.error(msg, null);
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static BaseResponse error(String msg, Object data)
    {
        return new BaseResponse(Type.ERROR, msg, data);
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }


}
