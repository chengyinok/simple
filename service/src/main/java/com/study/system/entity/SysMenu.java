package com.study.system.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author chengyin123
 * @since 2018-01-03
 */
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "menuId", type = IdType.AUTO)
    private Integer menuId;
    /**
     * 父节点ID
     */
    @TableField("parentId")
    private Integer parentId;
    /**
     * 菜单名称
     */
    @TableField("menuName")
    private String menuName;
    /**
     * 请求路径
     */
    @TableField("menuPath")
    private String menuPath;
    /**
     * 组件路径
     */
    private String components;
    /**
     * 菜单标题
     */
    @TableField("menuTitle")
    private String menuTitle;
    /**
     * 图标
     */
    @TableField("menuIcon")
    private String menuIcon;
    /**
     * 是否隐藏
     */
    @TableField("isHidden")
    private Boolean isHidden;
    /**
     * 是否缓存
     */
    @TableField("isCache")
    private Boolean isCache;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<SysMenu> children;


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Boolean getCache() {
        return isCache;
    }

    public void setCache(Boolean cache) {
        isCache = cache;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "menuId=" + menuId +
                ", parentId=" + parentId +
                ", menuName='" + menuName + '\'' +
                ", menuPath='" + menuPath + '\'' +
                ", components='" + components + '\'' +
                ", menuTitle='" + menuTitle + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", isHidden=" + isHidden +
                ", isCache=" + isCache +
                ", children=" + children +
                '}';
    }
}
