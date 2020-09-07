package com.kamfu.model;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;

public class PagedResponse extends BaseResponse
{
	private static final long serialVersionUID = -3652191725242645164L;


	public static final String COUNT_TAG = "count";


    /** 状态类型 */
    protected Type type;

    /** 状态码 */
    protected int code;

    /** 返回内容 */
    protected String msg;

    /** 数据对象 */
    protected Object data;
    
    /** 数量 */
    private int count;

    /**
     * 初始化一个新创建的 AjaxResponse 对象，使其表示一个空消息。
     */
    public PagedResponse()
    {
    }

    /**
     * 初始化一个新创建的 AjaxResponse 对象
     * 
     * @param type 状态类型
     * @param msg 返回内容
     */
    public PagedResponse(Type type, String msg,int count)
    {
        super.put(BaseResponse.CODE_TAG, type.value);
        super.put(BaseResponse.MSG_TAG, msg);
        super.put(COUNT_TAG, count);
    }

    /**
     * 初始化一个新创建的 AjaxResponse 对象
     * 
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public PagedResponse(Type type, String msg, Object data)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }
    
    public PagedResponse(Type type, String msg, Object data,int count)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
        super.put(COUNT_TAG, count);
    }

    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static BaseResponse success()
    {
        return PagedResponse.success("操作成功");
    }

    /**
     * 返回成功消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static PagedResponse success(String msg, Object data,int count)
    {
        return new PagedResponse(Type.SUCCESS, msg, data,count);
    }

    /**
     * 返回失败消息
     *
     * @return 成功消息
     */
    public static PagedResponse fail()
    {
        return PagedResponse.fail("操作失败");
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static PagedResponse fail(String msg)
    {
        return PagedResponse.fail(msg, null);
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
    public static PagedResponse fail(String msg, Object data)
    {
        return new PagedResponse(Type.FAIL, msg, data);
    }

    /**
     * 返回警告消息
     * 
     * @param msg 返回内容
     * @return 警告消息
     */
    public static PagedResponse warn(String msg)
    {
        return PagedResponse.warn(msg, null);
    }

    /**
     * 返回警告消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static PagedResponse warn(String msg, Object data)
    {
        return new PagedResponse(Type.WARN, msg, data);
    }

    /**
     * 返回错误消息
     * 
     * @return
     */
    public static PagedResponse error()
    {
        return PagedResponse.error("操作失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回内容
     * @return 警告消息
     */
    public static PagedResponse error(String msg)
    {
        return PagedResponse.error(msg, null);
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static PagedResponse error(String msg, Object data)
    {
        return new PagedResponse(Type.ERROR, msg, data);
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
