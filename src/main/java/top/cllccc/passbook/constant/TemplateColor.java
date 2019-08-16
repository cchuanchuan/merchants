package top.cllccc.passbook.constant;

/**
 *
 * */
//枚举类型
public enum TemplateColor {

    RED(1, "红色"),
    GREED(2, "绿色"),
    BLUE(3, "蓝色");

    /** 背景颜色代码*/
    private Integer code;

    /** 颜色描述*/
    private String color;

    TemplateColor(Integer code,String color){
        this.code = code;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
